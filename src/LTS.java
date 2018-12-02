import java.util.LinkedList;

public class LTS {
	LinkedList<Program> jobQueue;
	RAM r;
	public long start;
	public long finish;
	public static int saved;
	public LinkedPQ pq;
	public LTS(){
		jobQueue = new LinkedList<Program>();
		r = new RAM();
		saved=0;
		pq = new LinkedPQ();
	}
	public boolean addProccess(Program proccess){
		if(!r.full()){
			if(r.size + proccess.getMemory()<= r.getLimitSize())
				jobQueue.add(proccess);
			return true;
		}
		return false; 
				
	}
	public void time(){
	 start=System.nanoTime();
	 finish=start+20;
	}
	public void continues(LinkedList<Program> j){
		if(System.nanoTime()>=finish){
			if (pq.enqueue(j.get(saved),j.get(saved).getCpu())){
				System.out.println("before"+saved);
				saved++;
				System.out.println("after"+saved);
			    time();
			}
		}
	}
	
	public void printpq(){
		System.out.print(pq.length());
		int faisal = pq.length();
		for(int i=0;i<faisal;i++){
			System.out.println("##$##"+pq.serve().data.getCpu());
			
		}
	}
	public void printjob(){
		
		for(int i=0;i<jobQueue.size();i++){
			System.out.println("##$##"+jobQueue.get(i).getCpu());
		}
	}
	public void callcontinues(LinkedList<Program> j){
		System.out.println(saved);
		System.out.println(j.size());
		while(true){
			continues(j);
			if(LTS.saved==j.size()){
				break;
			}
	}
	}
}


