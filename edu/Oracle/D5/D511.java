package edu.Oracle.D5;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * 网络编程篇
 * Created by 存 on 2016/5/11.
 */

public class D511 {
    public static void main(String[] args) throws IOException {
        D511 d = new D511();
        URL url1 = new URL("http://www.readnovel.com/novel/339913/563.html");
        d.loadBook(url1);
//        for (int i = 0; i < 10; i++) {
//            URL url = new URL("http://www.readnovel.com/novel/339913/"+i+".html");
//            URL url1 = new URL("http://www.readnovel.com/book/339913/"+i+".html");
//            System.out.println("第"+i+"章完毕");
//            d.loadNovel(url);
//
//        }
    }

    public void loadBook(URL url1) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url1.openStream(),Charset.forName("GBK")));
        StringBuffer sb = new StringBuffer();
        String temp = "";
        while((temp=br.readLine())!=null){
            sb.append(temp);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("F://Temp/book"));
        bw.write(sb.toString());
        bw.flush();
    }
    public void loadNovel(URL url)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("GBK")));
        StringBuffer sb = new StringBuffer();

        String temp;
        while((temp=br.readLine())!=null){
            sb.append(temp);
        }
        String [] t1 = sb.toString().split("<div class=\"zhangjie\">");
        //load文字部分
        String [] t2 = t1[1].split("<div class=\"zhichi\">");
        String [] t3 = t2[0].split("<div class=\"miaoshu\">");
        String txt = t3[0];
        txt = txt.replaceAll("<BR>","");
        txt = txt.replaceAll("</P>","");
        txt = txt.replaceAll("<P>","");
        txt = txt.replaceAll("　　","\r\n");
        txt = txt.trim();
        //load标题
        String [] tt1 = t1[0].split("</title>");
        String [] tt2 = tt1[0].split("<title>");
        String title = tt2[1].split("-")[0];
        String bigtittle =(title.split("》")[0]).split("《")[1];
        String lowtittle =title.split("》")[1];

        txt = lowtittle+"\r\n"+txt+"\r\n";
        BufferedWriter bw = new BufferedWriter(new FileWriter("F://Temp/"+bigtittle+".txt",true));
        bw.write(txt);
        bw.flush();
        bw.close();
    }
}
