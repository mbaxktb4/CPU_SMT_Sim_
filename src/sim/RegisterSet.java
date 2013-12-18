package sim;

public class RegisterSet {

	private Register[] mGPR = new Register[32];
	
	public RegisterSet(){
		for(int i = 0; i < mGPR.length; i++){
			mGPR[i] = new Register();
		}
	}
	
	public int getRegisterValue(int regNum){
		return mGPR[regNum].getRegVal();
	}
	
	public void setRegisterValue(int regNum, int regVal){
		this.mGPR[regNum].setRegVal(regVal);
	}
	
	
	public boolean getRegisterInUse(int regNum){
		return mGPR[regNum].getRegUse();
	}
	
	public void setRegisterInUse(int regNum, boolean b){
		this.mGPR[regNum].setRegUse(b);
	}
	
}
