

public class LinkedListNode {
	public LinkedListNode next = null;
	public int data;
	
	public LinkedListNode() {
		
	}	
	
	public LinkedListNode(int d) {
		data = d;
		next = null;
	}
	
	
	public void add(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while (n.next != null ) {
			n = n.next;
		}
		n.next = end;
	}
	
	public void append(LinkedListNode node) {
		LinkedListNode n = this;
		while (n.next != null ) {
			n = n.next;
		}
		n.next = node;
	}	
	
	
	public void print() {
		LinkedListNode n = this;
		while (n != null) {
			if (n.next != null ) {
				System.out.printf("%d --> ", n.data);
			} else {
				System.out.printf("%d ", n.data);
			}	
			n = n.next;
		}

		System.out.println(" ");	
	}		
}	
