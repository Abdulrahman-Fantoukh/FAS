import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

 
  import java.lang.*; 
public class readtxt {
	public RAM r=new RAM();
	public LTS lts=new LTS();
	//public enum type{cpu,memory,io};
	//reading the file
	public  void read() throws IOException {
		int cpu=0;
		int memory=0;
		int io=0;
		int name=1;
		Program p;
		String line;
		try {
			BufferedReader br = new BufferedReader(
			new FileReader("C:\\Users\\436100096\\FAS\\src\\cpumemoryio.txt"));
			br.readLine();
			int count=0;
			int typecount=1;
			while(true){
				count++;
				
			while ((line =br.readLine())!= null) {
				
				int[] array = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
				LinkedList<Records> records = new LinkedList<Records>();
				for(int i =1; i<array.length; i++) {
						
						if(i==array.length-1&&i%3!=0){
							memory=0;
							io=0;
							cpu=array[i];
							Records record = new Records(cpu,memory,io);
							records.add(record);
							
//							if(lts.addProccessToJQ(p)){
//								//System.out.println("added"+p.getCpu());
//							}
//							else{
//								//System.out.println("not added");
//							}
							p = new Program(name,records,records.size());
							lts.addProccessToJQ(p);
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
							Records record = new Records(cpu,memory,io);
							records.add(record);
							//System.out.println("cpu"+record.cpu);
							
							if(!r.full()){
//								if(lts.addProccessToJQ(p)){
//								//System.out.println("added"+p.getCpu());
//								}
//								else{
//								//	System.out.println("not added");
//								}
							}
						}
						
						if(i==array.length-1){
							
							p = new Program(name,records,records.size());
							lts.addProccessToJQ(p);
						}
							
						
					}
				name++;
				break;
				}
			
			if(line!=null){}
			//System.out.println("END"+count);
			else
				break;
		}
		} catch (FileNotFoundException e) {
			System.out.println("cannot read file");
		}
	}
	//printing the file
	
	//main
	public static void main(String[] args) {
		readtxt a=new readtxt();
		 long start=System.currentTimeMillis();
		 long finish;
		try{
			a.read();
			
			
			 
		}
		catch(Exception e){
			
		}
		a.lts.printjobQ();
		
		a.lts.callcontinues(a.lts.jobQueue);
		a.lts.printpq(1);
		  
		   finish=System.currentTimeMillis();
		 
		  
		   //Period diff = new Period(start, finish);
System.out.println(finish-start);
		
	}
}
