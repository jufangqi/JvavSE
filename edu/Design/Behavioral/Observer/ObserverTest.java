package edu.Design.Behavioral.Observer;

/**
 * Created by 存 on 2016/6/12.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new MySunject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operation();
    }
}
