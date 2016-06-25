package edu.Design.Create.Singleton;

/**
 * Created by 存 on 2016/6/13.
 */
public class Test implements Runnable {

    public static void main(String[] args) {
//        Sender sendera = Sender.getSender_a();
//        Sender senderb = Sender.getSender_b();
//        Sender senderd = Sender.getSender_d();
//        Sender senderc = Sender.getSender_c();
        new Thread(new Test()).start();
        new Thread(new Test()).start();
    }

    @Override
    public void run() {
        Sender.getSender_c();
        System.out.println(Sender.a);
    }
}
