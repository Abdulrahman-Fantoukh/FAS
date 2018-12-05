//import java.util.Random;
//
//public class CPU {
//	private int cpuBound;
//	private int ioBound;
//	private int normal;
//	private int abnormal;
//	private int numOfProgs;
//	private double totalSize = 0;
//	private int clock = 0;
//	
//	public void machineExecutionCycle(RAM r) {
//		numOfProgs = r.ram.length();
//		System.out.println("Hello MEC");
//		while(r.ram.length() > 0) {
//			
//			Program current = r.ram.deQueue().data;
//			current.setState("Running");
//			clock += current.getNumOfInstructions();
//			totalSize += current.getPrgSize();
//			//Increment CPU Bound counter but will decrement if it goes to IO
//			cpuBound++;
//			
//			//Generate a random number from 1 to 100
//			/*int rando = (int) (Math.random() * (100 + 1 - 1) + 1);
//			
//			//Interrupt
//			if(rando >= 1 && rando <= 10) {
//				System.out.println("Program Inturrupted");
//				current.setState("Ready");
//				continue;
//			}
//			
//			//IO Request
//			if(rando >= 11 && rando <= 30) {
//				IODevice io = new IODevice();
//				System.out.println("IO Request");
//				io.request(current);
//				cpuBound--;
//				continue;
//			}
//			
//			//The missing range from 31 to 50 is for Busy IO Termination in the IO Device Class.
//			
//			//Normal Termination
//			if(rando >= 51 && rando <= 55) {
//				current.setState("Terminated");
//				System.out.println(current.getState() + " Normally");
//				normal++;
//				continue;
//			}
//			
//			//Abnormal Termination
//			if(rando >= 56 && rando <= 57) {
//				current.setState("Terminated");
//				System.out.println(current.getState() + " Abormally");
//				abnormal++;
//				continue;
//			}*/
//						
//			Random randObj = new Random();
//			int rando;
//			
//			//Interrupt
//			rando = randObj.nextInt(100);
//			if(rando >= 0 && rando <= 9) {
//				System.out.println("Program Inturrupted");
//				current.setState("Ready");
//				continue;
//			}
//			
//			//IO Request
//			rando = randObj.nextInt(100);
//			if(rando >= 0 && rando <= 19) {
//				IODevice io = new IODevice();
//				System.out.println("IO Request");
//				io.request(current);
//				cpuBound--;
//				continue;
//			}
//			
//			//Normal Termination
//			rando = randObj.nextInt(100);
//			if(rando >= 0 && rando <= 4) {
//				current.setState("Terminated");
//				System.out.println(current.getState() + " Normally");
//				normal++;
//				continue;
//			}
//			
//			//Abnormal Termination
//			rando = randObj.nextInt(100);
//			if(rando == 0) {
//				current.setState("Terminated");
//				System.out.println(current.getState() + " Abormally");
//				abnormal++;
//				
//				continue;
//			}
//			
//			/* TO-DO:
//			 * 1- Terminations
//			 * 2- IO Device Class
//			 * 3- Statistics
//			 * */
//			
//		}
//		System.out.println("Ok MEC: " + numOfProgs);
//	}
//	
//	
//	//The average number of jobs that have completed their execution normally.
//	public double getAvgNormal() {
//		if(numOfProgs > 0)
//			return normal/numOfProgs;
//		return 0;
//	}
//	//The average number of jobs that have completed their execution abnormally.
//	public double getAvgAbnormal() {
//		if(numOfProgs > 0)
//			return abnormal/numOfProgs;
//		return 0;
//	}
//	
//	public int getNumOfProgs() {
//		return this.numOfProgs;
//	}
//	
//	public int getCpuBound() {
//		return this.cpuBound;
//	}
//	
//	
//}
