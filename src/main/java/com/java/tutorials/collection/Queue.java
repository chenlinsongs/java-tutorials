package com.java.tutorials.collection;


import com.java.tutorials.garbage.UnreachableObject;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author linsong.chen
 * @date 2020-06-13 17:12
 *
 * 构造个类的初衷是：在看ConcurrentLinkedQueue源码时，发现当删除一个节点后，节点并没有被真正的从链表上删除，而仅仅是将值置空，
 * 然后将节点的上一个节点指向被删节点的下一个节点，被删节点这时也还是指向他原先的下一个节点，那这种情况下，被删节点会被回收吗？
 * 为了确认这个问题，写了这个队列用于调试，测试方法参考 {@link UnreachableObject}
 */
public class Queue<E>{

    Node<E> head;
    Node<E> tail;

    public Queue(){
        head = tail = new Node<E>();
    }


    public boolean add(E e){
        Node node = new Node();
        node.item = e;
        tail.next = node;
        tail = node;
        if (head.item == null){
            head = node;
        }
        return true;
    }

    public boolean remove1(E e){
        Node pre;
        for (Node node = pre = head;;){
            if (node.item.equals(e)){
                if (node == head){
                    head = node.next;
                }else {
                    Node next = node.next;
                    if (next != null){
                        pre.next = next;
                    }
                }
            }
        }
    }


    /**ConcurrentQueue中的remove方法,改造返回值，返回被删除的对象 */
    public Node remove(Object o) {
        if (o != null) {
            Node<E> next, pred = null;
            for (Node<E> p = head; p != null; pred = p, p = next) {
                E item = p.item;
                if (item != null) {
                    if (!o.equals(item)) {
                        next = succ(p);
                        continue;
                    }
                    p.item = null;//改造,不用cas，不用满足并发
                }

                next = succ(p);
                if (pred != null && next != null) // unlink
                    pred.next = next;//改造,不用cas，不用满足并发
                return p;//改造，返回被删除的对象
            }
        }
        return null;
    }

    public Node getHead(){
        return this.head;
    }

    /**ConcurrentQueue中的succ方法*/
    final Node<E> succ(Node<E> p) {
        Node<E> next = p.next;
        return (p == next) ? head : next;
    }

    public static class Node<E> {
        volatile E item;
        volatile Node<E> next;

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

//    private static final Map<Node,?> INSTANCES = new WeakHashMap<Node,Void>();
//
//    public static void main(String[] args) {
//        Queue<String> queue = new Queue();
//        queue.add("a");
//        queue.add("b");
//        queue.add("c");
//
//        INSTANCES.put(queue.remove("b"),null);
//        INSTANCES.put(queue.getHead(),null);
//
//        System.out.println("gc before");
//
//        System.gc();
//
//        System.out.println("gc after");
//
//        new Thread().start();
//
//
//
//    }

}
