package com.priority;

//Java program to demonstrate the 
//working of PriorityQueue 
import java.util.*; 

 public class PriorityExample { 
	
	// Main Method 
	public static void main(String args[]) 
	{ 
		// Creating empty priority queue 
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 

		// Adding items to the pQueue using add() 
		pQueue.add(10); 
		pQueue.add(21); 
		pQueue.add(31); 
		pQueue.add(41);
		
		

		System.out.println(pQueue);
		// Printing the top element of PriorityQueue
		pQueue.remove(30);
		System.out.println(pQueue);
		System.out.println(pQueue.poll()); 
		System.out.println(pQueue);
		System.out.println(pQueue.peek()); 

		// Printing the top element and removing it 
		// from the PriorityQueue container 
		System.out.println(pQueue.poll()); 
		System.out.println(pQueue);
		// Printing the top element again 
		System.out.println(pQueue.peek()); 
		System.out.println(pQueue.poll()); 
		System.out.println(pQueue);
	} 
} 

