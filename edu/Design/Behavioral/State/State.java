package edu.Design.Behavioral.State;

/**
 * Created by 存 on 2016/6/12.
 * 核心类
 */
public class State {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("execute the first opt");
    }
    public void method2(){
        System.out.println("execute the second opt");
    }

}
