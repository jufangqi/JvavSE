package net.Design.Memento;

/**
 * Created by 存 on 2016/6/12.
 */
public class Test {

    public static void main(String[] args) {

        //原始类
        Original original = new Original("egg");
        //备忘录
        Storage storage = new Storage(original.createMemento());
        //修改原始类
        System.out.println("初始化状态为:"+original.getValue());
        original.setValue("chicken");
        System.out.println("修改后状态为:"+original.getValue());
        //回复原始状态
        original.restoreMemento(storage.getMemento());
        System.out.println("恢复后状态为:"+original.getValue());
    }
}
