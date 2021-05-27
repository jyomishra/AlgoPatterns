package com.test.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Sol3 {

    public int lengthOfLongestSubstringMy(String s) {
        int maxLen = 0;
        char[] input = s.toCharArray();
        List<Character> slide = new ArrayList<Character>();
        for (int i = 0; i < input.length; i++) {
            int index = slide.indexOf(input[i]);
            if (index > -1) {
                maxLen = slide.size() > maxLen ? slide.size() : maxLen;
                slide = slide.subList(index + 1, slide.size());
            }
            slide.add(input[i]);
        }
        return slide.size() > maxLen ? slide.size() : maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            if (map.containsKey(ele)) { // dv i =2 c = 1
                int index = map.get(ele); // in = 1
                maxLen = curr > maxLen ? curr : maxLen;
                if (index > start) {
                    curr = curr - index + start;
                } else {
                    start = index + 1;
                } // s =2
            } else {
                curr++; // c = 2
            }
            map.put(ele, i);
        }
        return curr > maxLen ? curr : maxLen;
    }

    public static void main(String[] args) {
        Sol3 s = new Sol3();
        System.out.println(s.lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(s.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("abcabcbbc"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
        System.out.println(s.lengthOfLongestSubstring("ohomm"));
        System.out.println(s.lengthOfLongestSubstring("abba"));
    }
}