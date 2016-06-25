package edu.Oracle.D4;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 存 on 2016/4/22.
 */
public class D422 {
    /**
     * 3.Math
     *  Random存在于java.lang包下的Math类的一个Random方法 和java.util包下的Random方法
     *  java.math 大数据进行运算
     */

    /**
     * 2.格式化
     *  数字格式化 java.text包下的DecimalFormat类
     *  时间格式化 java.text包下的DateFormat类
     *  #代表任意位 0代表一位
     *  有四舍五入
     *  parse 传入参数返回时间
     *  format传入时间返回格式化好的时间字符串
     */
    public void Text2(){
        DecimalFormat decimalFormat= new DecimalFormat("$##.0");
        String string = decimalFormat.format(123.152);
        System.out.println(string);
        DateFormat dfm = new  SimpleDateFormat("yy-MM-dd:hh-mm-ss");    	//格式设置 大写M
        Date date = new Date();
        try {
            date =dfm.parse("16-5-12:21-14-35");						//传参数
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dfm.format(date));
    }
    /**
     * 1.包裹类
     * Integer Character
     * 字符串与Integer之间的转化
     */
    public void Test(){
        String string = "123";
        Integer in = new Integer(string);
        Integer in2 =  Integer.valueOf(string);
        Integer in3 = Integer.parseInt(string);
        System.out.println(in+" * "+in2+" * "+in3);
        String string2 = in+"";
        String string3 = in.toString();
    }

    public static void main(String[] args) {
        D422 t = new D422();
        t.Test();
        System.out.println("*****************");
        t.Text2();
    }
}
