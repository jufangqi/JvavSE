package net.Design.FactoryMethod.Many;

/**
 * Created by 存 on 2016/6/10.
 * 单个工厂测试类
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produceMail();
//        Sender sender1 = sendFactory.produceSms();
        sender.Send();
    }
}
