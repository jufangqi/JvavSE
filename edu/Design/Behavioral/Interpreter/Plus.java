package edu.Design.Behavioral.Interpreter;

/**
 * Created by 存 on 2016/6/12.
 */
public class Plus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}
