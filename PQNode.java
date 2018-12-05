public class PQNode {
	
	public Program data;
	public double cpuBurst;
	public PQNode next;
	
	
	
	public PQNode() {
		next = null;
	}
	
  public PQNode(Program e, double Exepected_Execution_time) {
       data = e;
       this.cpuBurst = e.records.get(e.pointer).cpu;
  }
  
}