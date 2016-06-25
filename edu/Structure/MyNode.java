package edu.Structure;

/**
 * Created by 存 on 2016/5/11.
 */
public class MyNode<E> {

        /**
         * 链表的基本类
         * data 存当前数据，
         * next 存下一个数据
         * previous 存前一个数据
         *
         */
        public E data;
        public MyNode<E> next;
        public MyNode<E> previous;

        public MyNode(E data,MyNode<E> next,MyNode<E> previous){
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public MyNode(E data){
            this(data,null,null);
        }

        public MyNode(MyNode<E> next){
            this(null,next,null);
        }
}

