package edu.Design.Behavioral.Visitor;

/**
 * Created by 存 on 2016/6/12.
 */
public interface Subject {

    public void accept(Visitor visitor);
    public String getSubject();
}
