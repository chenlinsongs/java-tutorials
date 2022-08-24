package com.java.tutorials.algorithm.binarysearch;

/**
 * @author chenlinsong
 * @version 1.0.0
 * @description
 * @date @date: 2022/5/25 12:21 上午
 */
public class TomcatBinarySearch {
    public static void main(String[] args) {
        TomcatBinarySearch tomcatBinarySearch = new TomcatBinarySearch();
        String[] array = {"abc","abcd","abcde","abcdef"};
        String name = "a";
        System.out.println(tomcatBinarySearch.binarySearch(array,name));
    }

    public int binarySearch(String[] map,String name){
        int i = 0;
        int a = 0;
        int b = map.length - 1;
        while (true) {
            i = (b + a) >>> 1;
            int result = name.compareTo(map[i]);
            if (result > 0) {
                a = i;
            } else if (result == 0) {
                return i;
            } else {
                b = i;
            }
            if ((b - a) == 1) {
                int result2 = name.compareTo(map[b]);
                if (result2 < 0) {
                    return a;
                } else {
                    return b;
                }
            }
        }
    }
}
