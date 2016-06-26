package edu.Design.Behavioral.Command;

/**
 * Created by 存 on 2016/6/12.
 */
public class Test {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
