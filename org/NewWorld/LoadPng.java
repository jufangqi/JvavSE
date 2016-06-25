package org.NewWorld;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by 存 on 2016/6/2.
 */
public class LoadPng {

    String webpath = "E://Temp";
    public static void main(String[] args) throws Exception {

        LoadPng lp = new LoadPng();
        LinkedList<PathBean> list = lp.MainPath("");//得到主目录列表
        for (int i = 2; i < 10; i++) {
            list.addAll(lp.MainPath("_"+i));
        }
        for (int i = 0; i < list.size(); i++) {
            lp.Pngload(list.get(i));//得到图片列表,下载所有图片
        }
    }

    public void EachPng(String path,String name,int index) throws Exception {
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(new File(webpath+"/web/"+name+"/"+index+".jpg")));
        BufferedInputStream  br = new BufferedInputStream(new URL(path).openStream());
        byte [] temp = new byte[1024];
        int length;
        while ((length=br.read(temp))!=-1){
            bw.write(temp,0,length);
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public void Pngload(PathBean pb) throws Exception {//jiexi 每个网页里的所有图片
        File file = new File(webpath+"/web/"+pb.name);
        file.mkdirs();
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(pb.path).openStream()));
        StringBuffer sb = new StringBuffer();
        String te ;
        while ((te=br.readLine())!=null){sb.append(te);}
        br.close();
        String tt [] = sb.toString().split("<img src=\"");
        for (int i = 1; i < tt.length; i++) {
            String imgpath = tt[i].split("\" alt")[0];
            EachPng(imgpath,pb.name,i);
        }
        System.out.println(pb.name+"存储完毕");
    }

    public LinkedList<PathBean>  MainPath(String indexpath) throws Exception {
        LinkedList<PathBean> list = new LinkedList<PathBean>();
        URL url = new URL("http://d1wmwgoqylmvrg.doyousb.us/html/tupian/toupai/index"+indexpath+".html");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer sb = new StringBuffer();
        String te ;
        while ((te=br.readLine())!=null){
            sb.append(te);
        }
        String string [] = sb.toString().split("<li>");
        for (int i = 1; i < string.length; i++) {
            String name = string[i].split(">")[1].replace("</a","");
            String path = "http://d1wmwgoqylmvrg.doyousb.us"+string[i].split("\"")[1];
            PathBean pb = new PathBean(name,path);
            list.add(pb);
        }
        br.close();
        return list;
    }
}

