package net.Design.Command;

/**
 * Created by 存 on 2016/6/12.
 */
public class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
