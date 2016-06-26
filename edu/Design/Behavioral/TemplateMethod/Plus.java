package edu.Design.Behavioral.TemplateMethod;

/**
 * Created by 存 on 2016/6/12.
 */
public class Plus extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1+num2;
    }
}
