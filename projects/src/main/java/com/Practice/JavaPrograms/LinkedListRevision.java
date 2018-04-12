package com.Practice.JavaPrograms;
class Node{
	Node next;
	int data;
	Node(int key){
		next = null;
		data = key;
	}
}

public class LinkedListRevision {
	static Node head;
	LinkedListRevision(){
		head = null;
	}
	public static void printListMethod() {
		Node n = head;
		while(n != null) {
			System.out.print(" " +n.data);
			n = n.next;
		}
	}
	public static void addFirstNode(int data) {
		if(head == null) {
			return;
		}
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	public static void addMiddleNode(Node prev,int data) {
		if(head == null) {
			return;
		}
		Node n = head;
		Node previous = null;
		Node newnode = new Node(data);
		while(n != prev) {
			
			n = n.next;
		}
		
		newnode.next = n.next;
		n.next = newnode;
	}
	public static void addLastNode(int data) {
		if(head == null) {
			head = new Node(data);		}
		Node newnode = new Node(data);
		newnode.next = null;
		Node n = head;
		Node prev = null;
		while(n != null) {
			prev = n;
			n = n.next;
		}
		prev.next = newnode;
	}
	public static Node reverseListMethod(Node node) {
		Node current = node;
		Node next = null;
		Node prev = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	public static int findMiddleElementMethod(Node node) {
		Node fast = node;
		Node slow = node;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
		
	}
	public static int numOfElements() {
		Node n = head;
		int count = 0;
		while(n != null) {
			count++;
			n = n.next;
			
		}
		return count;
	}
	public static void deleteNodeMethod(int num) {
		if(head.data == num) {
			head = head.next;
		}
		Node n = head;
		Node prev = null;
		while(n.data != num) {
			prev = n;
			n = n.next;
		}
		prev.next = n.next;
	}
	public static void main(String [] args) {
		head = new Node(11);
		head.next = new Node(12);
		head.next.next = new Node(13);
		head.next.next.next = new Node(14);
		System.out.print("The given list :  ");
		printListMethod();
		addFirstNode(100);
		System.out.print(" \n" +"List after adding first node :  ");
		printListMethod();
		addMiddleNode(head.next.next, 200);
		System.out.print(" \n" +"List after adding Middle node :  ");
		printListMethod();
		addLastNode(300);
		System.out.print(" \n" +"List after adding Last node :  ");
		printListMethod();
		head = reverseListMethod(head);
		System.out.print(" \n" +"List after reversing:  ");
		printListMethod();
		int middle = findMiddleElementMethod(head);
		System.out.print("\n" + middle);
		int elements = numOfElements();
		System.out.print("\n" + elements);
		deleteNodeMethod(13);
		System.out.println();
		printListMethod();
	}

}
