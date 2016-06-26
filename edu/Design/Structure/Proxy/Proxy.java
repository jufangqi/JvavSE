package edu.Design.Structure.Proxy;

/**
 * Created by 存 on 2016/6/11.
 */
public class Proxy implements Sourceable {

    private Source source ;
    public Proxy(){
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        System.out.println("before");
        source.method();
        System.out.println("after");
    }
}
