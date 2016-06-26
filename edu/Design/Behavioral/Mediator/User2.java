package edu.Design.Behavioral.Mediator;

/**
 * Created by 存 on 2016/6/12.
 */
public class User2 extends User {

    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("User2 1000");
    }
}
