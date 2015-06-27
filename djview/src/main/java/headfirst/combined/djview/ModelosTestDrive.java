package main.java.headfirst.combined.djview;

public class ModelosTestDrive {

	BeatModelInterface model;
	ControllerInterface controller;
	HeartAdapter modelAdapter;
	DJViewSingleton viewSingleton;

	public ModelosTestDrive() {

		model = new BeatModel();
		controller = new BeatController(viewSingleton, model);
	}

	

}
