package main.java.headfirst.combined.djview;

public class TestDriveThree {
	
	public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
		
		HeartModelInterface heart = HeartModel.getInstance();
		ControllerInterface controller2 = new HeartController(heart);
		
		TimerModelInterface timer = new PomodoroModel();
		ControllerInterface controller3 = new PomodoroControlleryVista(timer);
		
		
    }

}
