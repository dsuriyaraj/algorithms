/*
 * Implement an algorithm to delete a node in the middle of a singly 
 * linked list, given only access to that node
 * 
 * EXAMPLE
 * input: the node c from the linked list a->b->c->d->e
 * result: nothing is returned, but the new linked list looks like
 *         a->b->d->e
 * 
 */ 
public class RemoveANode {
	
	public static void remove(LinkedListNode node) {
		node.data = node.next.data;
		node.next = node.next.next;		
	}
		
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(3);
		LinkedListNode n1 = new LinkedListNode(4);
		head.append(n1);
		LinkedListNode n2 = new LinkedListNode(5);
		head.append(n2);
		LinkedListNode n3 = new LinkedListNode(6);
		head.append(n3);
		
		System.out.println("The original linked list is: " );
		head.print();
		
		//-----------------remove node in the middle------------------
		LinkedListNode node = head.next.next;
		remove(node);
		System.out.println("After deleting a node, the linked list is: " );
		head.print();
		
		
		node = head.next;
		remove(node);
		System.out.println("After deleting a node, the linked list is: " );
		head.print();
	}		
}	
