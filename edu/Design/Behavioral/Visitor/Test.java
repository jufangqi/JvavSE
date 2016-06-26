package edu.Design.Behavioral.Visitor;

/**
 * Created by 存 on 2016/6/12.
 */
public class Test {

    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject subject = new MySubject();
        subject.accept(visitor);
    }
}
