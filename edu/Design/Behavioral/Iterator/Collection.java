package edu.Design.Behavioral.Iterator;

/**
 * Created by 存 on 2016/6/12.
 */
public interface Collection {

    public Iterator iterator();

    public Object get(int i);

    public int size();
}
