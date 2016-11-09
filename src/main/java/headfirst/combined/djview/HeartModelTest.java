package main.java.headfirst.combined.djview;


public class HeartModelTest {

	//@Test
	public void testGetInstance() {
		HeartModel modelo1 = HeartModel.getInstance();
		HeartModel modelo2 = HeartModel.getInstance();
		boolean test=true;
		if (modelo1.getHeartRate()==0){
			test=false;
		}
		//assertTrue("se creo una sola vez",test);
	}

}
