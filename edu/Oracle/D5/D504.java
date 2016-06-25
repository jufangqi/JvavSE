package edu.Oracle.D5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 映射测试
 * Created by 存 on 2016/5/6.
 */
public class D504 {

    /**
     *属性测试
     * 调用私有化，公有化属性
     * 根据属性给对象赋值
     */
    public void testField() throws Exception {
        Tree tree = Tree.getTree();
        Class c = Tree.class;
        Field []  f = c.getDeclaredFields();
        for (Field field:f)
            System.out.println(field.toString());
        System.out.println(tree.getAge());
        f[0].setAccessible(true);
        f[0].set(tree,"133");
        System.out.println(tree.getAge());
    }

    /**
     *方法测试。
     * 私有化方法的调用
     * 设置方法是否可以读写
     */
    public void testMethod() throws Exception {
        Tree tree = Tree.getTree();
        Class c = Tree.class;
       // Method[] m = c.getDeclaredMethods();
        Method m = c.getDeclaredMethod("sout",String.class);
        System.out.println(m.toString());
        m.setAccessible(true);
        m.invoke(tree,"LoadTxt");
    }

    /**
     * 构造方法测试
     *
     */
    public void testConstructor() throws Exception {
        Class c = Tree.class;
        Constructor ct = c.getDeclaredConstructor();
        ct.setAccessible(true);
        Tree tr = (Tree) ct.newInstance();
        System.out.println(tr.getAge());
    }
    public static void main(String[] args) throws Exception {
        D504 d = new D504();
        System.out.println("属性测试:");
        d.testField();
        System.out.println("方法测试:");
        d.testMethod();
        System.out.println("构造方法测试:");
        d.testConstructor();
//        Object o = ct.newInstance();
    }
}

/**
 * 测试类
 * 里面有测试的属性 方法 构造器
 */
class Tree{
    private String age = "122";
    public String na;

    public static Tree t =null;
    private Tree(){
        System.out.println("执行了Tree构造方法");
    }
    public String getAge(){
        return this.age;
    }
    public static  Tree getTree(){
        return t = new Tree() ;
    }
    protected void tt(){
        System.out.println("asd");
    }
    private void sout(String name){
        System.out.println("name:"+name);
    }
}
