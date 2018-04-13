package com.Practice.TreePrograms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
	Node left;
	Node right;
	int data;
	
	Node(int key){
		left = null;
		right = null;
		data = key;
		
	}
}
public class TreeInsertion {
	static Node root;
	TreeInsertion(){
		root = null;
	}
	public static void inOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(" " +node.data);
		inOrderTraversal(node.right);
	}
public static void preOrderTraversal(Node node) {
	if(node == null) {
		return;
	}
	System.out.print(" " +node.data);
	preOrderTraversal(node.left);
	preOrderTraversal(node.right);
		
	}
public static void postOrderTraversal(Node node) {
	if(node == null) {
		return;
	}
	postOrderTraversal(node.left);
	postOrderTraversal(node.right);
	System.out.print(" " + node.data);
	
}
public static void inOrderWithoutRecursion(Node node) {
	if(node == null) {
		return;
	}
	Stack <Node> s = new Stack<Node>();
	while(node != null) {
		s.push(node);
		node = node.left;
		
	}
	while(!s.isEmpty()) {
		Node n = s.pop();
		System.out.print(" " + n.data);
		if(n.right != null) {
			n = n.right;
			while(n != null) {
				s.push(n);
				n = n.left;
		}
	}
	}
	
}
public static void preOrderWithoutRecursion(Node node) {
	if(node == null) {
		return;
	}
	Stack <Node> s = new Stack<Node>();
	s.push(node);
	while(!s.isEmpty()) {
		Node n = s.pop();
		System.out.print(" " + n.data);
		if(n.right != null) {
			s.push(n.right);
		}
		if(n.left != null) {
			s.push(n.left);
		}
	}
	
}
public static void postOrderWithoutRecursion(Node node) {
	if(node == null) {
		return;
	}
	Stack<Node>s1 = new Stack<Node>();
	Stack<Node>s2 = new Stack<Node>();
	s1.push(node);
	while(!s1.isEmpty()) {
		Node n = s1.pop();
		s2.push(n);
		if(n.left != null) {
			s1.push(n.left);
		}
		if(n.right != null) {
			s1.push(n.right);
		}
	}
	while(!s2.isEmpty()) {
		Node n1 = s2.pop();
		System.out.print(" "+ n1.data);
	}
	
}
public static void printOneByOne(Node node) {
	if(node == null) {
		return;
	}
	Queue <Node> q1 = new LinkedList<Node>();
	q1.add(node);
	while(!q1.isEmpty()) {
		Node n = q1.poll();
		System.out.print(" " + n.data);
		if(n.left != null) {
			q1.add(n.left);
			
		}
		if(n.right != null) {
			q1.add(n.right);
		}
	}
}
public static void LevelOrderTraversal(Node node) {
	if(node == null) {
		return;
	}
	Queue <Node> q1 = new LinkedList<Node>();
	q1.add(node);
	q1.add(null);
	while(!q1.isEmpty()) {
		Node n = q1.poll();
		if(n == null && !q1.isEmpty()) {
			System.out.print("\n");
			q1.add(null);
		}
		else if(n != null) {
		System.out.print(" " + n.data);
		if(n.left != null) {
			q1.add(n.left);
			
		}
		if(n.right != null) {
			q1.add(n.right);
		}
	}
	}
}
public static int heightOfTree(Node node) {
	if(node == null) {
		return 0;
	}
	int l = heightOfTree(node.left);
	int r = heightOfTree(node.right);
	if(l<r) {
		return l+1;
	}
	else {
		return r+1;
	}
}
public static Node LCA(Node node, Node n1, Node n2) {
	if(node == null) {
		return null;
	}
	if(node == n1 || node == n2) {
		return node;
	}
	Node l =  LCA(node.left,n1,n2);
	Node r =  LCA(node.right,n1,n2);
	if(l != null || r != null) {
		return node;
	}
	return (l != null ? l:r);
	
}
	public static void main(String [] arg) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		inOrderTraversal(root);
		System.out.println(" = inOrderTraversal");
		preOrderTraversal(root);
		System.out.println(" = preOrderTraversal");
		postOrderTraversal(root);
		System.out.println(" = postOrderTraversal");
		inOrderWithoutRecursion(root);
		System.out.println(" = inOrderWithoutRecursion");
		preOrderWithoutRecursion(root);
		System.out.println(" = preOrderWithoutRecursion");
		postOrderWithoutRecursion(root);
		System.out.println(" = postOrderWithoutRecursion");
		printOneByOne(root) ;
		System.out.println(" = printOneByOne");
		LevelOrderTraversal(root);
		int result = heightOfTree(root);
		System.out.println(" \n"  + result);
		System.out.println();
		Node res = LCA(root, root.left,root.right);
		System.out.println(" " + res.data);
	}

}
