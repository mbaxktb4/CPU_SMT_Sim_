package sim.pipelineelements;

import java.util.ArrayList;

import sim.RegisterSet;
import sim.ISA.ISA_Base;
import sim.ISA.ISA_Load_Stor;
import sim.ISA.ISA_R_Type;

public class InsDespatch {

	private RegisterSet mRegisterSet;
	private ArrayList<ISA_Base> mReservationBuffer = new ArrayList<ISA_Base>();

	
	public InsDespatch(RegisterSet regSet){
		this.mRegisterSet = regSet;
	}
	
	public void addInstructionToReservationBuffer(ISA_Base ins){
		if(ins == null)
			return;
		
		this.mReservationBuffer.add(ins);
		if(ins.getOpType() == "R"){
			// See if RS,RT,RD are not being used
			ISA_R_Type instruction = (ISA_R_Type)ins;

			boolean rs = false;
			boolean rt = false;
			boolean rd = false;
			// We set these variables to true if we now have access to them
			if(!this.mRegisterSet.getRegisterInUse(  instruction.getRSReg() )){
				rs = true;
			}
			
			if(!this.mRegisterSet.getRegisterInUse(  instruction.getRTReg() )){
				rt = true;
			}
			
			if(!this.mRegisterSet.getRegisterInUse(  instruction.getRDReg() )){
				rd = true;
			}
			
			// If these variables are true. We claim them
			// THis is done as such so that we dont get instructions like 
			// add $20 $10 $20 locking  itself up

			if(rs){
				// It is not in use
				// We assign it and give this instruction the token
				this.mRegisterSet.setRegisterInUse(instruction.getRSReg(), true);
				instruction.setRSRegToken(true);
				// Assign the value from register into the instruction
				instruction.setRSRegVal(this.mRegisterSet.getRegisterValue(instruction.getRSReg()));
			}
			
			if(rt){
				// It is not in use
				// We assign it and give this instruction the token
				this.mRegisterSet.setRegisterInUse(instruction.getRTReg(), true);
				instruction.setRTRegToken(true);		
				// Assign the value from register into the instruction
				instruction.setRTRegVal(this.mRegisterSet.getRegisterValue(instruction.getRTReg()));
			}
			if(rd){
				// It is not in use
				// We assign it and give this instruction the token
				this.mRegisterSet.setRegisterInUse(instruction.getRDReg(), true);
				instruction.setRDRegToken(true);
				// Assign the value from register into the instruction
				instruction.setRDRegVal(this.mRegisterSet.getRegisterValue(instruction.getRDReg()));
			}
			
		}else if(ins.getOpType() == "I"){
			// If i fits i sits.
			
			ISA_Load_Stor instruction = (ISA_Load_Stor)ins;
			if(!this.mRegisterSet.getRegisterInUse(  instruction.getRDReg() )){
				// It is not in use
				// We assign it and give this instruction the token
				this.mRegisterSet.setRegisterInUse(instruction.getRDReg(), true);
				instruction.setRDRegToken(true);
				// Assign the value from register into the instruction
				instruction.setRDRegVal(this.mRegisterSet.getRegisterValue(instruction.getRDReg()));
			}
			
		}
	}
	
	
	public void searchReservationBufferForDespatch(){
		for(int i = 0; i < mReservationBuffer.size(); i++){
			if(mReservationBuffer.get(i).getDispatchReady()){
				// This instruction is ready to be dispatched.
			}
		}
	}
	
	public ArrayList<ISA_Base> getResevationBuffer(){
		return this.mReservationBuffer;
	}
}
