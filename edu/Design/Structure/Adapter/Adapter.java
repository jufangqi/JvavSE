package edu.Design.Structure.Adapter;

/**
 * Created by 存 on 2016/6/20.
 */
public class Adapter extends Source implements TargeTable{
    @Override
    public void method2() {
        System.out.println("this is method2");
    }
}
