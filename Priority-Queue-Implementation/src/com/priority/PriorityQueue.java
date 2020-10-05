package com.priority;

import java.util.Scanner;

public class PriorityQueue {
	
class Node {
		
		int data;
		Node next;
		int priority;
		
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
			
		}
		
	}

Node front = null;

void insertPQueue(int data,int priority)
{
	Node node = new Node(data);
	node.priority = priority;
	if(front == null)
	{
		front = node;
		front.priority = priority;
		front.next = null;
		System.out.println("value inserted as head "+node.data);
		
	}else
	{
		
		if(front.priority > priority)
		{
			node.next = front;
			front = node;
			//front.priority = priority;
			System.out.println("Node added before front."+front.data + " "+front.priority);
		}
		else
		{
			Node temp =front;
			while(temp.next != null && temp.next.priority<priority)
			{
				
				temp = temp.next;
			}
			node.next = temp.next;
			 temp.next =node;
			// temp.priority = priority;
			 System.out.println("nodes added after head" +node.data + " "+node.priority);
		}
	}
	
}
void deletePQueue()
{
	if(front == null)
	{
		System.out.println("Empty Queue");
	}else
	{
	Node temp = front.next;
	
	if(temp == null)
	{
		front = null;
	}
	else
	{
		front = front.next;
		System.out.println("element removes at front.");
	}
	}
}

void peekFront()
{
	if(front == null)
	{
		System.out.println("Queue is empty");
	}else
	{
		System.out.println("first element in queue is "+front.data );
	}
}

void display()
{
	if(front == null)
	{
		System.out.println("Queue is empty");
	}else
	{
		Node temp =front;
		System.out.println("values are ");
		while(temp !=null)
		{
			System.out.println(temp.data);
			temp =temp.next;
		}
	}
}

public static void main(String[] args)
{
	PriorityQueue pq = new PriorityQueue();
		
	
	char ch ;
	int choice;
	  System.out.println("********* Priority Queue operations *********\n");  
	    System.out.println("\n------------------------------------------------\n");  
	    do
	    {  
	        System.out.println("\nChose one from the below options...\n");  
	        System.out.println("\n1.EnQueue\n2.DeQueue\n3.Show\n4.QueueFront");  
	        System.out.println("\n Enter your choice \n");     
	        Scanner sc = new Scanner(System.in);
	        choice = sc.nextInt();  
	        switch(choice)  
	        {  
	            case 1:  
	            {   
	            	System.out.println("Enter the element to Enqueue");
	                 int val =  sc.nextInt();
	                 System.out.println("Enter the priority to Enqueue");
	                 int pri = sc.nextInt();
	           pq.insertPQueue(val, pri); 
	                break;  
	            }  
	            case 2:  
	            {  
	            	pq.deletePQueue();   
	                break;  
	            }  
	            case 3:  
	            {  
	            	pq.display();
	                break;  
	            }  
	            case 4:  
	            {  
	            	pq.peekFront();
	                break;  
	            }  
	            default:  
	            {  
	                System.out.println("Please Enter valid choice ");  
	            }  
	        }
	           
	    }while (true);
	        
	    
}
	
	
	


}