package sim.ISA;

public abstract class ISA_Base {

	protected String mOpCode;
	protected String mOpType;
	protected boolean mDispatchReady = false;
	
	public String getOpCode(){
		return this.mOpCode;
	}
	
	public String getOpType(){
		return this.mOpType;
	}
	
	public boolean getDispatchReady(){
		return this.mDispatchReady;
	}
	
	public void setDispatchReady(boolean b){
		this.mDispatchReady = b;
	}
	
}
