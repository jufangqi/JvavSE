package net.Design.Decorator;

/**
 * Created by 存 on 2016/6/11.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Sourceable source = new Source();
        source = new Decorator(source);//实现了动态的增加 也能减少
        source.method();
    }
}
