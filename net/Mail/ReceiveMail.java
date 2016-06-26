package net.Mail;

import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;

/**
 * Created by 存 on 2016/6/26.
 */
public class ReceiveMail {

    // 连接pop3服务器的主机名、协议、用户名、密码
    private String pop3Server = "pop.163.com";
    private String protocol = "pop3";
    private String user = "butanoler@163.com";
    private String pwd = "dc13245768";
    private Properties props = null;
    private Session session = null;
    private Store store = null;
    private Folder folder = null;
    public Message[] messages = null;

    public ReceiveMail() {
        // 创建一个有具体连接信息的Properties对象
        props = new Properties();
        props.setProperty("mail.store.protocol", protocol);
        props.setProperty("mail.pop3.host", pop3Server);

        // 使用Properties对象获得Session对象
        session = Session.getInstance(props);
        session.setDebug(true);

        // 利用Session对象获得Store对象，并连接pop3服务器
        try {
            store = session.getStore();
            store.connect(pop3Server, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获得邮箱内的邮件夹Folder对象，以"只读"打开
        try {
            folder = store.getFolder("inbox");
            folder.open(Folder.READ_ONLY);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // 获得邮件夹Folder内的所有邮件Message对象
        try {
            messages = folder.getMessages();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void reading(Message message) throws Exception {
        ReciveOneMail reciveOneMail = new ReciveOneMail(message);
        System.out.println("邮件的时间：" + reciveOneMail.getSentDate());
        System.out.println("邮件的主题：" + reciveOneMail.getSubject());
        System.out.println("邮件的发件人地址：" + reciveOneMail.getFrom());
        System.out.println("邮件的内容" + reciveOneMail.getBodyText());
        boolean iscont = reciveOneMail.isContainAttach(message);
        System.out.println("邮件是否含有附件" + iscont);
        if (iscont) {
            reciveOneMail.saveAttachMent((Part) message);
        }
    }

    public void close() {
        try {
            folder.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ReceiveMail rm = new ReceiveMail();
        for (Message m : rm.messages) {
            rm.reading(m);
            new Scanner(System.in).nextLine();
        }
        rm.close();

    }
}
