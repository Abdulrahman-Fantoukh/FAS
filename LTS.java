import java.util.LinkedList;

public class LTS {
	LinkedList<Program> jobQueue;
	RAM r = RAM.getInstance();;
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
	 finish=start+20;
	}
	//waking up the OS every 200 ms and add to Ready queue
	public void continues(LinkedList<Program> jobQ){
		if(System.nanoTime()>=finish){
			if (r.addProcessRQ(jobQ.get(saved))){
				saved++;
			    time();
			}
		}
	}
	//this method to print the priority queue
	public void printpq(){
		System.out.print(r.getSize());
		double faisal = r.getSize();
		for(int i=0;i<faisal;i++){
			System.out.println("##$##"+r.readyQueue.serve().data.getCpu());
			
		}
	}
	//print job queue
	public void printjobQ(){
		for(int i=0;i<jobQueue.size();i++){
			System.out.println(jobQueue.size());
			System.out.println("##$##"+jobQueue.get(i).getCpu());
		}
	}
	public void callcontinues(LinkedList<Program> j){
		while(true){
			continues(j);
			if(LTS.saved==j.size()){
				break;
			}
	}
	}
}


