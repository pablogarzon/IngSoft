package main.java.headfirst.combined.djview;

public class TimerAdapter implements BeatModelInterface {
	
	TimerModelInterface timer;
	public TimerAdapter(TimerModelInterface timer){
		this.timer = timer;
	}
	
	public void initialize(){timer.preparar();}
	  
	public void on(){timer.iniciar();}
  
	public void off(){timer.terminar();}
  
    public void setBPM(int bpm){
    	timer.setMinutos(bpm);
    }
  
	public int getBPM(){return timer.getMinutos();}
  
	public void registerObserver(BeatObserver o){ timer.registerObserver(o);	}
  
	public void removeObserver(BeatObserver o){timer.removeObserver(o);}
  
	public void registerObserver(BPMObserver o){timer.registerObserver(o);}
  
	public void removeObserver(BPMObserver o){timer.removeObserver(o);}

}
