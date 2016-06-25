package edu.Design.Create.Factory;

import edu.Design.Create.MailSender;
import edu.Design.Create.Sender;
import edu.Design.Create.SmsSender;

/**
 * Created by 存 on 2016/6/13.
 */
public class SenderFactory {

    /**
     * 简单工厂虽然简单，但是 在选择的时候 不返回空 而是扔空指针异常 这个方法很GAY
     * @param i
     * @return
     */
    public Sender getSender(int i){
        if(i==1){
            return new MailSender();
        }else if(i==2) {
            return new SmsSender();
        }else {
            throw new NullPointerException("Gun");
        }
    }

    /**
     * 多个工厂模式
     */
    public Sender getSmsSender(){
        return new SmsSender();
    }
    public Sender getMailSender(){
        return new MailSender();
    }

    /**
     * 静态工厂模式
     */
    public static Sender getStaticSmsSender(){
        return new SmsSender();
    }
    public static Sender getStaticMailSender(){
        return new MailSender();
    }
}
