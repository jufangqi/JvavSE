package edu.Design.Structure.Adapter;

/**
 * Created by 存 on 2016/6/20.
 */
public class Wrapper implements TargeTable{

    private Source source;
    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is wrapper's method2");
    }

    public Wrapper(Source source){
        this.source = source;
    }
}
