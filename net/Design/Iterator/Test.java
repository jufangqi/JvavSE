package net.Design.Iterator;

/**
 * Created by 存 on 2016/6/12.
 */
public class Test {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator iterator = new MyIterator(collection);
        while (iterator.hasnext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
