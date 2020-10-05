package com.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}

	Node root;
	
	//Adding An Element to tree

	public void add(int value) {
		System.out.println("input value is : " + value);
		root = addRecursive(root, value);
		System.out.println("root value is : " + root.value);
	}

	private Node addRecursive(Node current, int value) {

		if (current == null) {
			return new Node(value);
		}
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
			System.out.println("current.left = " + current.left.value);
			
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
			System.out.println("current.right value is : " + current.right.value);
			
		}

		return current;
	}
	
	

	public boolean isEmpty() {
		return root == null;
	}
	
    //Getting Size of tree
	
	public int getSize() {
		return getSizeRecursive(root);
	}

	private int getSizeRecursive(Node current) {
		return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
	}
	
	//Searching an element in tree

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}

		if (value == current.value) {
			return true;
		}

		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}
	
	//updating a element
	
	public void containsNodeAndUpdate(int value , int newvalue) {
		containsNodeRecursiveAndUpdate(root, value ,newvalue);
	}

	private void containsNodeRecursiveAndUpdate(Node current, int value, int newvalue) {
		if (current == null) {
			System.out.println("tree is empty");
		}

		else if (value == current.value) {
			 current.value = newvalue;
			 System.out.println("Value has been updated");
		}

		else if (value < current.value ) {
			containsNodeRecursiveAndUpdate(current.left, value ,newvalue);
		}
		else {
	     containsNodeRecursiveAndUpdate(current.right, value ,newvalue);
		}
	}
	
	
	//Deleting an element in tree

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// Case 1: no children
			if (current.left == null && current.right == null) {
				return null;
			}

			// Case 2: only 1 child
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}

			// Case 3: 2 children
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}

		current.right = deleteRecursive(current.right, value);
		return current;
	}

//	private int findSmallestValue(Node root) {
//		return root.left == null ? root.value : findSmallestValue(root.left);
//	}
	
	private int findSmallestValue(Node root) 
	    { 
	        int minv = root.value;
	        while (root.left != null) 
	        { 
	            minv = root.left.value; 
	            root = root.left; 
	        } 
	        return minv;    
	    } 

	//printing
	
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			visit(node.value);
			traverseInOrder(node.right);
		}
	}

	public void traversePreOrder(Node node) {
		if (node != null) {
			visit(node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			visit(node.value);
		}
	}

//	public void traverseLevelOrder() {
//		
//		if (root == null) {
//			return;
//		}
//
//		Queue<Node> nodes = new LinkedList<>();
//		nodes.add(root);
//
//		while (!nodes.isEmpty()) {
//
//			Node node = nodes.remove();
//
//			System.out.print(" " + node.value);
//
//			if (node.left != null) {
//				nodes.add(node.left);
//			}
//
//			if (node.right != null) {
//				nodes.add(node.right);
//			}
//		}
//	}

	public void traverseInOrderWithoutRecursion() {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		//System.out.println("outside while loop current value :" + current.value);
		stack.push(root);
		while (!stack.isEmpty()) {
			while (current.left != null) {
				current = current.left;
				//System.out.println("Current value from while :" + current.value);
				stack.push(current);
			}
			current = stack.pop();
			//System.out.println("current :" + current.value);
			visit(current.value);
			if (current.right != null) {
				current = current.right;
				//System.out.println("Current value from if :" + current.value);
				stack.push(current);
			}
		}
	}

	public void traversePreOrderWithoutRecursion() {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.pop();
			visit(current.value);

			if (current.right != null)
				stack.push(current.right);

			if (current.left != null)
				stack.push(current.left);
		}
	}

	public void traversePostOrderWithoutRecursion() {
		Stack<Node> stack = new Stack<Node>();
		Node prev = root;
		Node current = root;
		stack.push(root);

		while (!stack.isEmpty()) {
			current = stack.peek();
			boolean hasChild = (current.left != null || current.right != null);
			boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

			if (!hasChild || isPrevLastChild) {
				current = stack.pop();
				visit(current.value);
				prev = current;
			} else {
				if (current.right != null) {
					stack.push(current.right);
				}
				if (current.left != null) {
					stack.push(current.left);
				}
			}
		}
	}

	private void visit(int value) {
		System.out.print(" " + value);
	}
    
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		do {
			System.out.println("\nSwitch Cases are as follows >> ");
			System.out.println("\n1.INSERTION : Insertion of values into singly list-1\n "
					+ "\n2.Traversing InOrder Output\n" + "\n3.Delete Operation on tree\n" + "\n4.Search a node in tree\n"
					+ "\n5.updating an element");

			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter the operation number  yu want to perform ");
			int s = sc2.nextInt();
			switch (s) {
			case 1:
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the size of tree  yu want");
				int size = sc.nextInt();
				System.out.println("Enter the integer values to be stored in tree :");
				for (int i = 0; i < size; i++) {
					int input = sc.nextInt();
					binaryTree.add(input);
				}
				System.out.println("size of binary tree is : " + binaryTree.getSize() );
				break;
			case 2:
				System.out.println("InOrder traversing output without recurssion is :");
				binaryTree.traverseInOrderWithoutRecursion();
				break;
			case 3:
				System.out.println("enter a value yu want delete from tree");
				Scanner sc3 = new Scanner(System.in);
				int value = sc3.nextInt();
				binaryTree.delete(value);
				System.out.println("Value has been deleted");
				break;
			case 4:
				System.out.println("Enter the value yu want to search :");
				Scanner sc4 = new Scanner(System.in);
				int search = sc4.nextInt();
				if(binaryTree.containsNode(search)) {
					System.out.println("value is there");
				}
				else {
					System.out.println("Value is not there");
				}
				break;
			case 5:
				Scanner sc5 = new Scanner(System.in);
				System.out.println("Enter the oldvalue yu want to update");
				int v = sc5.nextInt();
				System.out.println("Enter the newvalue yu want to update");
				int nv = sc5.nextInt();
				binaryTree.containsNodeAndUpdate(v, nv);
				break;
			default :
				System.out.println("No operation selected");
			}
		}
		while(true);
	}
}