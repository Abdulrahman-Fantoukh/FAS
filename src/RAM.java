import java.util.LinkedList;


public class RAM {
	private final int limitSize;
	int size;
	LinkedList<Program> readyQueue;

	public RAM() {
		limitSize = 140800;
		readyQueue = new LinkedList<Program>();
		size = 0;
	}

	public boolean full() {
		return size >= limitSize;
	}
	public int getLimitSize(){
		return limitSize;
	}
	public boolean addProcessRQ(Program p){
		if(full()){
			return false;
		}
		else{
			readyQueue.add(p);
			return true;
		}
		
		
		
	}

}
