/*
 * Write code to partition a linked list around a value x, such that all
 * nodes less than x come before all nodes greater than or equal to x
 * 
 */

public class PartitionAround {
	
	// return the head of the new linked list
	public static LinkedListNode partitionAround(LinkedListNode ll, int x) {
		// start from a list with only one node
		// we are actually creating a new linked list
		LinkedListNode head = ll;
		LinkedListNode tail = ll;
		
		while (ll!=null) {
			// because the current node ll will be moved, we have to 
			// save the next node for the loop to continue
			LinkedListNode next = ll.next;
			if (ll.data < x) {
				// prepend the node
				ll.next = head;
				// update the head
				head = ll;
			} else  {
				// append the node
				tail.next = ll;
				// update the tail
				tail = ll;
			} 	
			ll = next;
		}	
		tail.next = null;
		return head; 	
	}	
	
	public static void main(String[] args) {
		LinkedListNode ll = new LinkedListNode(6);
		ll.add(5);
		ll.add(4);
		ll.add(3);
		ll.add(2);
		ll.add(1);
		ll.add(3);
		ll.add(0);
		System.out.println("The original linked list is: " );
		ll.print();
		
		LinkedListNode x = ll.next.next.next;
		LinkedListNode head = partitionAround(ll, 5);
		System.out.printf("After partitioning around %d, the list becomes:",
		                  x.data);
		head.print();                  
	}	
}	 
