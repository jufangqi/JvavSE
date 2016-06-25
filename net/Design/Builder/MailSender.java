package net.Design.Builder;

/**
 * Created by 存 on 2016/6/11.
 */
public class MailSender implements Sender{

    public MailSender(){
        System.out.println("MailSender create");
    }
    @Override
    public void Send() {
        System.out.println("this is a mailSender");
    }
}
