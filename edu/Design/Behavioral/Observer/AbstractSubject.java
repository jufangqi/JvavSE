package edu.Design.Behavioral.Observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by 存 on 2016/6/12.
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> observers = new Vector<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        Enumeration<Observer> enumo = observers.elements();
        while (enumo.hasMoreElements()){
            enumo.nextElement().Update();
        }
    }

}
