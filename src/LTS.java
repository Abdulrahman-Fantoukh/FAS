import java.util.LinkedList;

public class LTS {
	LinkedList<Program> jobQueue;
	RAM r;
	
	public LTS(){
		jobQueue = new LinkedList<Program>();
		r = new RAM();
	}
	public boolean addProccess(Program proccess){
		if(!r.full()){
			if(r.size + proccess.getMemory()<= r.getLimitSize())
				jobQueue.add(proccess);
			return true;
		}
		return false; 
				
	}
//	public void print(){
//		for(int i=0;i<jobQueue.size();i++){
//			System.out.println(jobQueue.get(i).getCpu());
//			
//		}
//	}
}
