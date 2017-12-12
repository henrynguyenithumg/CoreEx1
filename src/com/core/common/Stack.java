package com.core.common;

import java.util.Arrays;

public class Stack<T> {
	private int count;
	private T[] data;

	public Stack() {
		data = (T[]) new Object[8];
		count = 0;
	}

	void expandCapacity() {
		data = Arrays.copyOf(data, data.length * 2);
	}

	public void push(T e) {
		if (count == data.length)
			expandCapacity();
		data[count++] = e;
	}

	public T pop() throws Exception {
		if (count <= 0) {
			throw new Exception("stack empty");
		}
		count--;
		return data[count];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	int size() {
		return count;
	}

	public static void main(String[] args) throws Exception {
		Stack<String> s = new Stack<String>();
		s.push("Alice");
		s.push("Bob");
		s.push("Carl");
		s.push("Dave");

		while (!s.isEmpty())
			System.out.println(s.pop());
	}
}
