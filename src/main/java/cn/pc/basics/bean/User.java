package cn.pc.basics.bean;


public class User {
    private Integer userId;

    private String userName;

    public void eat(){
        System.out.println("吃东西");
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
