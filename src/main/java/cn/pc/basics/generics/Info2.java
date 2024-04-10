package cn.pc.basics.generics;

/**
 * @Desc
 * @Author pc
 * @Date 2024/4/10 16:58
 */
public class Info2<T extends Number> {

    private T var ;        // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }

}
