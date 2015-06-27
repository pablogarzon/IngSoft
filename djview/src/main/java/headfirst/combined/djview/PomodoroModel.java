package main.java.headfirst.combined.djview;
import java.util.ArrayList;
import javax.sound.midi.*;
import java.util.Timer;
import java.util.TimerTask;
public class PomodoroModel implements TimerModelInterface,MetaEventListener {
	
	Sequencer sequencer;
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
    int bpm = 60;
    int minutos;
    Sequence sequence;
    Track track;
    Timer timer;
    int[] trackList = {50, 0, 0, 0};
    int[] trackend = {81, 0, 0, 0};
	
	public void preparar(){
		setUpMidi();
        buildTrackAndStart(trackList);
	}
	
	public void setMinutos(int minutos){	this.minutos = minutos;	}
	
	public int getMinutos(){return minutos;}
	
	public void iniciar(){
		
		setUpMidi();
        buildTrackAndStart(trackList);
        sequencer.start();
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new Task(), 0, 60000); //cada segundo - después se implementa para cada minuto
	}
	
	class Task extends TimerTask {
		   
        public void run() {
        	//lo que se ejecuta cada minuto
        	if(minutos>0){
            notifyBPMObservers();
            minutos--;}
        	//lo que se ejecuta cuando el pomodoro se terminó
        	else if(minutos==0) {
        	sequencer.stop();
        	timer.cancel();
        	setUpMidi();
            buildTrackAndStart(trackend);
            sequencer.start();
        	timer = new Timer();
        	timer.scheduleAtFixedRate(new Task(), 0, 1000); //cada segundo - después se implementa para cada minuto
            minutos--;
        	}
            else if(minutos<0){ 
            terminar();
        	}
        }
    }
	
	
	public void terminar(){
		timer.cancel();
		sequencer.stop();
		minutos=0;
        notifyBPMObservers();
	}
	
	
	public void sonido(boolean b){
		//apaga el sequencer si el timer está prendido y el sequencer está andando
		if(minutos>=0 && sequencer.isRunning() && b==false)
			sequencer.stop();
		if(minutos>=0 && !sequencer.isRunning() && b==true){
			setUpMidi();
        	buildTrackAndStart(trackList);
    		sequencer.start();}
								
	
	}	

	public void beatEvent() { notifyBeatObservers();}
	
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
  
	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}
  
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
  
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}


	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}



	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}
	
//funciones que tienen que ver con el sonido
	
    public void meta(MetaMessage message) {
//        if (message.getType() == 47) {
//			beatEvent();
//        	sequencer.start();
//        	setBPM(getBPM());
//        }
    	
    	//FIX
    	if (message.getType() == 0x2F ) {
			beatEvent();
			sequencer.setMicrosecondPosition(0);
            sequencer.setTickPosition(0) ; 
            sequencer.start(); 
        	//setBPM(60);	
        }
    }

	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			
			//Fix
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(60);
		} catch(Exception e) {
				e.printStackTrace();
		}
    } 

     public void buildTrackAndStart(int[] trackList) {
        
    
        sequence.deleteTrack(null);
        track = sequence.createTrack();

      	makeTracks(trackList);
		track.add(makeEvent(192,9,1,0,4));      
	 	try {
			sequencer.setSequence(sequence);                    
		} catch(Exception e) {
			e.printStackTrace();
		}
    } 
            
    public void makeTracks(int[] list) {        
       
       for (int i = 0; i < list.length; i++) {
          int key = list[i];

          if (key != 0) {
             track.add(makeEvent(144,9,key, 100, i));
             track.add(makeEvent(128,9,key, 100, i+1));
          }
       }
    }
        
    public  MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
            
        } catch(Exception e) {
			e.printStackTrace(); 
		}
        return event;
    }
}

