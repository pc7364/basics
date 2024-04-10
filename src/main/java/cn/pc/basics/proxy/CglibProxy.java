package cn.pc.basics.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.swing.*;
import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        OrderService proxy =(OrderService) cglibProxy.getProxy(OrderImpl.class);
        proxy.getOrderNum();
    }

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置要创建的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("开始");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("结束");
        return o1;
    }
}
