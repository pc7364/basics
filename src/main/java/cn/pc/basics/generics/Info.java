package cn.pc.basics.generics;

/**
 * @Desc
 * @Author pc
 * @Date 2024/4/10 16:49
 */
public class Info<T>{
    // 定义泛型变量
    private T var ;
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
