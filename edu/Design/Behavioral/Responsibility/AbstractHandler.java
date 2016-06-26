package edu.Design.Behavioral.Responsibility;

/**
 * Created by 存 on 2016/6/12.
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler(){
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
