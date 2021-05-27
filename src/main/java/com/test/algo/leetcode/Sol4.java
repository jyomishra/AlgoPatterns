package com.test.algo.leetcode;

public class Sol4 {
	private int st, maxlen = 0;

	public String longestPalendromicSubstring(String s) {
		if (s.length() < 2) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			expandFor(s, i, i);
			expandFor(s, i, i + 1);
		}
		return s.substring(st, st + maxlen);
	}

	public void expandFor(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if (maxlen < r - 1 - l) {
			st = l + 1;
			maxlen = r - 1 - l;
		}
	}

	public static void main(String[] args) {
		Sol4 s = new Sol4();
		System.out.println(s.longestPalendromicSubstring("ababdad"));
		s = new Sol4();
		System.out.println(s.longestPalendromicSubstring("dvdf"));
		s = new Sol4();
		System.out.println(s.longestPalendromicSubstring("xdvd"));
		s = new Sol4();
		System.out.println(s.longestPalendromicSubstring("abbadabbx"));
	}
}