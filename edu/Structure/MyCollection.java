package edu.Structure;

/**
 * Created by 存 on 2016/5/11.
 */
public interface MyCollection<Q> {
        /**
         * 所有实现类的接口
         * 定义了所有方法
         */

        int size();//返回其集合长度

        boolean isempty();//返回其是否为空

        void clean();//移除所有元素

        boolean contains(Q e);//如果列表中有此元素则返回true

        boolean equals(Object o);//返回是否与指定对象相等

        boolean romove(Q e);//移除指定对象

}
