package main.java.headfirst.combined.djview;
  
public class DJTestDrive {

    public static void main (String[] args) {
    	BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
		
		HeartModelInterface model1 = HeartModel.getInstance();
		ControllerInterface controller1 = new HeartController(model1);
		
		BeatModelInterface model3 = new PomodoroModel();
		ControllerInterface controller2 = new BeatController(model3);
		
    }
}
