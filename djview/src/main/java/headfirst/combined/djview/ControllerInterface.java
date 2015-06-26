package main.java.headfirst.combined.djview;
  
public interface ControllerInterface {
	void start();
	void stop();
	void increaseBPM();
	void decreaseBPM();
 	void setBPM(int bpm);
 	
 	public void setModel(BeatModelInterface model);
 	
 	public void setView (DJView view);
 	
 	public DJView getView();
 	
}