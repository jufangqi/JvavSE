package net.Design.FactoryMethod.Static;

/**
 * Created by 存 on 2016/6/10.
 * 静态工厂测试类
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}
