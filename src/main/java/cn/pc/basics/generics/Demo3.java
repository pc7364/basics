package cn.pc.basics.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author pc
 * @Date 2024/4/10 17:05
 */
public class Demo3 {

    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Number>();
        list.add(null);
//        list.add(1); 报错
        Number number = list.get(0);
        System.out.println(number);

        List<? super Integer> list12 = new ArrayList<Integer>();

        //list12.add(new Object());
        Object object = list12.get(0);


    }
}
