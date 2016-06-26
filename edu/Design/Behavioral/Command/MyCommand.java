package edu.Design.Behavioral.Command;

/**
 * Created by 存 on 2016/6/12.
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
