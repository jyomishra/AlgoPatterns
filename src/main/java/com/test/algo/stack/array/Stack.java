package com.test.algo.stack.array;

import java.util.List;
import java.util.ArrayList;

public class Stack {

	private List<Integer> list = new ArrayList<>();

	public void push(int data) {
		list.add(data);
	}

	public int pop() throws Exception {
		if (list.size() > 0) {
			int data = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return data;
		} else {
			throw new Exception("No element in stack");
		}
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(7);
		s.push(10);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
