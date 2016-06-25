package org;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;

/**
 * Created by 存 on 2016/6/2.
 */
public class LoadPng {

    String webpath = "E://Temp/tt";
    public static void main(String[] args) throws Exception {

        LoadPng lp = new LoadPng();
        lp.gg();

    }

    public void ggg(LinkedList<String> linkedList,String type,String name) throws Exception {
        for (String path:linkedList) {

            String pp = path.substring(path.lastIndexOf("/"));
            System.out.println(pp);
            File file = new File("E://Temp/15hn/"+type+"/"+name+"/1.jpg");
            System.out.println(file.getName());
            file.getParentFile().mkdirs();
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file));
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "image/jpeg");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Keep-Alive", "timeout=60");
//            conn.setUseCaches(false);
//            conn.setDoOutput(true);
            BufferedInputStream br = new BufferedInputStream((conn.getInputStream()));

            byte [] temp = new byte[1024];
            int length;
            while ((length=br.read(temp))!=-1){
                bw.write(temp,0,length);
            }
            bw.flush();
            br.close();
            bw.close();
        }
    }
    public void gg() throws Exception {
        URL url = new URL("http://15hn.net/zhainanshe/2015/1003/1886.html");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("gb2312")));
        String tmep ;
        StringBuffer sb = new StringBuffer();
        while ((tmep=br.readLine())!=null){
            sb.append(tmep);
        }
        LinkedList<String> linkedList = new LinkedList<String>();
        String name="";
        String tempr [] = sb.toString().split("<img alt");
        for (int i = 1; i < tempr.length; i++) {
            tempr[i] = tempr[i].replaceFirst("=\"","");
            String [] tt = tempr[i].split("\"");
            name = tt[0];
            linkedList.add(tt[2]);
            System.out.println(tempr[i]);
        }
        ggg(linkedList,"zhaifuli",name);
    }
    public void g() throws Exception {
        URL url = new URL("http://15hn.net/zhaifuli/2016/0520/2028.html");
//        URL url = new URL("http://15hn.net/zhaifuli");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("gb2312")));
        String tmep = "";
        StringBuffer sb = new StringBuffer();
        while ((tmep=br.readLine())!=null){
            sb.append(tmep);
        }
//        http://images.126176.com:8818/allimg/160520/1-1605200RI9323.jpg
//        String tempr [] = sb.toString().split("href=\"");
//        for (int i = 0; i < tempr.length; i++) {
//            //if (tempr[i].indexOf(".html")!=-1 && tempr[i].indexOf("发布于")!=-1)
//            System.out.println(tempr[i]);
//        }
        LinkedList<String> linkedList = new LinkedList<String>();
        String tempr [] = sb.toString().split("<img alt");
        for (int i = 1; i < tempr.length; i++) {
            //if (tempr[i].indexOf(".html")!=-1 && tempr[i].indexOf("发布于")!=-1)
            tempr[i] = tempr[i].replaceFirst("=\"","");
            String [] tt = tempr[i].split("\"");
            String name = tt[0];
            linkedList.add(tt[2]);
            System.out.println(tempr[i]);
        }

        BufferedWriter bw  = new BufferedWriter(new FileWriter(new File("E://Temp/zhaifuli.txt")));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
