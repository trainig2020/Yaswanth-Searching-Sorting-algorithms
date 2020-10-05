package com;

import java.util.NoSuchElementException;

class LinkedQueue
{
    protected Node front, rear;
    public int size;
    
    public LinkedQueue()
    {
        front = null;
        rear = null;
        size = 0;
    }    
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return front == null;
    }    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element to the queue */
    public void insert(int data)
    {
        Node nptr = new Node(data, null);
        if (rear == null)
        {
            front = nptr;
            rear = nptr;
            nptr.next=front;
        }
        else
        {
            rear.setNext(nptr);
            rear = rear.getNext();
            rear.next=front;
        }
        size++ ;
    }    
    /*  Function to remove front element from the queue */
    public int remove()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node ptr = front;
        front = ptr.getNext(); 
        rear.next=front;
        System.out.println("Current front Value is : "+front.data);
        if (front == null)
            rear = null;
        size-- ;       
        
        return ptr.getData();
    }    
    /*  Function to check the front element of the queue */
    public int peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }    
    /*  Function to display the status of the queue */
    public void display()
    {
    	Node ptr = front;
        System.out.print("\nQueue = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        
        
        if (front.getNext() == front) 
        {
            System.out.println(front.getData()+ "->"+ptr.getData()+ "\n" );
            return;
        }
        
        System.out.print(front.getData()+ " -> ");
        ptr = front.getNext();
        while (ptr.getNext() != front)
        {
            System.out.print(ptr.getData()+ " -> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ " -> ");
        ptr = ptr.getNext();
        System.out.print(ptr.getData()+ "\n");     
    }
}