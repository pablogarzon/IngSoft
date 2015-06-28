package main.java.headfirst.combined.djview;

import static org.junit.Assert.*;

import org.junit.Test;

public class PomodoroControllerTest {
	PomodoroModel p = new PomodoroModel();
	PomodoroController c = new PomodoroController(p);
	
	@Test
	public void testStart() {
		p.setMinutos(2);
		c.start();
		assertTrue("Modelo andando", p.sequencer.isRunning());
	}

	@Test
	public void testStop() {
		p.setMinutos(3);
		c.start();
		c.stop();
		assertFalse("Modelo apagado", p.sequencer.isRunning());
	}

	@Test
	public void testIncreaseBPM1() {
		p.setMinutos(3);
		c.start();
		c.increaseBPM();
		assertTrue("sonido sigue prendido", p.sequencer.isRunning());
	}
	
	@Test
	public void testIncreaseBPM2() {
		p.setMinutos(3);
		c.start();
		c.decreaseBPM();
		c.increaseBPM();
		assertTrue("sonido sigue prendido", p.sequencer.isRunning());
	}

	@Test
	public void testDecreaseBPM() {
		p.setMinutos(3);
		c.start();
		c.decreaseBPM();
		assertFalse("sonido se apago", p.sequencer.isRunning());
	}

	@Test
	public void testSetBPM() {
		c.setBPM(5);
		assertEquals("bpm son minutos", 5, p.minutos);
	}

}
