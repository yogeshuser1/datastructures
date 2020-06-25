package datastructures;


public class SinglyLinkedList {

	/**
	 * Node class to define the data structure for Singly Linked List
	 * @author yogesh meshram
	 *
	 */
	public class Node {

		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;

		}

	}
	
	Node head = null;
	Node tail = null;
	int size = 0;
	
	/**
	 * Method to get the size of the list
	 * @return size of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Method to check if the list is empty
	 * @return true if list is empty else false
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Add the data at the end of the list
	 * If the list is empty add first 
	 * else add at the end of list
	 * @param data
	 */
	public void addLast(int data) {
		
		if(isEmpty()) {
			head = tail = new Node(data,null);
		}
		else {
			tail.next = new Node(data,null);
			tail = tail.next;
		}
		++size;
	}
	
	/**
	 * Method to reverse the linked list
	 * @return
	 */
	public Node reverseList() {
		Node curr = null, prev = null, trav = head;
		if(isEmpty()) throw new IllegalArgumentException("List is empty");
		while(trav != null) {
			curr = trav;
			trav = trav.next;
			curr.next = prev;
			prev = curr;
		}
		return curr;
	}
	
	/**
	 * Add the data at the start of the list.
	 * If the list is empty create the first element
	 * else add at the beginning of the list
	 * @param data
	 */
	public void addFirst(int data) {
		
		if(isEmpty()) {
			head = tail = new Node(data,null);
		}
		else {
			Node node = new Node(data,head);
			head = node;
		}
		++size;
	}
	
	/**
	 * Print the values in the list
	 */
	public void list() {
		Node trav = head;
		while(trav != null) {
			System.out.print("[ " + trav.data + " ] ");
			trav = trav.next;
		}
	}
	
	/**
	 * Print the values in the list from specific node
	 */
	public void list(Node node) {
		Node trav = node;
		while(trav != null) {
			System.out.print("[ " + trav.data + " ] ");
			trav = trav.next;
		}
	}


	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		for(int i = 0 ; i < 10 ; i++)
			sll.addLast(i);
		
		System.out.println("Printing all values that are added at end.");
		
		sll.list();
		
		System.out.println("\nPrinting all values that are added at start.");
		
		sll.addFirst(-1);
		
		sll.list();
		
		System.out.println("\nPrinting all values in the reversed order");
		
		sll.list(sll.reverseList());

	}

}
