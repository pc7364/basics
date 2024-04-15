package cn.pc.basics.collection;

import apple.laf.JRSUIUtils;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Desc
 * @Author pc
 * @Date 2024/4/11 16:59
 */
public class DemoSet {

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.remove(1);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(3);
        System.out.println(treeSet);

        Set<Integer> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(3);
        linkedHashSet.add(33);
        linkedHashSet.add(6);

        System.out.println(linkedHashSet);

    }

}
