package net.Design.Strategy;

/**
 * Created by 存 on 2016/6/11.
 */
public class Multiply extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\*");
        return arrayInt[0]*arrayInt[1];
    }
}
