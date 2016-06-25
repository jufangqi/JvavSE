package net.Design.Strategy;

/**
 * Created by 存 on 2016/6/11.
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "2+9";
        ICalculator calculator = new Plus();
        int result = calculator.calculate(exp);
        System.out.println(result);
    }
}
