package jbehave.test;



import static org.junit.Assert.assertFalse;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import main.java.headfirst.combined.djview.PomodoroControlleryVista;
import main.java.headfirst.combined.djview.PomodoroModel;
import main.java.headfirst.combined.djview.TimerModelInterface;

public class PasosTestPomodoro{
	
	
	PomodoroModel timer;
	PomodoroControlleryVista timercontroller;

	
	@Given("el usuario setea un valor en minutos e inicia el PomodoroTimer")
	public void givenElUsuarioSeteaUnValorEnMinutosEIniciaElPomodoroTimer() throws InterruptedException{
		
		timer=new PomodoroModel();
		timercontroller=new PomodoroControlleryVista(timer);
		
		Thread.sleep(1500);
		
		 this.timercontroller.getView().getBpmTextField().setText("2");
		 
		 Thread.sleep(1500);
		 
		 this.timercontroller.getView().getSetBPMButton().doClick();
		 
		 Thread.sleep(1500);
		 
		 this.timercontroller.getView().getMenu().doClick();
		 
		 Thread.sleep(1500);
		 
		 this.timercontroller.getView().getStartMenuItem().doClick();
		 
		 Thread.sleep(1500);
	}
	
	@When("el usuario pulsa el boton mute")
	public void whenElUsuarioPulsaElBotonMute() throws InterruptedException{
		
		Thread.sleep(1500);

		this.timercontroller.getView().getDecreaseBPMButton().doClick();
		
		Thread.sleep(1500);
		
	}
	
    @Then("el sonido del PomodoroTimer se apaga")
	
	public void thenElSonidoDelPomodoroTimerSeApaga() throws InterruptedException{
    	
    	Thread.sleep(1500);

		assertFalse("sonido se apago", timer.getSequencer().isRecording());
		
	}
}