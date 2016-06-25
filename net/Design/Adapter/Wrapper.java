package net.Design.Adapter;

/**
 * Created by 存 on 2016/6/11.
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }
    public Wrapper() {
       source = new Source();
    }

    @Override
    public void method1() {
       source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
