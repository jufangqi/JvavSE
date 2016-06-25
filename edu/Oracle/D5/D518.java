package edu.Oracle.D5;

/**
 * Created by 存 on 2016/5/18.
 *  Thread  线程
 * 实现多线程的三种方式
 *      继承Thread类   run
 *      实现Ranable接口   run
 *      实现Callable接口 call
 *      启动线程调用start方法
 */

public class D518 extends Thread{

    int time ;
    D518 d2 =null;
    public D518(int time) {this.time = time;}

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            if(i==5 && d2!=null){
                try {
                    d2.join();
                } catch (InterruptedException e) {}
            }
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try {Thread.sleep(1000/time);} catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        D518 d1 = new D518(1);
        d1.setName("线程1");
        D518 d2 = new D518(1);
        d2.setName("线程2");

        d1.d2 = d2;
        d1.start();//开始
        d2.start();//开始

        d2.interrupt();//中断
        d1.yield();//礼让，不等于让别人来，只是重新同时站在同一起跑线上
       // new Thread(new D518(1)).start();
//        if(d1.index>4){
//            d2.join();
//        }

//        d1.join();//插队
//        Thread.sleep(1000/time);

    }
}