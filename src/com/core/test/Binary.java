package com.core.test;

import java.util.Scanner;

import com.core.common.Stack;

public class Binary {
	// Using recursion
	public static void convertRecursion(int n) {
		if (n == 0)
			return;
		convertRecursion(n / 2);
		System.out.print(n % 2);
	}

	// Using stack
	public static void convertStack(int n) throws Exception {
		Stack<Integer> s = new Stack<Integer>();
		while (n > 0) {
			s.push(n % 2);
			n /= 2;
		}
		while (!s.isEmpty())
			System.out.print(s.pop());
	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type in an integer:");
		int n = scan.nextInt();
		System.out.println("Binary representation (recursion): ");
		convertRecursion(n);
		System.out.println("Binary representation (stack): ");
		convertStack(n);
	}
}
