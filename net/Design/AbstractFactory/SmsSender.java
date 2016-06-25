package net.Design.AbstractFactory;

/**
 * Created by 存 on 2016/6/10.
 */
public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is SmsSender");
    }
}
