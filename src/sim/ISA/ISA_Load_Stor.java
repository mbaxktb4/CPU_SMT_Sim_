package sim.ISA;

public abstract class ISA_Load_Stor extends ISA_Base{
	
	protected int mRDReg;
	protected int mRDRegVal;
	protected boolean mRDRegToken = false;
	
	public ISA_Load_Stor(){
		this.mOpType = "I";
	}
	
	public int getRDReg(){
		return this.mRDReg;
	}
	
	public void setRDReg(int rdReg){
		this.mRDReg = rdReg;
	}
	
	public int getRDRegVal(){
		return this.mRDRegVal;
	}
	
	public void setRDRegVal(int rdRegVal){
		this.mRDRegVal = rdRegVal;
	}
	
	public boolean getRDRegToken(){
		return this.mRDRegToken;
	}
	public void setRDRegToken(boolean rdRegToken){
		this.mRDRegToken = rdRegToken;
		this.verifyDispatchReady();
	}	

	// TODO is this the best way?
	/** Automagically call this whenever state of registers changes.
	 * 
	 */
	public void verifyDispatchReady(){
		if(this.mRDRegToken){
			this.mDispatchReady = true;
		}
	}
}
