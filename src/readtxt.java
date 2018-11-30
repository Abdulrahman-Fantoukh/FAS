import java.io.*;
import java.util.Arrays;


public class readtxt {
	public RAM r=new RAM();
	public LTS lts=new LTS();
	public enum type{cpu,memory,io};
	public  void read() throws IOException {
		int cpu=0;
		int memory=0;
		int io=0;
		Program p;
		
		String line;
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\436100096\\workspace\\multiprogram OS simulation\\src\\cpumemoryio.txt"));
			br.readLine();
			int count=0;
			int typecount=1;
			while(true){
				count++;
			while ((line =br.readLine())!= null) {
				
				
				int[] array = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
				for(int i =1; i<array.length; i++) {
					
					//System.out.print(array[i]);
					
					if(typecount==1)
					cpu=array[i];
					else if(typecount==2)
						memory=array[i];
					else
						io=array[i];
					typecount++;
					if(typecount==4){
						
						
						
						typecount=1;
						p = new Program(cpu,memory,io);
						if(!r.full()){
							if(lts.addProccess(p)){
								System.out.println("added"+p.getCpu());
							}
							else{
								System.out.println("not added");
							}
					}
					
					
						
						
						
						
						
						
					}
						
				}
				break;
			}
			if(count<=50)
				System.out.println("END"+count);
			else
				break;
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("cannot read file");
		}
	}
	public void callprint(){
		for(int i=0;i<lts.jobQueue.size();i++){
			System.out.println(lts.jobQueue.get(i).getCpu());
			System.out.println("END"+i);
		}
	}
	public static void main(String[] args) {
		readtxt a=new readtxt();
		try{
			
			a.read();
		}
		catch(Exception e){
			
		}
		a.callprint();
		
  
	}

}
