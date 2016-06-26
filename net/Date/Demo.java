package net.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Demo {

    /*
     * JDBC下设置时间
     * SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd");
     * Date time =  fmt1.parse("2016-04-04");
     * String sql = String.format("insert into timetext (time) values('%s')", fmt1.format(time));
     * stmt.executeUpdate(sql);
     */
    public static void main(String[] args) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");        //格式设置 大写M
            Date date = format.parse(getin());                                //传参数
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);                                    //	设置时间格式
            int day = calendar.get(Calendar.DATE);                //拿到当天天数
            print(calendar, day);                //调用输出
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void print(Calendar calendar, int day) {   //输出
        calendar.set(Calendar.DATE, 1);            //当月一号

        int maxdate = calendar.getActualMaximum(Calendar.DATE);   //最大天数

        System.out.println("日\t一\t 二\t三\t四\t五\t六");

        for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {   //前几天空格
            System.out.print('\t');
        }
        for (int i = 1; i <= maxdate; i++) {                    //循环 天数加一   如果周天 换行
            if (i == day) {
                System.out.print("*");
            }
            System.out.print(i);
            if (i == day) {
                System.out.print("*");
            }
            System.out.print("\t");
            int w = calendar.get(Calendar.DAY_OF_WEEK);
            if (w == Calendar.SATURDAY) {
                System.out.print('\n');
            }
            calendar.add(Calendar.DATE, 1);
        }
    }

    public static String getin() {
        System.out.println("Please send eg:2007-1-12");
        System.out.println("GET IN :");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.next();
        return temp;
    }

}