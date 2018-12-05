public class RAM {
	private final double limitSize = 144.0;
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
		if(full() || limitSize < p.records.get(p.pointer).memory + size){
			p.setState(p.getState().WAITING);
			System.out.println("full -_- the size is: " + size+"\n");
			System.out.println(p.getMemorywait());
			
			return false;
		}
		else{
			readyQueue.enqueue(p,p.records.get(p.pointer).cpu,getInstance());
			size = size + p.records.get(p.pointer).memory;
			if(size<0){
				size=0;
			}
			System.out.println("empty ^_^ and the size is: " + size+"\n");
			
			return true;
		}
		
		
		
	}

}
