package main.java.headfirst.combined.djview;

import static org.junit.Assert.*;

import org.junit.Test;

public class PomodoroModelTest {

	PomodoroModel model = new PomodoroModel();

	@Test
	public void testSetMinutos() {
		model.setMinutos(-3);
		assertTrue("no acepta nrs negativos", (model.minutos >= 0));
	}


	@Test
	public void testIniciar() {
		model.setMinutos(2);
		model.preparar();
		model.iniciar();
		assertTrue("sequencer empezó", model.sequencer.isRunning());
	}

	@Test
	public void testTerminar() {
		model.setMinutos(2);
		model.preparar();
		model.iniciar();
		model.terminar();
		assertFalse("sequencer terminó", model.sequencer.isRunning());
	}

	@Test
	public void testSonido() {
		model.setMinutos(2);
		model.preparar();
		model.iniciar();
		model.sonido(false);
		assertFalse("sonido apagado", model.sequencer.isRunning());
		
	}
	
	@Test
	public void testSonido2() {
		model.setMinutos(2);
		model.preparar();
		model.iniciar();
		model.sonido(false);
		model.sonido(true);
		assertTrue("sequencer volvió a funcionar", model.sequencer.isRunning());
		
	}

}
