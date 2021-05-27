package com.test.algo.leetcode;

public class Sol5 {

	public String zigZagConversion(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1) return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuilder();
		}
		boolean incr = false;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (j == 0 || j == numRows - 1) {
				incr = !incr;
			}
			sb[j].append(s.charAt(i));
			j = incr ? j + 1 : j - 1;
		}

		for (int i = 1; i < numRows; i++) {
			sb[0] = sb[0].append(sb[i]);
		}

		return sb[0].toString();
	}

	public static void main(String[] args) {
		Sol5 s = new Sol5();
		System.out.println(s.zigZagConversion("PAYPALISHIRING", 3));
		System.out.println(s.zigZagConversion("PAYPALISHIRING", 4));
	}
}