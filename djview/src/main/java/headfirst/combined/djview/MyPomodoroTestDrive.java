package main.java.headfirst.combined.djview;

public class MyPomodoroTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeatModelInterface pomodoro = new PomodoroModel();
		ControllerInterface control = new PomodoroController(pomodoro);
		
	}

}
