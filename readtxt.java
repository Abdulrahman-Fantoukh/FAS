import java.io.*;
import java.util.Arrays;


public class readtxt {
	public RAM r=new RAM();
	public LTS lts=new LTS();
	public enum type{cpu,memory,io};
	//reading the file
	public  void read() throws IOException {
		int cpu=0;
		int memory=0;
		int prememory=-1;
		int io=0;
		int name=1;
		Program p;
		
		String line;
		try {
			BufferedReader br = new BufferedReader(
			new FileReader("C:\\Users\\436100096\\workspace\\FAS\\src\\cpumemoryio.txt"));
			br.readLine();
			int count=0;
			int typecount=1;
			while(true){
				count++;
			while ((line =br.readLine())!= null) {
				int[] array = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
					for(int i =1; i<array.length; i++) {
						if(i==array.length-1&&i%3!=0){
							memory=0;
							io=0;
							cpu=array[i];
							p = new Program(name,cpu,memory,io);
							if(lts.addProccessToJQ(p)){
								//System.out.println("added"+p.getCpu());
							}
							else{
								//System.out.println("not added");
							}
							break;
						}
						if(typecount==1)
							cpu=array[i];
						else if(typecount==2){
							memory=array[i];
						}
						else{
							io=array[i];
						}
						typecount++;
						if(typecount==4){
							typecount=1;
							p = new Program(name,cpu,memory,io);
							if(!r.full()){
								if(lts.addProccessToJQ(p)){
								//System.out.println("added"+p.getCpu());
								}
								else{
								//	System.out.println("not added");
								}
							}
						}
					}
				name++;
				break;
				}
			if(count<=50){}
			//System.out.println("END"+count);
			else
				break;
		}
		} catch (FileNotFoundException e) {
			System.out.println("cannot read file");
		}
	}
	//printing the file
	public void callprint(){
		for(int i=0;i<lts.jobQueue.size();i++){
			System.out.println(lts.jobQueue.get(i).getState());
			System.out.println("END"+i);
		}
	}
	//main
	public static void main(String[] args) {
		readtxt a=new readtxt();
		try{
			a.read();
		}
		catch(Exception e){
			
		}
		a.lts.printjobQ();
		a.lts.callcontinues(a.lts.jobQueue);
		//a.lts.printpq();
	}
}
