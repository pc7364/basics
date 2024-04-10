package cn.pc.basics.proxy;

import cn.pc.basics.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {


        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("成员变量"+declaredField.getName());
        }
        Field field = User.class.getDeclaredField("userId");
        field.setAccessible(true);
        System.out.println(field.getName());

        Constructor<User> declaredConstructor = User.class.getDeclaredConstructor();
        User user = declaredConstructor.newInstance();
        User.class.getMethod("eat").invoke(user);
    }

}
