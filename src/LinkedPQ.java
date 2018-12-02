public class LinkedPQ {

	private int size;
	private PQNode head;
	private RAM r;

	/* tail is of no use here. */
	public LinkedPQ() {
		head = null;
		size = 0;
		r = new RAM();
	}

	public int length() {
		return size;
	}

	public boolean full() {
		return false;
	}
	
	public boolean enqueue(Program e, double cpuBurst) {
		PQNode tmp = new PQNode(e, cpuBurst);
//		if (r.full()){
//			return false;
//		}
//		else{
			if ((size == 0) || (cpuBurst < head.cpuBurst)) {
				tmp.next = head;
				head = tmp;
			} else {

				PQNode p = head;
				PQNode q = null;
				while ((p != null) && (cpuBurst >= p.cpuBurst)) {
					q = p;
					p = p.next;
				}
				tmp.next = p;
				q.next = tmp;
			}
			size++;
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