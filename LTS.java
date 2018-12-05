import java.util.LinkedList;

public class LTS {
	LinkedList<Program> jobQueue;
	RAM r = RAM.getInstance();
	public long start;
	public long finish;
	public static int saved;
	
	public LTS(){
		jobQueue = new LinkedList<Program>();
		saved=0;
		
	}
	//add to job queue
	public boolean addProccessToJQ(Program proccess){	
		jobQueue.add(proccess);
		return true;		
	}
	
	public void time(){
	 start=System.nanoTime();
	 finish=start+200000000;
	}
	//waking up the OS every 200 ms and add to Ready queue
	public void continues(LinkedList<Program> jobQ){
		if(System.nanoTime()>=finish){
			if (r.addProcessRQ(jobQ.get(saved))){
				saved++;
				
			   
			}else{
				jobQ.get(saved).setMemorywait(jobQ.get(saved).getMemorywait()+1);
			}
			 time();
		}
	}
	//this method to print the ready queue
	public void printpq(){
		System.out.print(r.getSize());
		double faisal = r.getSize();
		for(int i=0;i<faisal;i++){
			Program tmp=r.readyQueue.serve().data;
			if(tmp.pointer>tmp.cyclenum){
				System.out.println("wrooooooooooooooooooooong");
			}
			System.out.println("##$##"+tmp.records.get(tmp.pointer).cpu);
			r.readyQueue.enqueue(tmp, tmp.records.get(tmp.pointer++).cpu, r);
			
		}
	}
	//print job queue
	public void printjobQ(){
	
		for(int i=0;i<jobQueue.size();i++){
			for(int j=0;j<jobQueue.get(i).cyclenum;j++)
			System.out.println("##CPU OF PROCESS##: "+jobQueue.get(i).getName() +","+jobQueue.get(i).records.get(j).cpu);
		}
	}
	public void callcontinues(LinkedList<Program> j){
		
		while(true){
			
			continues(j);
			if(LTS.saved==10){
				break;
			}
	}
	}
}


