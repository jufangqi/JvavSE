package edu.Design.Structure.Facade;

/**
 * Created by 存 on 2016/6/11.
 */
public class User {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
