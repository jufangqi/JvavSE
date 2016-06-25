package edu.Design.Create.Factory;

import edu.Design.Create.Sender;

/**
 * Created by 存 on 2016/6/13.
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        test.Testa();
//        test.Testb();
        test.Testc();
    }

    /**
     * 普通工厂测试
     */
    public void Testa(){
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.getSender(2);
        sender.send();
    }
    /**
     * 多个工厂测试
     */
    public void Testb(){
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.getMailSender();
        sender.send();
    }
    /**
     * 静态工厂模式
     */
    public void Testc(){
        Sender sender =SenderFactory.getStaticMailSender();
        sender.send();
    }
}
