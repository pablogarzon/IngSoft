package main.java.headfirst.combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
	HeartAdapter modelAdapter;
  
	public HeartController() {}
		

	public HeartController(HeartModelInterface model) {
		this.model = model;
		modelAdapter= new HeartAdapter(model);
		view = new DJView(this, modelAdapter);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		
		//tratar de generar una nueva instancia de HeartModel
				HeartModel modelo = HeartModel.getInstance();
				modelo.notifyBPMObservers();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}

 	public void setModel(HeartAdapter modelAdapter){
 		this.modelAdapter=modelAdapter;
 	}
 	
 	public void setView (DJView view){
 		this.view=view;
 	}


	@Override
	public void setModel(BeatModelInterface model) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public DJView getView() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
