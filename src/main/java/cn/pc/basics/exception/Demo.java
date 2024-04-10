
package cn.pc.basics.exception;

/**
 * @Desc
 * @Author pc
 * @Date 2024/4/10 16:47
 */
public class Demo {

    public static void main(String[] args) {

        try{
            if(true){
                int i = 1/0;
            }
        }catch (Exception e){
            System.out.println("1");
        }


    }



}
