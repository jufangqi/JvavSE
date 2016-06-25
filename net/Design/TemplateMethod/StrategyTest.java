package net.Design.TemplateMethod;

/**
 * Created by 存 on 2016/6/12.
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator plus = new Plus();
        int result = plus.calculate(exp,"\\+");
        System.out.println(result);
    }
}
