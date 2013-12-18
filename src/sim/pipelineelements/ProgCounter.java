package sim.pipelineelements;

public class ProgCounter {

	private long mProgramCounter;
	
	public void update(){
		System.out.println("PC: "+ this.mProgramCounter);
		this.mProgramCounter +=4;
		//TODO Branch ALU behaviour
	}
	
	public long getPC(){
		return this.mProgramCounter;
	}
	
	/**
	 * Used for jump
	 * @param pc
	 */
	public void setPC(long pc){
		this.mProgramCounter = pc;
	}
}
