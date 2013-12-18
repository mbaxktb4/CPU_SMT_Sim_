package sim.pipelineelements;

import sim.programs.Program1;



public class InsFetchPlusPC {

	// Program counter is attached to this insfetch. Because we are Having a PC for each logical core impl
	private ProgCounter mProgramCounter;
	//TODO Haphazard placement of program to execute.
	// We will keep this here for simplicity
	private Program1 mProgram;
	
	public InsFetchPlusPC(){
		this.mProgramCounter = new ProgCounter();
		this.mProgram = new Program1();
	}
	
	/**
	 * This will always be called. If the pipeline is stalled however it will be called but return null (our nop)
	 * @return Instruction or nop
	 */
	public String update(){
		
		// IF NOT stalled
		//TODO impl stalling
		if(true){
			String ins = mProgram.getInstruction((int) (mProgramCounter.getPC()/4));
			mProgramCounter.update();
			return ins;
		}
		
		
		return null;
	}
}
