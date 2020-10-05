package com.queue;

public class Queue {
	private static int front, rear, capacity;
	private static int queue[];

	Queue(int c) {
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}

	void queueEnqueue(int data) {
		if (capacity == rear) {
			System.out.printf("\nQueue is full\n");
		} else {
			queue[rear] = data;
			rear++;
		}
	}

	void queueDequeue() {
		if (front == rear) {
			System.out.printf("\nQueue is empty\n");
			return;
		} else {
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}

			// store 0 at rear indicating there's no element
			if (rear < capacity)
				queue[rear] = 0;

			// decrement rear
			rear--;
		}
		return;
	}

	void queueDisplay() {
		int i;
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		for (i = front; i < rear; i++) {
			System.out.printf(" %d <-- ", queue[i]);
		}
		return;
	}

	void queueFront() {
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		System.out.printf("\nFront Element is: %d", queue[front]);
		return;
	}
}
