package edu.Design.Structure.Decorator;

/**
 * Created by 存 on 2016/6/26.
 */
public class Test {

    public static void main(String[] args) {
        Sourceable decorator = new Decorator(new Source());
        decorator.method();
    }
}
