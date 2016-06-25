package net.Design.Adapter;

/**
 * Created by 存 on 2016/6/11.
 * 类的
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method2");
    }
}
