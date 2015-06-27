package main.java.headfirst.combined.djview;

public interface TimerModelInterface {
	
	void preparar();
	void setMinutos(int min);
	int getMinutos();
	void iniciar();
	void terminar();
	void sonido();
	
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
}
