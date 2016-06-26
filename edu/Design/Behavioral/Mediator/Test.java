package edu.Design.Behavioral.Mediator;

/**
 * Created by 存 on 2016/6/12.
 */
public class Test {

    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
