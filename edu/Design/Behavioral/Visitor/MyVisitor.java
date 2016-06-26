package edu.Design.Behavioral.Visitor;

/**
 * Created by 存 on 2016/6/12.
 */
public class MyVisitor implements Visitor {
    @Override
    public void visit(Subject subject) {
        System.out.print("visit the subject:" +
                subject.getSubject());
    }
}
