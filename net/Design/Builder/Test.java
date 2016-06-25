package net.Design.Builder;

/**
 * Created by 存 on 2016/6/11.
 * 建造者模式 将各种产品更加集中起来管理
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.procuceMailSender(2);

    }
}
