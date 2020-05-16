package solutions;

public class Day16_OddEvenLinkedList {
	/*
	 * Put the odd nodes in a linked list and the even nodes in another. 
	 * Then link the evenList to the tail of the oddList.
	 */
	public static ListNode oddEvenList(ListNode head) {
		if(head == null) {
			return null;
		}
		
		// Save the head of even list to "evenHead"
		ListNode odd = head, even = head.next, evenHead = even;
		while(even!=null && even.next!=null) {
			odd.next = even.next;
			odd = odd.next;
			
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
//		printList(head);
		return head;
	}
	
	private static void printList(ListNode head) {
		System.out.println("Printing list");
		ListNode curr = head;
		while(curr!=null) {
			System.out.print(curr.val+ " ");
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(7);
		oddEvenList(head);
	}
}
/*
 * Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 */

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}