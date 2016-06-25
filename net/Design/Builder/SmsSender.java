package net.Design.Builder;

/**
 * Created by 存 on 2016/6/11.
 */
public class SmsSender implements Sender {

    public SmsSender(){
        System.out.println("SmsSender create");
    }

    @Override
    public void Send() {
        System.out.println("this is a SmsSender");
    }
}
