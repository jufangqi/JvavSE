package edu.Design.Behavioral.Observer;

/**
 * Created by 存 on 2016/6/12.
 */
public interface Subject {

    public void add(Observer observer);

    public void del(Observer observer);

    public void notifyObserver();

    /*自身操作*/
    public void operation();
}
