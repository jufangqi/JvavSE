package edu.Design.Create.Abstract;

import edu.Design.Create.Sender;

/**
 * Created by 存 on 2016/6/13.
 */
public class Test {

    public static void main(String[] args) {
        Factory factory = new MailFactory();
        Sender sender = factory.getSender();
        sender.send();
    }
}
