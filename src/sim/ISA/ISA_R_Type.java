package sim.ISA;

public abstract class ISA_R_Type extends ISA_Base {
	
	// Register numbers
	protected int mRSReg;
	protected int mRTReg;
	protected int mRDReg;
	
	// Register values copy from/to
	protected int mRSRegVal;
	protected int mRTRegVal;
	protected int mRDRegVal;

	protected boolean mRSRegToken = false;
	protected boolean mRTRegToken = false;
	protected boolean mRDRegToken = false;
	
	public ISA_R_Type(){
		this.mOpType = "R";
	}
	
	public int getRSReg(){
		return this.mRSReg;
	}
	public void setRSReg(int rsReg){
		this.mRSReg = rsReg;
	}
	
	public int getRTReg(){
		return this.mRTReg;
	}
	public void setRTReg(int rtReg){
		this.mRTReg = rtReg;
	}
	
	public int getRDReg(){
		return this.mRDReg;
	}
	public void setRDReg(int rdReg){
		this.mRDReg = rdReg;
	}
	
	
	public int getRSRegVal(){
		return this.mRSRegVal;
	}
	public void setRSRegVal(int rsRegVal){
		this.mRSRegVal = rsRegVal;
	}	
	
	public int getRTRegVal(){
		return this.mRTRegVal;
	}
	public void setRTRegVal(int rtRegVal){
		this.mRTRegVal = rtRegVal;
	}	
	
	public int getRDRegVal(){
		return this.mRDRegVal;
	}
	public void setRDRegVal(int rdRegVal){
		this.mRDRegVal = rdRegVal;
	}
	
	
	public boolean getRSRegToken(){
		return this.mRSRegToken;
	}
	public void setRSRegToken(boolean rsRegToken){
		this.mRSRegToken = rsRegToken;
		this.verifyDispatchReady();
	}	
	
	public boolean getRTRegToken(){
		return this.mRTRegToken;
	}
	public void setRTRegToken(boolean rtRegToken){
		this.mRTRegToken = rtRegToken;
		this.verifyDispatchReady();
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
		if(this.mRDRegToken &&
				this.mRSRegToken &&
				this.mRTRegToken
				){
			this.mDispatchReady = true;
		}
	}
}
