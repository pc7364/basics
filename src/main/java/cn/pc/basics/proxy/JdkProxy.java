package cn.pc.basics.proxy;

import java.lang.reflect.Proxy;

public class JdkProxy {

    public static void main(String[] args) {
        OrderService orderService = new OrderImpl();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(orderService);
        OrderService proxy = (OrderService)myInvocationHandler.getProxy();
        proxy.getOrderNum();

    }

}
