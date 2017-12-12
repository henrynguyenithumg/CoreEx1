package com.core.common;

import java.util.Arrays;

public class Queue<T> {
	private T[] data;
	private int count;
	private int front;
	private int rear;

	public Queue() {
		data = (T[]) new Object[10];
		count = front = rear = 0;
	}

	void expandCapacity() {
		T[] newData = (T[]) new Object[data.length * 2];

		// copy elements to the new array one by one
		for (int index = 0; index < count; index++)
			newData[index] = data[(front + index) % data.length];

		front = 0;
		rear = count;
		data = newData;
	}

	void enqueue(T e) {
		if (count == data.length)
			expandCapacity();
		data[rear] = e;
		rear = (rear + 1) % data.length; // may round up
		count++;
	}

	T dequeue() throws Exception {
		if (count <= 0) {
			throw new Exception("Queue empty");
		}
		count--;
		T ret = data[front];
		data[front] = null; // set the removed element to null
		front = (front + 1) % data.length;
		return ret;
	}

	boolean isEmpty() {
		return count == 0;
	}

	int size() {
		return count;
	}

	public String toString() {
		return "size: " + count + ", front: " + front + ", rear: " + rear + ", " + Arrays.toString(data);
	}

	public static void main(String[] args) throws Exception {
		Queue<String> q = new Queue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		System.out.println(q);

		while (!q.isEmpty())
			System.out.println(q.dequeue());

		Queue<Integer> q2 = new Queue<Integer>();
		for (int i = 10; i < 100; i += 10)
			q2.enqueue(i);

		while (!q2.isEmpty())
			System.out.println(q2.dequeue());
	}
}
