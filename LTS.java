import java.util.LinkedList;
import java.lang.*; 
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
	 start=System.currentTimeMillis();;
	 finish=start+200;
	 
	}
	//waking up the OS every 200 ms and add to Ready queue
	public void continues(LinkedList<Program> jobQ){
		
		if(System.currentTimeMillis()>=finish){
			
			if (r.addProcessRQ(jobQ.get(saved))){
				saved++;
				
			   
			}else{
				jobQ.get(saved).setMemorywait(jobQ.get(saved).getMemorywait()+1);
			}
			 time();
		}
	}
	//this method to print the ready queue
	public void printpq(int num){
		
		// tmp.incpointer();
			 //r.readyQueue.enqueue(tmp,r);
		int c=0;
			while(c<=num) {
				 double faisal = jobQueue.size();
				 for(int i=0;i<faisal;i++){
					 
					 Program tmp=r.pq.poll();
					 
					 if(tmp.finishcycle==1){
						 System.out.println("finish##################");
						 System.out.println("before pointer: "+tmp.pointer);
						 System.out.println("CPU:"+tmp.records.get(tmp.pointer).cpu);
						 System.out.println("MEMORY:"+tmp.records.get(tmp.pointer).memory);
						 System.out.println("after pointer: "+tmp.pointer);
						 System.out.println(tmp.getName());
						 System.out.println("##################");
						 
						 tmp.incpointer();
						 tmpList.add(tmp);
						 
						 continue;
						 
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
				r.pq.add(tmpList.get(s));
			}
			for(int h=0;h<tmpListSize;h++){
				tmpList.remove();
			}
			c++;
			}
	}
	public void printpqsecond(int num) {
		Program x;
		boolean exit=false;
		int y=0;
		while(y<=num) {
		while(r.pq.size()!=0) {
			x=r.pq.poll();
			 if(x.finishcycle==1){
				 num++;
				 break;
				 
			 }
			tmpList.add(x);
			//System.out.println("cpu : "+x.records.get(num).cpu+" memory: "+x.records.get(num).memory+" io: "+x.records.get(num).io);
		}
		 if(exit){
			 num++;
			 break;
			 
		 }
		 
		 
		while(tmpList.size()!=0) {
			tmpList.get(0).incpointer();
			r.pq.add(tmpList.get(0));
			tmpList.remove();
		}
		while(r.pq.size()!=0) {
			x=r.pq.poll();
			tmpList.add(x);
			if(x.finishcycle==1) {
				break;
			}
			System.out.println("cpu : "+x.records.get(num).cpu+" memory: "+x.records.get(num).memory+" io: "+x.records.get(num).io+" name: "+x.getName());
		}
		while(tmpList.size()!=0) {
			tmpList.get(0).incpointer();
			r.pq.add(tmpList.get(0));
			tmpList.remove();
		}
		num++;
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


