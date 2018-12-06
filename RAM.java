import java.util.*;
public class RAM {
	Queue<Program> pq = new PriorityQueue<>();
	
	
	private final double limitSize = 1440.0;
	double size = 0;
	
	private static RAM ram;
	
	static{
		ram = new RAM();
	}
	public static RAM getInstance(){
		return ram;
	}
	
//	//public RAM() {
//		limitSize = 140.8;
//		readyQueue = new LinkedPQ<Program>();
//		size = 0;
//	}

	public boolean full() {
		return size >= limitSize;
	}
	public double getLimitSize(){
		return limitSize;
	}
	public double getSize(){
		return size;
	}
	public boolean addProcessRQ(Program p){
		if(full() || limitSize < p.records.get(p.pointer).memory + size){
			p.setState(p.getState().WAITING);
			System.out.println("full -_- the size is: " + size+"\n");
			System.out.println(p.getMemorywait());
			
			return false;
		}
		else{
			//readyQueue.enqueue(p,getInstance());
			pq.add(p);
			size = size + p.records.get(p.pointer).memory;
			
			if(size<0){
				size=0;
			}
			System.out.println("free space ^_^ and the size is: " + size+"\n");
			
			return true;
		}
		
		
		
	}

}
