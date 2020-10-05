package com.circularqueue;

public class Main {

    public static void main(String[] args) {

        CircularQueue<Integer> circularQueue = new CircularQueue(8);

        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);

        System.out.println("Full Circular Queue" + circularQueue);

        System.out.print("Dequeued following element from circular Queue ");
        
        System.out.println(circularQueue.dequeue() + " ");
        System.out.println("Full Circular Queue" + circularQueue);
        circularQueue.enqueue(23);
        System.out.println("After enqueueing circular queue with element having value 23");
        System.out.println(circularQueue);
        System.out.print("Dequeued following element from circular Queue ");
        System.out.println(circularQueue.dequeue() + " ");
        System.out.println(circularQueue);
        circularQueue.enqueue(29);
        System.out.println(circularQueue);
        
        
    }

}

