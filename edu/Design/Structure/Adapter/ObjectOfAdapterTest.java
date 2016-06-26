package edu.Design.Structure.Adapter;

/**
 * Created by 存 on 2016/6/26.
 */
public class ObjectOfAdapterTest {
    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper(new Source());
        wrapper.method2();
        wrapper.method1();
    }
}
