package net.Design.Singleton;

/**
 * Created by 存 on 2016/6/10.
 */
public class TestSingleton implements Runnable{

    @Override
    public void run() {
        Singleton singleton = Singleton.getSingleton3();
        System.out.println(singleton.abc);
    }

    public static void main(String[] args) {
        new Thread(new TestSingleton()).start();
        new Thread(new TestSingleton()).start();
    }
}
