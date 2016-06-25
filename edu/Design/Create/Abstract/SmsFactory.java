package edu.Design.Create.Abstract;

import edu.Design.Create.Sender;
import edu.Design.Create.SmsSender;

/**
 * Created by 存 on 2016/6/13.
 */
public class SmsFactory implements Factory {
    @Override
    public Sender getSender() {
        return new SmsSender();
    }
}
