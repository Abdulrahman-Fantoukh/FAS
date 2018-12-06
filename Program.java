import java.util.*;
public class Program implements Comparable<Program> {
	public int compareTo(Program p) { 
		
        if (this.records.get(this.pointer).cpu > p.records.get(p.pointer).cpu) 
            return 1; 
        else if (this.records.get(this.pointer).cpu < p.records.get(p.pointer).cpu)
            return -1; 
                        return 0; 
        
} 
	LinkedList<Records> records;
	public int cyclenum;
	public int pointer;
	private int cpuin=0;
	public int finishcycle;
	public void incpointer(){
		pointer++;
		if(pointer>cyclenum-1){
			finishcycle=1;
			pointer=0;
			System.out.println(name+" end cycle###"+"\n #############################");
		}
		
	}
	public int getCpuin() {
		return cpuin;
	}
	public void setCpuin(int cpuin) {
		this.cpuin = cpuin;
	}
	public int getCputime() {
		return cputime;
	}
	public void setCputime(int cputime) {
		this.cputime = cputime;
	}
	private int memorywait=1;
	public int getMemorywait() {
		return memorywait;
	}
	public void setMemorywait(int memorywait) {
		this.memorywait = memorywait;
	}
	private int cputime=0;
	public  int pid = 1;
	private int name;
	public enum state{READY, WAITING, RUNNING, TERMINATED, KILLED}
	private state s;
	
	public Program(int name,LinkedList<Records> r,int cycle){
		this.name = name;
		pid++;
		records = r;
		cyclenum = cycle;
		pointer=0;
		finishcycle=0;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	public int getpid(){
		return pid;
	}
	public void setState(state s){
		this.s = s;
	}
	public state getState(){
		return s;
	}
}
