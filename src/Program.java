
public class Program {
	public  int pid = 1;
	private int cpu;
	private int memory;
	private int io;
	public enum state{READY, WAITING, RUNNING, TERMINATED, KILLED}
	
	public Program(int cpu,int memory,int io){
		this.cpu = cpu;
		this.memory = memory;
		this.io = io;
		pid++;
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
}
