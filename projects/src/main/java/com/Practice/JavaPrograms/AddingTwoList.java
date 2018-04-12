package com.Practice.JavaPrograms;
class Node{
	Node next;
	int data;
	
	Node(int key){
		next = null;
		data = key;
		
	}
}

public class AddingTwoList {
	static Node head;
	static Node head1;
	AddingTwoList(){
		head = null;head1 = null;
	}
	public static void printArray(Node node) {
		Node n = node;
		while(n != null) {
			System.out.print(" " +n.data);
			n = n.next;
					
		}
				
	}
	public static Node addMethod(Node node1, Node node2) {
		Node first = node1;
		Node second = node2;
		int sum = 0;
		int carry = 0;
		Node temp = null;
		Node res = null;;
		Node prev = null;
		while(first != null && second != null) {
		sum = carry +(first != null?first.data:0)+(second != null?second.data:0);
		carry = (sum>=10? 1:0);
		sum = sum %10;
		temp = new Node(sum);
		if(res == null) {
			res = temp;
		}
		else {
			prev.next = temp;
		}
		prev = temp;
		
		if(first != null) {
			first = first.next;
		}
		if(second != null) {
			second = second.next;
		}
		if(carry>0) {
			temp.next = new Node(carry);
		}
	}
		return res;
	}
	public static void main(String [] args) {
		head = new Node(9);
		head.next = new Node(4);
		head.next.next = new Node(8);
		head1 = new Node(6);
		head1.next = new Node(5);
		head1.next.next = new Node(7);
		printArray(head) ;
		System.out.println();
		printArray(head1);
		System.out.println("\n" + "----------");
		Node result = addMethod(head,head1);
		printArray(result);
		
	}

}
