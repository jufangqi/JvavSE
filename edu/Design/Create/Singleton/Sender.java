package edu.Design.Create.Singleton;

/**
 * Created by 存 on 2016/6/13.
 */
public class Sender {

    private static Sender sender ;

    public static int a = 1;
    private Sender(){
        a++;
        System.out.println("Ok");
    }

    /**
     * 看起来挺完美的一个单例模式
     * 并不适合在多线程下跑
     * @return
     */
    public static Sender getSender_a(){
        if(sender==null){
            sender = new Sender();
        }
        return sender;
    }

    /**
     * 能在多线程下跑
     * 但效率低
     * @return
     */
    public static synchronized Sender getSender_b(){
        if(sender==null){
            sender = new Sender();
        }
        return sender;
    }

    /**
     * 看起来高效 其实有问题的
     * 由于JVM优化机制
     */
    public static Sender getSender_c(){
        synchronized (sender){
            if(sender==null){
                sender = new Sender();
            }
        }
        return sender;
    }

    /**
     * 终极完美的
     * 由于JVM类加载时保证线程互斥
     */
    private static class SenderFactory{
        private static Sender sender = new Sender();
    }
    public static Sender getSender_d(){
        return SenderFactory.sender;
    }
}
