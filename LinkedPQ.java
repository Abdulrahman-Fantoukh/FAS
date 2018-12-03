public class LinkedPQ<T> {

	private int size;
	private PQNode head;
	RAM r = RAM.getInstance();

	/* tail is of no use here. */
	public LinkedPQ() {
		head = null;
		size = 0;
		//r=new RAM();

	}

	public int length() {
		return size;
	}

	public boolean full() {
		return false;
	}
	
	public boolean enqueue(Program p, double cpuBurst) {
		PQNode tmp = new PQNode(p, cpuBurst);
		System.out.println(r.size+"llllll");
		if(r.full() || r.getLimitSize() < p.getMemory() + r.size){
		p.setState(p.getState().WAITING);
		return false;
	}
			if ((size == 0) || (cpuBurst < head.cpuBurst)) {
				tmp.next = head;
				head = tmp;
			} else {

				PQNode h = head;
				PQNode q = null;
				while ((h != null) && (cpuBurst >= h.cpuBurst)) {
					q = h;
					h = h.next;
				}
				tmp.next = h;
				q.next = tmp;
			}
			size++;
			r.size = r.size + p.getMemory();
			return true;
		}
		
//	}
	
	public PQNode serve() {
		PQNode Node = head;
		if(head.next != null)
		head = head.next;
		size--;
		return Node;
	}

	
		}