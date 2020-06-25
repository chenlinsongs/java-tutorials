package com.java.tutorials.logic;

/**
 * @author linsong.chen
 * @date 2020-06-14 12:14
 */
public class XOR {

    public static void main(String[] args) {
        Long var = 1534820390196514000L;
        System.out.println(var);

        Long rightShift = var ^ (var >>> 32);

        System.out.println(rightShift);

        System.out.println(Long.toBinaryString(var));
        System.out.println(Long.toBinaryString(rightShift));

        System.out.println("异或的结果十进制：");
        System.out.println(rightShift);
        System.out.println("异或十进制结果的二进制：");
        System.out.println(Long.toBinaryString(rightShift));


        System.out.println("对异或直接取地32位");
        System.out.println((int)(var ^ (var >>> 32)));//强制向下转，转为int
        System.out.println("对异或直接取地32位的二进制:");
        System.out.println(Integer.toBinaryString((int)(var ^ (var >>> 32))));//强制向下转，转为int


    }
}
