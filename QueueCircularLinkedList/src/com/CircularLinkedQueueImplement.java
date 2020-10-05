package com;

import java.util.Scanner;

public class CircularLinkedQueueImplement {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class linkedQueue */
		LinkedQueue lq = new LinkedQueue();
		/* Perform Queue Operations */
		System.out.println("Linked Queue Test\n");

		while (true) {
			System.out.println("\nQueue Operations");
			System.out.println("1. insert");
			System.out.println("2. remove");
			System.out.println("3. peek");
			System.out.println("4. check empty");
			System.out.println("5. size");
			System.out.println("6. Exit");

			System.out.println("\n Enter your choice : ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				lq.insert(scan.nextInt());
				break;
			case 2:
				try {
					System.out.println("Removed Element = " + lq.remove());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Peek Element = " + lq.peek());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 4:
				System.out.println("Empty status = " + lq.isEmpty());
				break;

			case 5:
				System.out.println("Size = " + lq.getSize());
				break;

			case 6:
				System.out.println("Exiting....");
				System.exit(0);
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* display queue */
			lq.display();

		}
	}
}