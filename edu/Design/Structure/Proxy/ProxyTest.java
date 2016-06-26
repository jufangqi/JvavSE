package edu.Design.Structure.Proxy;

/**
 * Created by 存 on 2016/6/11.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
