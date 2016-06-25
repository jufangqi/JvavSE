package edu.Design.Create.Abstract;

import edu.Design.Create.MailSender;
import edu.Design.Create.Sender;

/**
 * Created by 存 on 2016/6/13.
 */
public class MailFactory implements Factory {
    @Override
    public Sender getSender() {
        return new MailSender();
    }
}
