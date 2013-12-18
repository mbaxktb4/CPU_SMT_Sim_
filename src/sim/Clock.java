package sim;

public class Clock {
	private long mStartOfClock;
	
	public Clock(){
		 this.mStartOfClock = System.currentTimeMillis();
	}
	
	public void setClockStart(){
		this.mStartOfClock = System.currentTimeMillis();
	}
	
	public void discription(){
		
	}
	
	/**
	 * Stop execution until next clock cycle. 
	 * It does all the clock measurements. Just call it once per cycle.
	 */
	public void pauseUntilNextClock(){
		long sleepTime = (long) (1000.0 / Settings.getSettings().getClockSpeed())
				- (System.currentTimeMillis() - this.mStartOfClock);
		
		if(sleepTime > 0){
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("WARNING: System cannot keep up with simulator clock speed!");
			System.out.println("WARNING: Reduce clock speed!");
			}
		
		this.mStartOfClock = System.currentTimeMillis();
	}
}
