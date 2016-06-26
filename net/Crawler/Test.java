package net.Crawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 存 on 2016/6/2.
 */
public class Test extends Loader{

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.disPatch();
    }

    public void disPatch() throws Exception {
        analyMain(entrance);//获取内容
        for (int i = 0; i < apath.size(); i++) {
            analyType(apath.get(i));
            for (int j = 0; j < bpath.size(); j++) {
                analyPng(bpath.get(j));
                loadPng(entrance+bpath,apath.get(0),mm);
            }
        }
    }

    @Override
    public void analyMain(String paht) throws IOException {
        String sb = getContent(paht);
        ArrayList<String> arrayList = new ArrayList<String>();
        String tempr []= sb.split("<li");
        for (int i = 5; i < 11; i++) {
            tempr[i] = tempr[i].substring(tempr[i].indexOf("href='"));
            tempr[i] = tempr[i].substring(0,tempr[i].indexOf("</a"));
            String t1 = tempr[i].split("'")[1];
            t1 = t1.substring(1,t1.length()-1);
            arrayList.add(t1);
            //创建文件夹 SHOUCI YUNXING
//            File file = new File(MAILPATH+t1);
//            file.mkdir();
        }
        setApath(arrayList);
    }

    @Override
    public void analyType(String type) throws IOException {
        String sb = getContent(entrance+type+"/");
        ArrayList<String> arrayList = new ArrayList<>();
        String tempr [] = sb.toString().split("href=\"");
        for (int i = 0; i < tempr.length; i++) {
            if (tempr[i].indexOf(".html")!=-1 && tempr[i].indexOf("发布于")!=-1)
                arrayList.add((tempr[i].split("\"")[0]).substring(1));
        }
        setBpath(arrayList);
    }

    @Override
    public void analyPng(String path) throws IOException {
        String sb = getContent(entrance+path);
        ArrayList<String> arrayList = new ArrayList<String>();
        String tempr [] = sb.toString().split("<img alt");
        for (int i = 1; i < tempr.length; i++) {
            tempr[i] = tempr[i].replaceFirst("=\"","");
            String [] tt = tempr[i].split("\"");
            mm = tt[0];
            arrayList.add(tt[2]);
        }
        setCpath(arrayList);
    }

    @Override   //对输入流进行封装 可能用到Post...
    public BufferedInputStream setBis(URL url) {
        BufferedInputStream br = null;
        try {
            br = new BufferedInputStream((url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    @Override
    public BufferedInputStream setPngBis(URL url,String referer) {
        BufferedInputStream br = null;
        try {
            HttpURLConnection uc=(HttpURLConnection) url.openConnection();
            uc.setRequestProperty("referer",referer);
            br = new BufferedInputStream((uc.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }
}

