/*
 * implement an algorithm to find the kth to last element of a singly 
 * linked list
 * 
 */
 
public class FindKthToLast {
//---------------------Most straightforward------------------------------	
	public static int kthToLast(LinkedListNode ll, int k) {
		LinkedListNode curNode = ll;
		int list_size = findSize(ll);
		// number of jumps to reach the element from the head of the list
		int njump = list_size - k;
		while (njump > 0) {
			curNode = curNode.next;
			njump--;
		}	
		return curNode.data;
	}	
	
	
	// find out the size of the linked list
	public static int findSize(LinkedListNode ll) {
		int counter = 0;
		LinkedListNode curNode = ll;
		while (curNode!=null) {
			curNode = curNode.next;
			counter++;
		}	
		return counter;
	}	
	
	
//-------------------------recursive method-----------------------------
	static class Counter {
		public int count;
		public int data;
		
		Counter () {
			count = 0;
		}	
		
	}	
	
	public static void kthToLast_recur(LinkedListNode ll, 
	                                     Counter counter, int k) {
		if (ll==null) return;
		
		if (ll.next==null) { // if it is the last element of the list
			counter.count++;
		} else { // if it is not the last element
			kthToLast_recur(ll.next, counter, k);
			counter.count++;
		}	
		
		if (counter.count == k) {
			counter.data = ll.data;
		}		
			
	}	
	
	
//------------------------use two runners--------------------------------
	public static LinkedListNode kthToLast2(LinkedListNode ll, int k) {
		// use two runner that are separated by k
		if (ll==null) return null;
		
		LinkedListNode runner1 = ll;
		LinkedListNode runner2 = ll;
		
		// let runner2 to go k-1 steps ahead of runner1
		for (int i=1; i<=k-1; ++i) {
			if (runner2.next != null ) {
				runner2 = runner2.next;
			} else {
				return null;
			}	
		}
		
		// let runner1 and runner2 move at the same speed
		while (runner2.next!=null) { // until runner2 reach the end
			runner1 = runner1.next;
			runner2 = runner2.next;
		}		
		
		return runner1;
	}	

	
	public static void main(String[] args) {
		LinkedListNode ll = new LinkedListNode(10);
		ll.add(9);
		ll.add(8);
		ll.add(7);
		ll.add(6);
		ll.add(5);
		ll.add(4);
		ll.add(3);
		ll.add(2);
		ll.add(1);
		System.out.println("The original linked list is: " );
		ll.print();
		
		for (int i=1; i<=10; ++i) {
			System.out.printf("The %dth to last element is %d\n", i, kthToLast(ll, i));
		}
		
		System.out.println("");
		
		for (int i=1; i<=10; ++i) {
			Counter counter = new Counter();
			kthToLast_recur(ll, counter, i);
			System.out.printf("The %dth to last element is %d\n", i, 
			                  counter.data);
		}
		
		System.out.println("");
		
		for (int i=1; i<=10; ++i) {
			LinkedListNode node = kthToLast2(ll, i);
			System.out.printf("The %dth to last element is %d\n", i, node.data);
		}
		
	}	
}	  
