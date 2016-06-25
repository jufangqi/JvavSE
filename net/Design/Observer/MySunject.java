package net.Design.Observer;

/**
 * Created by 存 on 2016/6/12.
 */
public class MySunject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self");
        notifyObserver();//66666666666666666666
    }
}
