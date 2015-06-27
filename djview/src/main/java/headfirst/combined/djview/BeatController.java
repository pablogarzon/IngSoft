package main.java.headfirst.combined.djview;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;
	DJViewSingleton viewSingleton;

	public BeatController(DJViewSingleton viewSingleton,
			BeatModelInterface model) {
		this.model = model;
		this.viewSingleton = DJViewSingleton.getInstance(this, model);

		this.viewSingleton.disableStopMenuItem();
		this.viewSingleton.enableStartMenuItem();

		this.viewSingleton.enableHeartMenuItem();
		this.viewSingleton.enablePomodoroMenuItem();
		this.viewSingleton.disableBeatMenuItem();

		model.initialize();
	}

	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(this, model);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}

	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

	public void increaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm + 1);

	}

	public void decreaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm - 1);
	}

	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}

	public void setModel(BeatModelInterface model) {
		this.model = model;
	}

	@Override
	public void startSingleton() {
		model.on();
		viewSingleton.disableStartMenuItem();
		viewSingleton.enableStopMenuItem();
	}

	@Override
	public void stopSingleton() {
		model.off();
		viewSingleton.disableStopMenuItem();
		viewSingleton.enableStartMenuItem();
	}

}
