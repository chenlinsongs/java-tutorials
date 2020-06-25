package com.java.tutorials.garbage;

import com.java.tutorials.collection.Queue;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author linsong.chen
 * @date 2020-06-25 19:14
 *
 * 垃圾回收测试场景：一个对象已经没有被其他对象引用了，但是他却引用了其他对象，这种情况是否能被回收
 *
 * 测试结果表明能被回收
 *
 * 思路参考： (https://coderanch.com/t/581790/java/ways-find-number-alive-instances)
 */
public class UnreachableObject {

    private static final Map<Queue.Node,?> INSTANCES = new WeakHashMap<Queue.Node,Void>();

    public static void main(String[] args) {
        Queue<String> queue = new Queue();
        queue.add("a");
        queue.add("b");
        queue.add("c");

        INSTANCES.put(queue.remove("b"),null);
        INSTANCES.put(queue.getHead(),null);

        System.out.println("gc before");

        System.gc();

        System.out.println("gc after");

        new Thread().start();



    }
}
