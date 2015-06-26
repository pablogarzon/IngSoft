package main.java.headfirst.combined.djview;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
	HeartAdapter modelAdapter;
	DJViewSingleton viewSingleton;

	public HeartController(DJViewSingleton viewSingleton,
			HeartModelInterface model) {
		this.model = model;
		this.modelAdapter = new HeartAdapter(model);
		this.viewSingleton = viewSingleton;
		this.viewSingleton.setModel(modelAdapter);
		this.viewSingleton.setController(this);

		this.viewSingleton.disableStopMenuItem();
		this.viewSingleton.disableStartMenuItem();

		this.viewSingleton.disableHeartMenuItem();
		this.viewSingleton.enablePomodoroMenuItem();
		this.viewSingleton.enableBeatMenuItem();
	}

	public HeartController(HeartModelInterface model) {
		this.model = model;
		modelAdapter = new HeartAdapter(model);
		view = new DJView(this, modelAdapter);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}

	public void start() {
	}

	public void stop() {
		try {
			model.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void increaseBPM() {

		// tratar de generar una nueva instancia de HeartModel
		HeartModel modelo = HeartModel.getInstance();
		modelo.notifyBPMObservers();
	}

	public void decreaseBPM() {
	}

	public void setBPM(int bpm) {
	}

	public void setModel(HeartAdapter modelAdapter) {
		this.modelAdapter = modelAdapter;
	}

	public void setView(DJView view) {
		this.view = view;
	}

	@Override
	public void startSingleton() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopSingleton() {
		// TODO Auto-generated method stub

	}

}
