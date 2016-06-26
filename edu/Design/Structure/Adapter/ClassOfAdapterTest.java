package edu.Design.Structure.Adapter;

/**
 * Created by 存 on 2016/6/20.
 */
public class ClassOfAdapterTest {

    public static void main(String[] args) {
        TargeTable adapter = new Adapter();
        adapter.method2();
        adapter.method1();
    }
}
