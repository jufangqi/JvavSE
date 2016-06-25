package edu.Structure;

/**
 * MyList接口
 * 用于实现MyCollection接口
 * Created by 存 on 2016/5/11.
 */
public interface MyList<Q> extends MyCollection<Q> {

        int size();//用于返回链表长度

        boolean isempty();//用于返回链表是否为空

        boolean contains(Object o);//用于返回链表中是否存在此元素

        boolean add(Q q);//添加元素，添加位置在最后

        boolean add(int index,Q q);//用于添加元素，添加位置在index处

        boolean remove(Object o);//用于删除指定元素第一个

        boolean removeall(MyCollection <?> o);//用于删除指定的所有元素

        boolean remove(int index);//用于删除指定位置的元素

        void clean();//用于删除这个链表

        boolean equals(Object o);//用于判断两个链表是否相同

        Q get(int index);//用于返回指定索引处的元素

        Q set(int index,Q element);//用于修改指定索引处的元素

        int indexOf(Object o);//用于查找指定元素的索引位置，从前往后

        int lastIndexOf(Object o);//用于查找指定元素的位置，从后向前

}

