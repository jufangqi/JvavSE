package org.NewWorld;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 存 on 2016/6/2.
 */
public class LoadMovie {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://d1wmwgoqylmvrg.doyousb.us/vod/9605.html");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer sb = new StringBuffer();
        String temp ;
        while ((temp=br.readLine())!=null){
            sb.append(temp);
        }
        String sp = sb.toString().split("ed2k")[2];
        sp = sp.split("\"")[0];
        sp = "ed2k"+sp;

        String type = sp.replace("|",".");
        String name = type.split("\\.")[2];
        type = type.split("\\.")[3];

        System.out.println(sp);
        System.out.println(name);
        System.out.println(type);
    }
}
