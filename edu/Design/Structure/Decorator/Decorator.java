package edu.Design.Structure.Decorator;

/**
 * Created by 存 on 2016/6/26.
 */
public class Decorator implements Sourceable {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    @Override
    public void method() {
        System.out.println("before");
        sourceable.method();
    }
}
