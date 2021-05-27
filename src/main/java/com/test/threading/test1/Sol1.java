package com.test.threading.test1;

public class Sol1 {
	static long MAX_NUM = Integer.MAX_VALUE;

	private long start;
	private long end;
	private long sum;

	public Sol1(long start, long end) {
		this.start = start;
		this.end = end;
	}

	public void add() {
		for (long i = start; i <= end; i++) {
			sum = sum + i;
		}
	}

	public static void twoThread() throws InterruptedException {
		long start = System.currentTimeMillis();

		Sol1 s1 = new Sol1(0, MAX_NUM / 2);
		Sol1 s2 = new Sol1(MAX_NUM / 2 + 1, MAX_NUM);

		Thread t1 = new Thread(() -> s1.add());
		Thread t2 = new Thread(() -> s2.add());

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		long finalCount = s1.sum + s2.sum;
		long end = System.currentTimeMillis();
		System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
	}

	public static void oneThread() {
		long start = System.currentTimeMillis();

		Sol1 s1 = new Sol1(0, MAX_NUM);
		s1.add();

		long finalCount = s1.sum;
		long end = System.currentTimeMillis();
		System.out.println("One threads final count = " + finalCount + " took " + (end - start));
	}

	public static void main(String[] args) throws InterruptedException {
		twoThread();
		oneThread();
	}
}
