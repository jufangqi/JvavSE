package net.Design.Singleton;

/**
 * Created by 存 on 2016/6/10.
 * 简单的单例模式
 */
public class Singleton {

    //持有私有静态实例  赋值为null 目的是为了延迟加载
    private static Singleton singleton = null;

    //私有化构造器
    private Singleton(){
        abc++;
        System.out.println("jiazaiwanbi");
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return singleton;
    }

    public static int abc = 1;

    /**
     * 开放一个public 方法 用于获取实例 单线程的 能满足基本的要求 但是放在多线程下 就胡搞了
     * @return
     */
    public static Singleton getSingleton1(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 第二种方法：  为了在多线程下能跑 加线程锁
     *  这种方法 是加了线程锁 很安全， 但是singleton就第一次加载的时候需要加线程锁 之后就不需要了
     *  这样效率会低下 需要优化下
     */

    public static synchronized  Singleton getSingleton2(){
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 第三种方法：  为了高效
     * 但是有问题了：
     *模拟两个线程A B
     *A B 同时进入第一个判断
     *A首先进入， JAVA初始化和赋值是分开进行的 但是JVM 并不保证这两个步骤的先后顺序
     *如果 先是 开辟一个空间 然后将地址空间分配给singleton 然后在对singleton进行初始化 这样的话就错了
     *A获取到singleton的地址然后A就出去了，B进来发现其不为空 然后也走了
     * B想要调用下，，，GG
     *测试了下 基本上全都是上面的情况
     */
    public static Singleton getSingleton3(){
        if (singleton==null){
            synchronized (singleton){
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    /**
     * 第四种方法: 为了完美
     * 由于JVM机制  一个类加载的时候 这个加载过程是线程互斥的
     * 所以创建一个静态内部类 里面实例化一个静态的实例
     * 完美
     */
    private static class SingletonFactory{
        private static Singleton singleton = new Singleton();
    }
    public Singleton getSingleton4(){
        return SingletonFactory.singleton;
    }
}
