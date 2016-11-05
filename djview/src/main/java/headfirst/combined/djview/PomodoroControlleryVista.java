package main.java.headfirst.combined.djview;

public class PomodoroControlleryVista implements ControllerInterface {
	
	TimerModelInterface model;
	PomodoroView view;
	
	public PomodoroControlleryVista(TimerModelInterface model){
		this.model = model;
		view = new PomodoroView(this, new TimerAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.preparar();
	}
	
	public void start(){
		model.iniciar();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
	public void stop(){
		model.terminar();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
	public void increaseBPM(){ model.sonido(true);} //prender el sonido
	public void decreaseBPM(){ model.sonido(false);} //apagar el sonido
 	public void setBPM(int bpm){model.setMinutos(bpm);}

	public PomodoroView getView() {
		return view;
	}

	

}
