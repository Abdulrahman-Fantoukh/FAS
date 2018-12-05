import java.util.LinkedList;

public class LTS {
	LinkedList<Program> jobQueue;
	LinkedList<Program> tmpList;
	RAM r = RAM.getInstance();
	public long start;
	public long finish;
	public static int saved;
	
	public LTS(){
		jobQueue = new LinkedList<Program>();
		saved=0;
		tmpList = new LinkedList<Program>();
		
	}
	//add to job queue
	public boolean addProccessToJQ(Program proccess){	
		jobQueue.add(proccess);
		return true;		
	}
	
	public void time(){
	 start=System.nanoTime();
	 finish=start+200;
	 
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
		
		// tmp.incpointer();
			 //r.readyQueue.enqueue(tmp,r);
			
				 double faisal = jobQueue.size();
				 for(int i=0;i<faisal;i++){
					 
					 Program tmp=r.readyQueue.serve().data;
					 
					 if(tmp.checkloop==1){
						 tmpList.add(tmp);
						 return;
					 }
					 System.out.println("*********************");
					 System.out.println("before pointer: "+tmp.pointer);
					 System.out.println("CPU:"+tmp.records.get(tmp.pointer).cpu);
					 System.out.println("MEMORY:"+tmp.records.get(tmp.pointer).memory);
					 System.out.println("after pointer: "+tmp.pointer);
					 System.out.println(tmp.getName());
					 System.out.println("*********************");
					 tmp.incpointer();
					 tmpList.add(tmp);
		
		}
			int tmpListSize = tmpList.size();
			for(int s=0; s<tmpListSize; s++){
				r.readyQueue.enqueue(tmpList.get(s), r);
			}
			for(int h=0;h<tmpListSize;h++){
				tmpList.remove();
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
			if(LTS.saved==j.size()){
				break;
			}
	}
	}
}


