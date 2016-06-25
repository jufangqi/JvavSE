package edu.Design.Create.Builder;

import edu.Design.Create.MailSender;
import edu.Design.Create.Sender;
import edu.Design.Create.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 存 on 2016/6/13.
 * 只是将所有对象放在一个集合里管理，，，
 */
public class Builder {

    List<Sender> mail = new ArrayList<Sender>();
    List<Sender> sms = new ArrayList<Sender>();

    public void addMail(){
        mail.add(new MailSender());
    }

    public void addSms(){
        sms.add(new SmsSender());
    }
}
