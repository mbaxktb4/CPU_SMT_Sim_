package sim.programs;

import java.util.ArrayList;

public class Program1 {

	private ArrayList<String> mInstructions = new ArrayList<String>();
	
	
	public Program1(){
		this.mInstructions.add("LW $1 12345");
		this.mInstructions.add("LW $2 12345");
		this.mInstructions.add("ADD $1 $2 $3");
		this.mInstructions.add("MV $3 $4");
		this.mInstructions.add("SUB $3 $4 $1");
		this.mInstructions.add("MUL $3 $4 $6");
		this.mInstructions.add("MUL $3 $3 $7");

		this.mInstructions.add("MUL $30 $24 $30");
		this.mInstructions.add("SW $1");
	}
	
	public String getInstruction(int pos){
//		int posToReturn = pos % mInstructions.size()*2;
		if(pos >= mInstructions.size())
			return null;
		return mInstructions.get(pos);
	}
}
