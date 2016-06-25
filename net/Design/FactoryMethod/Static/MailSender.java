package net.Design.FactoryMethod.Static;

/**
 * Created by 存 on 2016/6/10.
 * 创建实现类
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mailSender");
    }
}
