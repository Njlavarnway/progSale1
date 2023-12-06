package salerecordpack;

public class Timer extends program1 {
	
	private long startTime;
	private long endTime;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		endTime = System.currentTimeMillis();
	}

	
	//Calculated time from start to finish and convert from milliseconds to seconds
	public double getTimeTaken(){
		long timeElapsed = endTime - startTime;
		return timeElapsed / 1000.0;
	}
	
}
