package edu.Design.Behavioral.Mediator;

/**
 * Created by 存 on 2016/6/12.
 */
public class User1 extends User {

    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("User1 998");
    }
}
