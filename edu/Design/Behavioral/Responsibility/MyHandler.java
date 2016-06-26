package edu.Design.Behavioral.Responsibility;

/**
 * Created by 存 on 2016/6/12.
 */
public class MyHandler extends AbstractHandler implements Handler {

    String name ;
    public MyHandler(String name){
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name+"deal!");
        if (getHandler()!=null){
            getHandler().operator();
        }
    }
}
