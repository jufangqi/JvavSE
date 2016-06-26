package net.Crawler;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by 存 on 2016/6/22.
 */

public abstract class Loader{

    String MAILPATH = "E://Temp/15hn/";//存放文件位置
    String unique = "gb2312";//网站编码格式
    String entrance = "http://15hn.net/";

    ArrayList<String> apath;//存放所有类型的网址
    ArrayList<String> bpath;//存放每种类型下的所有网址
    ArrayList<String> cpath;//存放一个网址下所有图片的地址
    String mm;//存放图片包的名字

    public void setApath(ArrayList<String> apath) {
        this.apath = apath;
    }

    public void setBpath(ArrayList<String> bpath) {
        this.bpath = bpath;
    }

    public void setCpath(ArrayList<String> cpath) {
        this.cpath = cpath;
    }

    //对主窗口进行正则 提取到类型
    abstract public void analyMain(String sb) throws IOException;

    //对type窗口进行正则 得到每种类型的所有网址
    abstract public void analyType(String sb) throws IOException;

    //提取照片连接
    abstract public void analyPng(String sb) throws IOException;

    //对输入流进行封装
    abstract public BufferedInputStream setBis(URL url);

    abstract public BufferedInputStream setPngBis(URL url,String referer);

    //查找每个网址中的链接
    public String getContent(String path) throws IOException {
        URL url = new URL(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(setBis(url), Charset.forName(unique)));
        String tmep;
        StringBuffer sb = new StringBuffer();
        while ((tmep=br.readLine())!=null){
            sb.append(tmep);
        }
        write(sb.toString(),MAILPATH+"test.txt");
        return sb.toString();
    }

    //load 图片
    public void loadPng(String referer,String type,String mm) throws Exception {
        for (String path:cpath) {
            String name = path.substring(path.lastIndexOf("/"),path.length());
            File file = new File(MAILPATH+type+"/"+mm+"/"+name);
            file.getParentFile().mkdirs();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            BufferedInputStream bis = new BufferedInputStream(new URL(path).openStream());
//                    setPngBis(new URL(path),referer);

            convection(bos,bis);
        }
    }

    //输入流 输出流 对流
    private void convection(BufferedOutputStream bos,BufferedInputStream bis) throws IOException {
        byte [] temp = new byte[1024];
        int length;
        while ((length=bis.read(temp))!=-1){
            bos.write(temp,0,length);
        }
        bos.flush();
        bis.close();
        bos.close();
    }

    //对输出流流进行fengzhuang
    private void write(String sb,String path) throws IOException {
        BufferedOutputStream bos  = new BufferedOutputStream(new FileOutputStream(new File(path)));
        byte [] temp = sb.getBytes();
        bos.write(temp);
        bos.flush();
        bos.close();
    }
}