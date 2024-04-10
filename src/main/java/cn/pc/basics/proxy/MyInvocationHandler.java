package cn.pc.basics.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始" + method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("end");
        return invoke;
    }

    public Object getProxy(){
       return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 指定目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个，这是一个数组
                new MyInvocationHandler(target) );  // 代理对象处理器)

    }

}
