/*
 * You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such
 * that the 1's digit is at the head of the list. Write a function that
 * adds the two numbers and returns the sum as a linked list.
 * 
 * EXAMPLE
 * input: (7->1->6) + (5->9->2). That is, 617 + 295
 * output: 2->1->9. That is, 912.
 * 
 * FOLLOW UP
 * suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * input (6->1->7) + (2->9->5). That is, 617 + 295
 * output: 9->1->2. That is, 912.
 */ 



public class AddLinkedList {

//------------------- most straightfoward way ------------------------	
	public static LinkedListNode add(LinkedListNode list1, 
	                                     LinkedListNode list2) 
	{		
		// obtain the two numbers from list1 and list2
		int num1 = toNumber(list1);
		int num2 = toNumber(list2);
		
		int sum = num1 + num2;
		return toLinkedList(sum);
		
	}	
	
	

	
	public static int toNumber(LinkedListNode list) {
		int base = 1;
		int num = 0;
		while (list!=null) {
			num += base*list.data;
			list = list.next;
			base *= 10;
		}	
		return num;
	}	
	
	public static LinkedListNode toLinkedList(int num) {
		LinkedListNode head = null;
		int mod;
		int counter = 1;
		while (num/10 != 0) {
			mod = num%10;
			if (counter==1) {
				head = new LinkedListNode(mod);
				counter++;
			} else {	 
				head.add(mod);
			}
			num /= 10;			
		}
		
		mod = num%10;
		head.add(mod);
		return head;			
	}	
	


// -------------------------add carry--------------------------------
// ------- can be used to add two aribitary large integers-----------	

	
	public static void main(String[] args) {
		LinkedListNode list1 = new LinkedListNode(7);
		list1.add(1);
		list1.add(6);
		System.out.println("list 1 is: ");
		list1.print();
		
		LinkedListNode list2 = new LinkedListNode(5);
		list2.add(9);
		list2.add(2);
		System.out.println("list 2 is: ");
		list2.print();
		
		LinkedListNode sum = add(list1, list2);
		System.out.println("The sum of list1 and list2 is:");
		sum.print();
		
		
	}	
	
}	
