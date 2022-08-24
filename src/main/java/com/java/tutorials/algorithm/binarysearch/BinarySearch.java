package com.java.tutorials.algorithm.binarysearch;

/**
 * @author chenlinsong
 * @version 1.0.0
 * @description
 * @date @date: 2022/5/24 11:56 下午
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {0,1,2,3,4,5,6,7,8};
        int number = 0;
        System.out.println(binarySearch.binarySearch(array,number));
    }

    public int binarySearch(int[] array,int number){
        int low = 0;
        int high = array.length-1;
        while (true){
            int mid = (low + high)/2;
            if (array[mid] == number){
                return mid;
            }else if (array[mid] > number){
                high = mid-1;
            }else if ((array[mid] < number)){
                low = mid+1;
            }
            if (low == high){
                if (array[low] == number){
                    return low;
                }else return -1;
            }
        }

    }
}
