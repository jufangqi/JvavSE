package net.Design.FactoryMethod.Only;

/**
 * Created by 存 on 2016/6/10.
 * 创建工厂类
 */
public class SendFactory {
    public  Sender produce(int a){
        if(a==1){
            return new MailSender();
        }else if(a==2){
            return new SmsSender();
        }else {
            System.out.println("Nothing to do");
            return null;
        }
    }
}
