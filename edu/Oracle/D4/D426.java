package edu.Oracle.D4;

/**
 * Created by 存 on 2016/4/26.
 */
public class D426 {

    /**
     * Try catch Finally
     * 代码出现异常，且未进行异常捕获，不会运行下面的
     */
    public void TryTest(){
        String str = null;
        int []a = new int [2];
        System.out.println(1);
        try {
            System.out.println(a[2]);
        }catch (NullPointerException e){
            System.out. println("联系管理员 错误代码001");
        }catch (Exception e ){
            e.printStackTrace();
            System.out.println("88");
        }
        System.out.println(2);
    }
    /**
     * StringBuilder的使用，里面方法的调用
     * reverse 反转
     * append
     * insert 插入
     */
    public void StringBuilderTest(){
        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        StringBuilder sb1 = new StringBuilder(sb);
        sb.reverse();
        sb.append(sb1);
        System.out.println(sb);
    }
    public static void main(String[] args) {
       D426 d = new D426();
       //d.StringBuilderTest();
        d.TryTest();
//      for (int i = 10132; i < 10182; i++) {
//            if (i%50==0) System.out.println();
//            System.out.print((char)i);
//        }
    }
}
