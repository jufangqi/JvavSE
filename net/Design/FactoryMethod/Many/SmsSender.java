package net.Design.FactoryMethod.Many;

/**
 * Created by 存 on 2016/6/10.
 * 创建的另一个实现类
 */
public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is SmsSender");
    }
}
