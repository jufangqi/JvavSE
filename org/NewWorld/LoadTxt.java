package org.NewWorld;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 存 on 2016/5/14.
 */
public class LoadTxt {

    static String [] type = {"mingxing","jiqing","jiating","wuxia"};
    String MainPath = "http://d1wmwgoqylmvrg.doyousb.us";

    public static void main(String[] args) throws Exception {
        LoadTxt lt = new LoadTxt();
        StringBuilder sb ;
        for (int i = 2; i < type.length; i++) {
            for (int j = 2; j < 10; j++) {
                sb = lt.GetMain(i,j);
                ArrayList<PathBean> list= lt.GetPath(sb);
                lt.GetTxt(list);
            }
        }
    }

    public void GetTxt(ArrayList<PathBean> list) throws Exception {
        for (PathBean pb : list) {
            int nextindex=0;
            int num = 1;
            while (nextindex != -1){
                String type = pb.path.split("/")[3];
                URL url = new URL(MainPath+pb.path);
                if(num!=1){
                    String temp_pa = pb.path.split("\\.")[0];
                    url = new URL(MainPath+temp_pa+"_"+num+".html");
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuffer sb = new StringBuffer();
                String temp_br ;
                while ((temp_br = br.readLine())!=null){
                    sb.append(temp_br);
                }
                String t1 =  sb.toString().split("<div class=\"artbody imgbody\">")[1];
                String te []= t1.split("<div id=\"pages\">");
                String txt = te[0].replace("<p>","").replace("</p>","").replace("&quot;","").replace("<br />","").trim();
                nextindex = te[1].indexOf("下一页");
                String text_path = "E://Temp/nov/"+type+"/"+pb.name.replace("?","")+".txt";
                System.out.println(text_path);
                File file = new File(text_path);
                if(num++ == 1){
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
                bw.write(txt);
                bw.flush();
                bw.close();
                br.close();
            }
            System.out.println(pb.name+" 存储完毕");
        }
    }//对每一页的每一个文档下载

    public ArrayList<PathBean> GetPath(StringBuilder sb){
        ArrayList<PathBean> list = new ArrayList<PathBean>();
        String temp [] = sb.toString().split("<li");
        for (String temp_o:temp) {
            if(temp_o.indexOf("<span>")!= -1){
                PathBean pb = new PathBean();
                pb.name = temp_o.substring(temp_o.indexOf("_blank\">")+8,temp_o.indexOf("</a> <span"));
                pb.path = temp_o.substring(temp_o.indexOf("href=\"")+6,temp_o.indexOf("\" target="));
                list.add(pb);
            }
        }
        return list;
    }//对一页进行处理

    public StringBuilder GetMain(int typeindex,int nameindex) throws Exception {
        URL url = new URL(MainPath+"/html/article/"+type[typeindex]+"/index_"+nameindex+".html");
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String temp_br ;
        while ((temp_br = br.readLine())!=null){
            sb.append(temp_br);
        }
        return sb;
    }
}
