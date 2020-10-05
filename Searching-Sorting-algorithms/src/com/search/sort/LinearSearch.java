package com.search.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {

	class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void addNode(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void LinearsearchValue(int data) {

		Node present = head;

		int pos = 0;

		boolean flag = false;

		if (head == null) {
			System.out.println("List is Empty ");
		} else {

			while (present != null) {
				if (present.data == data) {
					flag = true;
					break;
				} else {
					present = present.next;
					pos++;
				}
			}
		}
		if (flag) {
			System.out.println("data is present in the list at position :" + pos);
		} else {
			System.out.println("data is not found");
		}
	}

	public Node middleNode(Node start, Node last) {
		if (start == null)
			return null;

		Node slow = start;
		Node fast = start.next;

		while (fast != last) {
			fast = fast.next;
			if (fast != last) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}

	Node binarySearch(Node head, int value) {

		Node start = head;
		Node last = null;

		do {
			// Find Middle
			Node mid = middleNode(start, last);
			System.out.println("\nmid element " + mid.data + " start " + start.data);
			// If middle is empty
			if (mid == null)
				return null;

			// If value is present at middle
			if (mid.data == value)
				return mid;

			// If value is less than mid
			else if (mid.data < value) {
				start = mid.next;
			}

			// If the value is more than mid.
			else
				last = mid;

			// System.out.println("start value "+start.data + " last "+last.data);
		} while (last == null || last != start);

		// value not present
		return null;
	}

	void deleteNode(int position) {
		if (head == null)
			return;

		Node temp = head;

		if (position == 0) {
			head = temp.next;
			return;
		}
		for (int i = 1; i < position; i++) {
			temp = temp.next;
		}
		Node next = temp.next.next;

		temp.next = next;
	}

	public void BubblesortList() {
		Node current = head, index = null;
		int temp;
		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;
				while (index != null) {
					if (current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	public void selectionSort(Node head) {

		for (Node node1 = head; node1 != null; node1 = node1.next) {
			Node min = node1;
			for (Node node2 = node1; node2 != null; node2 = node2.next) {
				if (min.data > node2.data) {
					min = node2;
				}

				Node temp = new Node(node1.data);
				node1.data = min.data;
				min.data = temp.data;
			}
		}
	}

	public void insertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public void shellSort(int arrayToSort[]) {
		int n = arrayToSort.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int key = arrayToSort[i];
				int j = i;
				while (j >= gap && arrayToSort[j - gap] > key) {
					arrayToSort[j] = arrayToSort[j - gap];
					j -= gap;
				}
				arrayToSort[j] = key;
			}
		}
	}

	public void mergeSort(int[] a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}

	public void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

	public int partition(int intArray[], int low, int high) {
		int pi = intArray[high];
		int i = (low - 1); // smaller element index
		for (int j = low; j < high; j++) {
			// check if current element is less than or equal to pi
			if (intArray[j] <= pi) {
				i++;
				// swap intArray[i] and intArray[j]
				int temp = intArray[i];
				intArray[i] = intArray[j];
				intArray[j] = temp;
			}
		}

		// swap intArray[i+1] and intArray[high] (or pi)
		int temp = intArray[i + 1];
		intArray[i + 1] = intArray[high];
		intArray[high] = temp;

		return i + 1;
	}

	void quick_sort(int intArray[], int low, int high) {
		if (low < high) {
			// partition the array around pi=>partitioning index and return pi
			int pi = partition(intArray, low, high);

			// sort each partition recursively
			quick_sort(intArray, low, pi - 1);
			quick_sort(intArray, pi + 1, high);
		}
	}

	// heap sort

	public void heapsort(int arr[]) {
		int n = arr.length;

		// Build max heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// Heap sort
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Heapify root element
			heapify(arr, i, 0);
		}
	}

	public void heapify(int arr[], int n, int i) {
		// Find largest among root, left child and right child
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] > arr[largest])
			largest = l;

		if (r < n && arr[r] > arr[largest])
			largest = r;

		// Swap and continue heapifying if root is not largest
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, n, largest);
		}
	}

	// radix sort

	public int get_max_val(int my_arr[], int arr_len) {
		int max_val = my_arr[0];
		for (int i = 1; i < arr_len; i++)
			if (my_arr[i] > max_val)
				max_val = my_arr[i];
		return max_val;
	}

	public void countSort(int my_arr[], int arr_len, int exp) {
		int result[] = new int[arr_len];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < arr_len; i++)
			count[(my_arr[i] / exp) % 10]++;
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		for (i = arr_len - 1; i >= 0; i--) {
			result[count[(my_arr[i] / exp) % 10] - 1] = my_arr[i];
			count[(my_arr[i] / exp) % 10]--;
		}
		for (i = 0; i < arr_len; i++)
			my_arr[i] = result[i];
	}

	public void radix_sort(int my_arr[], int arr_len) {
		int m = get_max_val(my_arr, arr_len);
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(my_arr, arr_len, exp);
	}

	// display
	public void display() {

		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		while (current != null) {
			System.out.print(current.data + " " + "reference :" + current.next + "\n");

			current = current.next;
		}
		// System.out.println();
	}

	// array display
	public void printArray(int myArray[]) {
		int n = myArray.length;
		for (int i = 0; i < n; ++i)
			System.out.print(myArray[i] + " ");

		System.out.println();
	}

	public static void main(String[] args) {

		LinearSearch lstobj = new LinearSearch();
		int arr[] = { 12, 11, 13, 5, 6, 14, 67, 34, 23, 56, 35 };
		do {
			System.out.println("\nSwitch Cases are as follows >> ");
			System.out.println("\n1.INSERTION : Insertion of values into singly list-1\n "
					+ "\n2.Display : display list-1\n" + "\n3.Search : Search Operation\n"
					+ "\n4.Delete : Delete Operation\n" + "\n5.BubbleSort the list\n"
					+ "\n6.BinarySearch : Search Operation\n" + "\n7.Slection sort\n" + "\n8.Shell sort using array\n"
					+ "\n9.Insertion sort using array\n" + "\n10.display the Array\n" + "\n11.Merge Sor\n"
					+ "\n12.Quick sort\n" + "\n13.Radix Sort\n" + "\n14.Heap sort");

			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter the operation number  yu want to perform ");
			int s = sc2.nextInt();
			switch (s) {
			case 1:
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the size of linked list yu want");
				int size = sc.nextInt();
				System.out.println("Enter the integer values to be stored in list1 :");
				for (int i = 0; i < size; i++) {
					int input = sc.nextInt();
					lstobj.addNode(input);
				}
				break;
			case 2:
				System.out.println("LIST 1 IS : ");
				lstobj.display();
				break;
			case 3:
				System.out.println("Enter the integer yu want to search :");
				Scanner sc3 = new Scanner(System.in);
				int checkvalue = sc3.nextInt();
				lstobj.LinearsearchValue(checkvalue);
				break;
			case 4:
				System.out.println("Enter the integer yu want to Delete :");
				Scanner sc4 = new Scanner(System.in);
				int deletevalue = sc4.nextInt();
				lstobj.deleteNode(deletevalue);
				break;
			case 5:
				System.out.println("List has been Sort using bubble sort :");
				lstobj.BubblesortList();
				break;
			case 6:
				System.out.println("Enter the integer yu want to search :");
				Scanner sc5 = new Scanner(System.in);
				int item = sc5.nextInt();
				System.out.println("List after binary sort ");
				Node ck = lstobj.binarySearch(lstobj.head, item);
				if (ck == null) {
					System.out.println("Value is not present");
				} else {
					System.out.println("Value is present");
				}
				break;
			case 7:
				System.out.println("List has been sort using selection sort");
				lstobj.selectionSort(lstobj.head);
				break;
			case 8:
				System.out.println("List has been sorted by using Shell sort");
				lstobj.shellSort(arr);
				break;
			case 9:
				System.out.println("List has been sorted by using insertion sort");
				lstobj.insertionSort(arr);
				break;
			case 10:
				System.out.println("Array is:");
				lstobj.printArray(arr);
				break;
			case 11:
				System.out.println("List has been sorted using merge sort");
				lstobj.mergeSort(arr, arr.length);
				break;
			case 12:
				System.out.println("List has been sort using quick sort");
				lstobj.quick_sort(arr, 0, arr.length - 1);
				break;
			case 13:
				System.out.println("List has been sort using radix sorting");
				lstobj.radix_sort(arr, arr.length);
			case 14:
				System.out.println("List has been sorted using heap sort");
				lstobj.heapsort(arr);
			default:
				System.out.println("No Operation");
				break;
			}

		} while (true);
	}
}
