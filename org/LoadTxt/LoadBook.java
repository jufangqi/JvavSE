package org.LoadTxt;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by 存 on 2016/5/12.
 */
public class LoadBook {
    /**
     * LoadBook lb = new LoadBook("F://Book/");
     */

    private String MainPath ;
    private static String [] type = {"玄幻魔法","武侠修真","纯爱耽美","都市言情","职场校园,","穿越重生",
            "历史军事","网络动漫","恐怖灵异","科幻小说","美文名著"};

    public LoadBook(String path) throws Exception {
        this.MainPath = path;
         Getpath(1,1);
    }

    public void Getpath(int it,int id) throws Exception {
        String urlpath = "http://www.quanshu.net/list/"+it+"_"+id+".html";
        URL url = new URL(urlpath);
        System.out.println(urlpath);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("GBK")));
        String reader = "";
        String temp = "";
        while ((temp = br.readLine())!=null){
            reader +=temp;
        }
        br.close();
        String [] re = reader.split("<li>");
        for (int i = 20; i < re.length-15; i++) {
            String pa = re[i].split("href=\"")[1];
            pa = pa.split("\" class=\"l")[0];
            pa = pa.split("_")[1];
            pa = pa.split("\\.")[0];
            setget(new Integer(pa),type[it-1]);
        }
    }

    public void setget(int path,String type) throws Exception {
        int path1 = path/1000;
        URL url1 = new URL("http://www.quanshu.net/book/"+path1+"/"+path+"/");
        ArrayList<Book> list  = getnovel(url1);
        URL url ;
        File file = new File(MainPath+type+"/"+list.get(0).name+".txt");
        if(!file.isFile()){
            for (Book book : list){
                url = new URL("http://www.quanshu.net/book/"+path1+"/"+path+"/"+book.type+".html");
                getbook(url,book,type);
            }
            Shu s = new Shu(MainPath);
            s.Chu("处理下");
            System.out.println(list.get(0).name+"全部存储完毕 存储于"+type);
        }
    }

    public ArrayList<Book> getnovel(URL url) throws Exception {//获取章节信息
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("GBK")));
        String sb = "";
        String temp;
        while ((temp = br.readLine())!=null){
            sb += temp;
        }
        br.close();
        String [] t2 = sb.split("<a");
        ArrayList<Book> list = new ArrayList<Book>();
        for (int i = 22; i < t2.length-2; i++) {
            Book te = new Book();
            t2[i] = t2[i].replace(" href=\"","");
            te.type = t2[i].split(".html")[0];
            String t3 = t2[i].split("\">")[1];
            te.title = t3.split("</a>")[0];
            String t4 = sb.split("<title>")[1];
            t4 = t4.split("</title>")[0];
            te.name = t4.split("_")[0];
            list.add(te);
        }
        return list;
    }

    public void getbook(URL url,Book book,String type) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("GBK")));
        String sb = "",temp;
        while ((temp = br.readLine())!=null){
            sb += temp;
        }
        br.close();
        //内容
        String [] t1 = sb.split("&nbsp;&nbsp;&nbsp;&nbsp;");
        StringBuffer stringer= new StringBuffer();
        for (int i = 2; i < t1.length; i++) {
            t1[i] = t1[i].replace("<br />","");
            if(i == t1.length-1){
                t1[i] = t1[i].split("<script type=")[0];
            }
            stringer.append(t1[i]+"\r\n");
        }

        //存档
        BufferedWriter bw = new BufferedWriter(new FileWriter(MainPath+type+"/"+book.name+".txt",true));
        bw.write(book.title+"\r\n"+stringer+"\r\n");
        bw.flush();
        bw.close();
        System.out.println(book.name+" "+book.title+" 存储完毕"+"  存储于:"+MainPath+type+"/"+book.name+".txt");
    }
}
