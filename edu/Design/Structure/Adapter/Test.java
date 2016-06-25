package edu.Design.Structure.Adapter;

/**
 * Created by 存 on 2016/6/20.
 */
public class Test {

    public static void main(String[] args) {
        TargeTable adapter = new Adapter();
        adapter.method2();
        adapter.method1();

        //对象的适配器模式
        Wrapper wrapper = new Wrapper(new Source());
        wrapper.method1();
        wrapper.method2();
    }
}
