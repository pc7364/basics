package cn.pc.basics.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @Desc
 * @Author pc
 * @Date 2024/4/11 17:18
 */
public class DemoList {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(23);
        list.add(2);


        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(23);
        list1.add(2);
        System.out.println(list1);
        List<Integer> list2 = list1.subList(0, 2);
        list1.remove(1);   //这个会报错  ConcurrentModificationException
        System.out.println(list1);
        System.out.println(list2);


        Vector<Integer> vector = new Vector<>();
        vector.add(132);
    }
}
