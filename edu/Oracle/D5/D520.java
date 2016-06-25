package edu.Oracle.D5;

/**
 * Created by 存 on 2016/5/20.
 */
public class D520 extends Thread{
    static int apple = 5;//静态的全局唯一
    Object o = new Object();

    public static void main(String[] args) {
        //为了方便观察 new 了四个线程出来
        new D520().start();
        new D520().start();
        new D520().start();
        new D520().start();
    }

    /**
     * 如果这样玩的话， 相当于每一个对象都有一个线程 在这里面枷锁，
     * 并不能锁住什么，所以这个锁是在这种情况下无效的
     * 相当于踢足球一样 每个人手里都拿一个球，各玩各的，
     * 只是因为你将足球个数定义成静态的了，
     * 运行下就看出来了，是一窝蜂的进去了，
     * 所以在这种情况有一种可能是：
     * 第一个a线程进去 第二个b线程也进去
     * 当运行到apple--;时 也就是apple = apple-1；
     * 由于JVM优化机制 并不保证这两个步骤的先后顺序
     * 如果 先是对apple-1 然后在开辟一个空间将地址空间分配给apple 这样的话就错了
     * A执行了apple-1然后A就出去了，B也这么干了 然后也走了
     * 对其进行赋值的时候就两个都是4了
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 进入Run");
        synchronized (o){
            System.out.println(Thread.currentThread().getName()+" 进入锁");
            apple--; // apple= apple -1;
            System.out.println(Thread.currentThread().getName()+apple);
            System.out.println(Thread.currentThread().getName()+" 离开锁");
        }
        System.out.println(Thread.currentThread().getName()+" 结束Run");
    }


    /**
     * 这个是经过更改后的方法，就是单另开一个方法设置成静态的。然后对这个静态方法上锁
     * 然后去调
     * 这样就是想要的结果了
     */
//    public synchronized static void sub(){
//        System.out.println(Thread.currentThread().getName()+" 进入锁");
//        apple = apple -1;
//        System.out.println(Thread.currentThread().getId()+" "+apple);
//        System.out.println(Thread.currentThread().getName()+" 离开锁");
//    }
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName()+" 进入Run");
//       sub();
//        System.out.println(Thread.currentThread().getName()+" 离开Run");
//    }

}
