package edu.Design.Create;

/**
 * Created by 存 on 2016/6/13.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mailSender");
    }
}
