package net.Design.FactoryMethod.Only;

/**
 * Created by 存 on 2016/6/10.
 * 单个工厂测试类
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce(1);
        if(sender!=null){
            sender.Send();
        }
    }
}
