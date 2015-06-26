package main.java.headfirst.combined.djview;

public class Modelos implements ModelosInterface {
	
	BeatModelInterface model;
	HeartModelInterface model1;
	BeatModelInterface model3;
	
	ControllerInterface controller;
	ControllerInterface controller1;
	ControllerInterface controller2;
	
	HeartAdapter modelAdapter;
	DJViewSingleton viewSingleton;
	
	public Modelos(){
		model = new BeatModel();
		controller = new BeatController(viewSingleton,model);
		
		//model1 = HeartModel.getInstance();
		//modelAdapter = new HeartAdapter(model1); 
		//controller1 = new HeartController();
		//controller1.setModel(modelAdapter);
		//controller1.setView(controller.getView());
		
		
		//model3 = new PomodoroModel();
		//controller2 = new PomodoroController();
		//controller2.setModel(model3);
		//controller2.setView(controller.getView());
	}
	
	
	public BeatModelInterface getModelBeat() {
		return model;
	}

	
	public ControllerInterface getControllerBeat() {
		return controller;
	}

	
	public HeartAdapter getModelHeart() {
		return modelAdapter ;
	}

	
	public ControllerInterface getControllerHeart() {
		return controller1;
	}

	
	public BeatModelInterface getModelPomodoro() {
		return model3;
	}

	
	public ControllerInterface getControllerPomodoro() {
		return controller2;
	}
	 
}
