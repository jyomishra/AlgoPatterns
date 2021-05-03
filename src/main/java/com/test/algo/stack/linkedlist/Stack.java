package com.test.algo.stack.linkedlist;

public class Stack {
	private class Node {
		int value;
		Node next;
	}

	private Node top;
	private int length;

	public Stack() {
		this.top = null;
		this.length = 0;
	}

	public void push(int value) {
		Node ele = new Node();
		ele.value = value;
		ele.next = top;
		top = ele;
		length++;
	}

	public int pop() throws Exception {
		if (top == null) {
			throw new Exception("No Value in stack");
		}
		int value = top.value;
		top = top.next;
		length--;
		return value;
	}

	public int length() {
		return length;
	}

	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(7);
		s.push(10);
		s.push(3);
		System.out.println("Length : " + s.length());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
