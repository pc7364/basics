package cn.pc.basics.proxy;

public class OrderImpl implements OrderService{
    @Override
    public int getOrderNum() {
        System.out.println(120);
        return 120;
    }
}
