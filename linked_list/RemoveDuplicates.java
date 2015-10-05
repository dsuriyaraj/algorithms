/*
 * write code to remove duplicates from an unsorted linked list
 * Follow up
 * How would you solve this problem if a temporary buffer is not allowed
 */ 
import java.util.*;
 
public class RemoveDuplicates {
	
	public static void removeDuplicatesSimple(LinkedListNode ll) {
		// if the linked list is empty or has only one node
		if (ll == null) return;
		
		while (ll!=null) {
			LinkedListNode prevNode = ll;
			LinkedListNode curNode = ll.next;
			
			// compare all nodes after ll with ll
			while (curNode!=null) {
				// delete the duplicates
				if (curNode.data == ll.data) {					
					prevNode.next = curNode.next;				
				}
				prevNode = curNode;
				curNode = curNode.next;	
			}	
			
			ll = ll.next;
		}	

	}	
	
	public static void removeDuplicatesHash(LinkedListNode ll) {
		HashSet<Integer> dataSet = new HashSet<Integer>();
		// add the data into the set and check if the set already contains the data
		LinkedListNode prevNode = null;
		while (ll!=null) {
			if ( dataSet.contains(ll.data) ) { // if it is a duplicate
				prevNode.next = ll.next;
			} else {	
				dataSet.add(ll.data);
				// you let prevNode = ll only if ll is not the node to be deleted
				// otherwise, you don't need to change prevNode
				prevNode = ll; 
			}			
			ll = ll.next;
		}	
	}		
	
	
	public static void main(String[] args) {
		LinkedListNode ll = new LinkedListNode(3);
		ll.add(1);
		ll.add(2);
		ll.add(1);
		ll.add(3);
		ll.add(9);
		ll.add(2);
		System.out.println("The original linked list is: " );
		ll.print();
		removeDuplicatesSimple(ll);
		System.out.println("After deleting duplicates, the linked list is: " );
		ll.print();

		// add some duplicates
		ll.add(2);
		ll.add(1);
		ll.add(3);
		ll.add(9);
		System.out.println("After adding some duplicates, the linked list is" );
		ll.print();
		//removeDuplicatesSimple(ll);
		removeDuplicatesHash(ll);
		System.out.println("After deleting duplicates, the linked list is: " );
		ll.print();
	}	
	
}	
