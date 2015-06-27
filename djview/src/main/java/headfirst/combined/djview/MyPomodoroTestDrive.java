package main.java.headfirst.combined.djview;

public class MyPomodoroTestDrive {
	
	public static void main (String[] args){
	
	TimerModelInterface timer = new PomodoroModel();
	ControllerInterface timercontroller = new PomodoroController(timer);
	}

}
