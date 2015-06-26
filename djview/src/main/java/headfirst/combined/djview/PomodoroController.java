package main.java.headfirst.combined.djview;

public class PomodoroController implements ControllerInterface {
	
	BeatModelInterface model;
	DJView view;
	DJViewSingleton viewSingleton;
	
	public PomodoroController(DJViewSingleton viewSingleton,BeatModelInterface model){
		this.model = model;
		this.viewSingleton = viewSingleton;
		this.viewSingleton.setModel(model);
		this.viewSingleton.setController(this);
		
		this.viewSingleton.createView();
		this.viewSingleton.createControls();
		this.viewSingleton.disableStopMenuItem();
		this.viewSingleton.enableStartMenuItem();
		model.initialize();
	}
	
	public PomodoroController(BeatModelInterface model){
		//inicializar la vista
		this.model = model;
		view = new DJView(this, model);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}
	
	public void start(){
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
	public void stop(){
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
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

	
 	public void setModel(BeatModelInterface model){
 		this.model=model;
 	}
 	
 	public void setView (DJView view){
 		this.view=view;
 	}

	@Override
	public DJView getView() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
