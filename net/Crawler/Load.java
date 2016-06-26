package net.Crawler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

/**
 * Created by 存 on 2016/6/24.
 */
public interface Load {

    /*
    创建一个接口Load，里面写一些要用到的方法
    1.public String getContent(String path);//获取网址中的内容
    2.public void loadPng(String referer,String type,String mm);//获取网址中的图片
    3.public void convection(BufferedOutputStream bos, BufferedInputStream bis);//输入口和输出流之间的对
    4.public void write(String sb,String path);
     */
    //

    public String getContent(String path);//获取网址中的内容

    public void loadPng(String referer,String type,String mm);//获取网址中的图片

    public void convection(BufferedOutputStream bos, BufferedInputStream bis);

    public void write(String sb,String path);
}
