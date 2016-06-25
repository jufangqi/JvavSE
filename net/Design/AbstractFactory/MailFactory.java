package net.Design.AbstractFactory;

/**
 * Created by 存 on 2016/6/10.
 */
public class MailFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
