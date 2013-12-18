package sim;

import java.util.ArrayList;

import sim.ISA.ISA_Base;
import sim.pipelineelements.InsDecode;
import sim.pipelineelements.InsDespatch;
import sim.pipelineelements.InsFetchPlusPC;

/**
 * Contains entire pipeline. May consist of more than 1 SMT logical cores + strictly 1 physical
 * @author Tim
 *
 */
public class Pipeline {
	private RegisterSet 	mRegisterSet;

	private InsFetchPlusPC 	mInsFetchPhyCore;
	private InsDecode		mInsDecode;
	private InsDespatch 	mInsDespatch;
	
	
	public Pipeline(){
		this.mRegisterSet			= new RegisterSet();
		
		this.mInsFetchPhyCore 		= new InsFetchPlusPC();
		this.mInsDecode				= new InsDecode();
		this.mInsDespatch			= new InsDespatch(this.mRegisterSet);
		
		mExecuteQueue 				= new ArrayList<ISA_Base>();
	}
	
	private String mDecodeInput;
	private ISA_Base mDespatchInput;
	private ArrayList<ISA_Base> mExecuteQueue;
	
	public void clockTick(){
		
		// Clock tick
		// First stage. Fetch instruction
		// If we are using SMT we will need more than 1 fetch and program counter. 
		
		/**
		 * INSTRUCTION FETCH PHASE 
		 */
		
		// This is the instruction outputted
		String insFetchPhyCoreOutput = this.mInsFetchPhyCore.update();
		System.out.println("PhyCoreOutput: "+ insFetchPhyCoreOutput);
		
		// Instruction decode phase
		// We decode what the instruction means here
		// This will then allow us to flag out the reg's in next stage.
		ISA_Base insDecodePhyCoreOutput = this.mInsDecode.instructionDecode(this.mDecodeInput);
		
		/**
		 * RESERVATION PHASE
		 */
		
		
		// InsDespatch phase
		// We take the decoded instruction and prepare it for despatch here. 
		// Checking to see if the registers are available. 
		// If the registers are not available we wait in reservation buffer
		// Getting the values from them when they are.
		// When available we dispatch to execute
		
		// We will add the instruction to reservation buffer for simplicity
		this.mInsDespatch.addInstructionToReservationBuffer(this.mDespatchInput);
		
		for(int i = 0; i < 32; i++){
			System.out.println(" Reg use: "+
			this.mRegisterSet.getRegisterInUse(i));
		}
		
		// Now we verify that we have access to all the values.
		// If we do it is added to the ready to execute phase
		// If we dont it waits in the queue for writeback
		
		
		// Execute
		
		// Data Access
		
		// Write back
		
		
		
		
		// Move the output from this phase onto the next stage
		//TODO Possibly control this more granular?
		this.mDecodeInput = insFetchPhyCoreOutput; 		// Stage 2 input
		this.mDespatchInput = insDecodePhyCoreOutput; 	// Stage 3 input
//		this.mExecuteQueue.add
		
		// Add to execute queue.
		ArrayList<ISA_Base> resBuffer = this.mInsDespatch.getResevationBuffer();
		ArrayList<Integer> elemToDel = new ArrayList<Integer>();
		// Search each elem in the res buffer for deployable elements
		for(int i = 0; i < resBuffer.size(); i++){
			if(resBuffer.get(i).getDispatchReady()){
				// If the ins is ready to despatch... Send it to the execute queue
				this.mExecuteQueue.add(resBuffer.get(i));
				elemToDel.add(i);
			}
		}
		System.out.println("Size of res buff:"+ this.mInsDespatch.getResevationBuffer().size());
		// Delete the items added to the execute queue from the res buffer
		this.mInsDespatch.getResevationBuffer().removeAll(mExecuteQueue);
		System.out.println("Size of res buff after purge:"+ this.mInsDespatch.getResevationBuffer().size());
		System.out.println("Size of exe queue:"+ this.mExecuteQueue.size());
		
		
		
		
		
		
		
	}
}
