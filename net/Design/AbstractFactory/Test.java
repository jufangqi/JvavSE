package net.Design.AbstractFactory;

/**
 * Created by 存 on 2016/6/10.
 */
public class Test {

    public static void main(String[] args) {
        Provider provider = new MailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
