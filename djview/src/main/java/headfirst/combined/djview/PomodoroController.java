package main.java.headfirst.combined.djview;

public class PomodoroController implements ControllerInterface {
	
	BeatModelInterface model;
	PomodoroView view;
	//DJView view2;
	
	
	public PomodoroController(BeatModelInterface model){
		//inicializar la vista
		this.model = model;
		
		view = new PomodoroView(this, model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		

//		view2 = new DJView(this, model);
//        view2.createView();
//        view2.createControls();
//		view2.disableStopMenuItem();
//		view2.enableStartMenuItem();
		
		model.initialize();
	}
	
	public void start(){
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
		
//		view2.disableStartMenuItem();
//		view2.enableStopMenuItem();
	
	}
	public void stop(){
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		
//		view2.disableStopMenuItem();
//		view2.enableStartMenuItem();

	}
	public void increaseBPM(){
		model.setBPM(-1);
	}
	public void decreaseBPM(){
		model.setBPM(-2);
	}
 	public void setBPM(int bpm){
 		model.setBPM(bpm);
 	}
	
	

}
