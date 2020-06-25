package com.java.tutorials.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linsong.chen
 * @date 2020-06-14 11:18
 */
public class ArrayListFailFast {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        for (String s : list){
            if ("two".equals(s)){
                list.remove(s);
            }
        }

        System.out.println(list);

    }
}
