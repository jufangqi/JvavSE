package net.Design.Iterator;

/**
 * Created by 存 on 2016/6/12.
 */
public class MyCollection implements Collection {

    public String [] strings = {"A","B","C","D","E","F"};
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object get(int i) {
        return strings[i];
    }

    @Override
    public int size() {
        return strings.length;
    }
}
