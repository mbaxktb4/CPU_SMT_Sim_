package sim;

import java.util.Date;



public class Sim_Core implements Runnable{
//
	Clock clock = new Clock();
	Pipeline mPipeline;

	protected Sim_Core(){

		mPipeline = new Pipeline();
		
		Thread t = new Thread(this);
		t.start();
	}
	
	
	
	/**
	 * Static singleton stuff. Hidden out of the way down here
	 */
	
	private static Sim_Core sCore;   
	public static Sim_Core getCore(){
		if(sCore == null){
			sCore= new Sim_Core();
		}
		return sCore;
	}
	@Override
	public void run() {
		while(true){	
		
			// Temp!
			Date date = new Date();
			System.out.println("Sec:"+date.getSeconds() + " Tick.");
			
			
			this.mPipeline.clockTick();
			
			// Wait now until the next clock cycle.
			clock.pauseUntilNextClock();
		}
		
	}    
}