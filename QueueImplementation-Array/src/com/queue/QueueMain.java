package com.queue;

import java.util.Scanner;


public class QueueMain {
	  // Driver code 
    public static void main(String[] args) 
    { 
    	
    	 int choice=0;  
		 char ch = ' ';
		    Scanner sc = new Scanner(System.in);  
		    Queue q = new Queue(4); 
		    System.out.println("*********Stack operations using array*********\n");  
		    System.out.println("\n------------------------------------------------\n");  
		    do
		    {  
		        System.out.println("\nChose one from the below options...\n");  
		        System.out.println("\n1.EnQueue\n2.DeQueue\n3.Show\n4.QueueFront\n5.Exit");  
		        System.out.println("\n Enter your choice \n");        
		        choice = sc.nextInt();  
		        switch(choice)  
		        {  
		            case 1:  
		            {   System.out.println("Enter the element to Enqueue");
		                 
		            
		            	q.queueEnqueue( sc.nextInt()); 
		                break;  
		            }  
		            case 2:  
		            {  
		            	 q.queueDequeue();   
		                break;  
		            }  
		            case 3:  
		            {  
		            	  q.queueDisplay();
		                break;  
		            }  
		            case 4:  
		            {  
		            	 q.queueFront(); 
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