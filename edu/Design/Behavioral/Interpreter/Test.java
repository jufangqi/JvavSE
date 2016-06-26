package edu.Design.Behavioral.Interpreter;

/**
 * Created by 存 on 2016/6/12.
 */
public class Test {

    //计算4+5-6
    public static void main(String[] args) {
        int result = new Minus().interpret(new Context(new Plus().interpret(new Context(4, 5)), 6));
        System.out.println(result);
    }
}
