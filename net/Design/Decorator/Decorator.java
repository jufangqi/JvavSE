package net.Design.Decorator;

/**
 * Created by 存 on 2016/6/11.
 */
public class Decorator extends Source {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable){
        super();
        this.sourceable = sourceable;
    }

    @Override
    public void method(){
        System.out.println("before");
        sourceable.method();
        System.out.println("after");
    }
}
