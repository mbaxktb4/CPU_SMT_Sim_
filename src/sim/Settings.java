package sim;


public class Settings {

	private double 	mClockSpeed = 1.0;		// in Hz (We will be using a slow cpu in order to follow the examples.
	private int 	mMemToRegLatency = 3; 	// In CPU cycles (Bares no resemblence of anything physical)
	

	protected Settings(){
	}
	
	
	public double getClockSpeed(){
		return this.mClockSpeed;
	}
	
	public int getMemToRegLatency(){
		return this.mMemToRegLatency;
	}
	
	/**
	 * Static singleton stuff. Hidden out of the way down here
	 */
	
	private static Settings mSettings;   
	public static Settings getSettings(){
		if(mSettings == null){
			mSettings= new Settings();
		}
		return mSettings;
	}	
}