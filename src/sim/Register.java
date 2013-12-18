package sim;

public class Register {

	private int mRegVal = 0;
	private boolean mRegInUse = false;
	
	public Register(){
	}
	
	public void setRegVal(int regVal){
		this.mRegVal = regVal;
	}
	
	public int getRegVal(){
		return this.mRegVal;
	}
	
	public void setRegUse(boolean b){
		this.mRegInUse = b;
	}
	
	public boolean getRegUse(){
		return this.mRegInUse;
	}
	
}
