package main.java.headfirst.combined.djview;

public class TodoTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeatModelInterface dj = new BeatModel();
		ControllerInterface controller1 = new BeatController(dj);
		
		HeartModelInterface heart = HeartModel.getInstance();
		ControllerInterface controller2 = new HeartController(heart);
		
		TimerModelInterface timer = new PomodoroModel();
		ControllerInterface controller3 = new PomodoroControlleryVista(timer);
		
	}

}
