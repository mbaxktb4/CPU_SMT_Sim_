package sim.pipelineelements;

import sim.ISA.*;

public class InsDecode {

	public InsDecode(){
		
	}
	
	private static final String ADD = "ADD";
	private static final String SUB = "SUB";
	private static final String MUL = "MUL";
	private static final String DIV = "DIV";
	private static final String LW = "LW";
	private static final String SW = "SW";
	
	
	
	public ISA_Base instructionDecode(String ins){
		
		ISA_Base instruction = null;
		
		if(ins == null)
			return null;
		
		// Identify the part of instruction that is the op code
		
		if(ins.contains(ADD)){
			instruction = new ISA_ADD();
			return setRTypeInstruction((ISA_R_Type)instruction, ins);
		}else if(ins.contains(SUB)){
			instruction = new ISA_SUB();
			return setRTypeInstruction((ISA_R_Type)instruction, ins);
			
		}else if(ins.contains(MUL)){
			instruction = new ISA_MUL();
			return setRTypeInstruction((ISA_R_Type)instruction, ins);

		}else if(ins.contains(DIV)){
			instruction = new ISA_DIV();
			return setRTypeInstruction((ISA_R_Type)instruction, ins);
			
		}else if(ins.contains(LW)){
			instruction = new ISA_LW();
			return setLSTypeInstruction((ISA_Load_Stor)instruction, ins);
			
		}else if(ins.contains(SW)){
			instruction = new ISA_SW();
			return setLSTypeInstruction((ISA_Load_Stor)instruction, ins);
		}
		
		
		//TODO Any more ISA
	
		
		
		
		
		return null;
	}
	
	private ISA_Base setLSTypeInstruction(ISA_Load_Stor instruction, String ins){
		ins = ins.replace("$", "");
		String[] split = ins.split(" ");
		instruction.setRDReg(Integer.parseInt(split[1]));
		return instruction;
	}
	
	private ISA_Base setRTypeInstruction(ISA_R_Type instruction, String ins){
		ins = ins.replace("$", "");
		String[] split = ins.split(" ");
		instruction.setRSReg(Integer.parseInt(split[1]));
		instruction.setRTReg(Integer.parseInt(split[2]));
		instruction.setRDReg(Integer.parseInt(split[3]));
		return instruction;
	}
	
	
}
