public class RAM {
	private final double limitSize = 140.8;
	double size = 0;
	public LinkedPQ<Program> readyQueue = new LinkedPQ<Program>();
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
		System.out.println(size);
		if(full() || limitSize < p.getMemory() + size){
			p.setState(p.getState().WAITING);
			return false;
		}
		else{
			readyQueue.enqueue(p,p.getCpu());
			size = size + p.getMemory();
			return true;
		}
		
		
		
	}

}
