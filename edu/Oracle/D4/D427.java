package edu.Oracle.D4;

/**
 * Created by 存 on 2016/4/27.
 */

/**
 * catch里返回返回了a，存在于返回值变量区
 * 执行final 重新返回了a。覆盖了catch里的返回值。
 */
public final class D427{

    public static void main(String[] args) {
        // System.out.println(tt());
        // est();
        //  System.out.println(g());
        // System.out.println(f().toString());
    }

    /**
     * 先进行返回为qw 将str的地址引用存入返回类型的临时变量中
     * 再进行finally的运算，改变的str的返回值，所以返回值为qwe.
     */
    static  StringBuffer str = new StringBuffer("q");
    public static StringBuffer f(){
        try {
             return str.append("w");
        }finally {
            str.append("e");
        }
    }

    /**
     * 先进行返回，返回的是0，存进返回的int类型的临时变量区中。
     * 注意aa是新赋值了得。并不是直接返回aa。
     * 然后进行a++运算。
     * @return
     */
    static int aa = 0;
    public static int g (){
        try{
            return aa;
        }finally {
            aa++;
        }
    }

    /**
     * 初始化为0，catch中进行a++  先返回1存进去 再执行finally中的 将0替换掉。
     * @return 1
     */
    private static int  a ;
    private static int tt(){
        try{
            int i = 1/0;
        }catch (Exception e){
            return a++;
        }
        finally {
            return a;
        }
    }

    public static void est(){
        try {
            throw new  Exception();
        } catch (Exception e) {
            System.out.println("My Exception");
        }
    }
}

/**
 * 自己写Exception 需要重写里面的printStackTrace()
 */
class MyException extends Exception{
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}