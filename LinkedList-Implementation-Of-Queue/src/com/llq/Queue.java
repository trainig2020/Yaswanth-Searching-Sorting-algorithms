package com.llq;

public class Queue {
   
    QNode front, rear; 
    
    public Queue() 
    { 
        front = rear = null; 
    } 
  
    // Method to add an key to the queue. 
    void enqueue(int key) 
    { 
  
        // Create a new LL node 
        QNode temp = new QNode(key); 
  
        // If queue is empty, then new node is front and rear both 
        if (rear == null) { 
            front = rear = temp; 
            return; 
        } 
  
        // Add the new node at the end of queue and change rear 
        rear.next = temp; 
        rear = temp; 
    } 
  
    // Method to remove an key from queue. 
    void dequeue() 
    { 
        // If queue is empty, return NULL. 
        if (front == null) 
            return; 
  
        // Store previous front and move front one node ahead 
        QNode temp = front; 
        front = front.next; 
  
        // If front becomes NULL, then change rear also as NULL 
        if (front == null) 
            rear = null; 
    } 
	
}
