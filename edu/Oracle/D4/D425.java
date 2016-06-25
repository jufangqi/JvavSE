package edu.Oracle.D4;

/**
 * Created by 存 on 2016/4/25.
 */
public class D425 {

    /**
     * 用replace实现替换功能，如果替换成"" 那么就可以计算出当前字符串的这个字符的数量
     */
    public void Jjs(){
        String str = "AZazfAzX";
        int [] a  = new int[52] ;
        for (int i = 0; i < 26; i++) {
            String temp = (char)(i+97)+"";
            a[i] = str.length() - str.replace(temp,"").length();
            String temp1 = (char)(i+65)+"";
            a[i+26]= str.length()-str.replace(temp1,"").length();
        }
        for (int i = 0; i <52; i++) {
            if (a[i]!=0){
                if (i<26)
                    System.out.println((char) (i+97)+" : "+a[i]+"  ");
                else
                    System.out.println((char)(i+39)+" : "+a[i]+"  ");
            }
        }
    }
    /**
     * 实现字符串当前某个单词出现次数
     *
     */
    public void Js(){
        String str = "AzaZf";
        int []a =new int[52];
        for (int i = 0; i < str.length(); i++) {
            char aa = str.charAt(i);
            for (int j = 'a'; j <= 'z'; j++) {
                if (aa == (char)j){
                    a[j-97]++;
                }
                if(aa == (char)(j-32)){
                    a[j-71]++;
                }
            }
        }
        for (int i = 0; i <52; i++) {
            if (a[i]!=0){
                if (i<26)
                    System.out.println((char) (i+97)+" : "+a[i]+"  ");
                else
                    System.out.println((char)(i+39)+" : "+a[i]+"  ");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        D425 d = new D425();
      //  d.Jjs();
    }
}
