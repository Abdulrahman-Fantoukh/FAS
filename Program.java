
public class Program {
	private int cpuin=0;
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
	private int cpu;
	private int memory;
	private int io;
	public enum state{READY, WAITING, RUNNING, TERMINATED, KILLED}
	private state s;
	
	public Program(int name,int cpu,int memory,int io){
		this.name = name;
		this.cpu = cpu;
		this.memory = memory;
		this.io = io;
		pid++;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getIo() {
		return io;
	}
	public void setIo(int io) {
		this.io = io;
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
