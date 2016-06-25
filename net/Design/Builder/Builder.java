package net.Design.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 存 on 2016/6/11.
 */
public class Builder {

    private List<Sender> list = new ArrayList<>();

    public void procuceMailSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void procuceSmsSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
}
