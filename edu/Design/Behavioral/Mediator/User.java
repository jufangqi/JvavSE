package edu.Design.Behavioral.Mediator;

/**
 * Created by 存 on 2016/6/12.
 */
public abstract class User {

    private Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public User(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void work();
}
