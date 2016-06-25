package net.Design.Proxy;

/**
 * Created by 存 on 2016/6/11.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method");
    }
}
