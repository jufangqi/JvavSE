package edu.Structure;

/**
 * Created by 存 on 2016/5/11.
 */
public class MyArrayList<Q> implements MyList<Q>{

        private transient Object[] elementData;

        private int size;

        public MyArrayList(int initialCapacity){//有参构造器的实现，传入int指定初始链表大小
            if(initialCapacity<0)
                throw new IllegalArgumentException("初始值不能为负");
            this.elementData = new Object[initialCapacity];
        }
        public MyArrayList(){//无参构造器实现，初始值为0
            this(4);
        }

        @Override
        public int size() {
            // TODO 返回当前链表长度
            return this.size;
        }

        @Override
        public boolean isempty() {
            // TODO Auto-generated method stub
            return this.size==0;
        }

        @Override
        public boolean contains(Object o) {
            // TODO Auto-generated method stub
            for (int i = 0; i < this.size; i++) {
                if(elementData[i]==o){
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean add(Q q) {
            // TODO Auto-generated method stub
            return add(size,q);
        }

        @Override
        public boolean add(int index, Q q) {
            // TODO Auto-generated method stub
            if(this.size<index || index<0)
                throw new IndexOutOfBoundsException();
            if(this.size==elementData.length){
                Object [] temp = new Object[elementData.length];
                System.arraycopy(elementData, 0, temp, 0, elementData.length);
                elementData = new Object[elementData.length*2-1];
                System.arraycopy(temp, 0, elementData, 0, temp.length);
            }
            System.arraycopy(elementData,index,elementData,index+1,size-index);

            elementData[index] = q;
            this.size++;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            // TODO 实现删除某个指定的元素
            for (int i = 0; i < this.size; i++) {
                if(o.equals(elementData[i])){
                    if(i!=elementData.length-1)
                        System.arraycopy(elementData,i+1, elementData, i, size-i-1);
                    this.size--;
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean removeall(MyCollection<?> o) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean remove(int index) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void clean() {
            // TODO Auto-generated method stub

        }

    @Override
    public boolean romove(Q e) {
       return false;
    }

    @Override
        public Q get(int index) {
            // TODO 根据索引获取链表中的某个元素
            if(index>=size)
                throw new IndexOutOfBoundsException();
            return (Q)elementData[index];
        }

        @Override
        public Q set(int index, Q element) {
            // TODO 设置某个元素
            Q old = get(index);
            elementData[index] = element;
            return old;
        }

        @Override
        public int indexOf(Object o) {
            // TODO 根据传入对象 反回对象应索
            Q temp = (Q)o;
            for (int i = 0; i < size; i++) {
                if(temp.equals(elementData[i]))
                    return i;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            // TODO Auto-generated method stub
            Q temp = (Q)o;
            for (int i = size-1; i >=0; i--) {
                if(temp.equals(elementData[i]))
                    return i;
            }
            return -1;
        }

}
