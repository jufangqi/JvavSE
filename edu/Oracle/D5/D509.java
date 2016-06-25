package edu.Oracle.D5;

import java.io.*;

/**
 * Created by 存 on 2016/5/9.
 */

/**
 * FileReader FileWriter的使用
 * 文件的切割与合并
 */
public class D509 {

    static D509 d = new D509();

    public static void main(String[] args) throws Exception {
        String name1 = "未闻花名.mp3";
        String name2 = "密保卡.jpg";
        int cu = 3;
        //d.Chu(name1,cu);
       //d.Jie("aa.txt");
        //d.FileTestReader();
        d.FileTestWriter();
    }

    public void FileTestWriter() throws IOException {
        FileWriter fw = new FileWriter("F://Temp/aaa.txt");
        char [] a = FileTestReader().toCharArray();
        fw.write(a);
        fw.flush();
    }

    public String FileTestReader() throws IOException {
        FileReader fr = new FileReader("F://Temp/a.txt");
        char [] b = new char[1024];
        int length;
        String str ="";
        while ((length=fr.read(b))!=-1){
           str += new String(b,0,length);
        }
        return str;
    }

    //调用文件加密解密算法
    public void Jie(String name) throws IOException {
        FileInputStream fis1 = new FileInputStream("F://Temp/"+name);
        FileOutputStream fos1 = new FileOutputStream("F://Temp/加密"+name);
        Jia(fis1,fos1);

        FileInputStream fis = new FileInputStream("F://Temp/加密"+name);
        FileOutputStream fos = new FileOutputStream("F://Temp/解密"+name);
        Jia(fis,fos);
    }

    /**
     * 文件处理
     * 加密解密
     * @throws IOException
     */
    public void Jia(FileInputStream fis,FileOutputStream fos) throws IOException {
        byte temp [] = new byte[128];
        int length;
        while((length = fis.read(temp))!=-1){
            for (int i = 0; i < length; i++) {
                temp[i] = (byte) (temp[i]^(i*7));
            }
            fos.write(temp,0,length);
            fos.flush();
        }
    }
    //处理
    public void Chu(String names,int cu) throws Exception {
        String [] str = names.split("\\.");
        String name = str[0];
        String style = str[1];
        d.cut(name,style,cu);
        d.add(name,style,cu);
    }
    //切
    public void cut(String name,String style,int cu) throws Exception {
        File infile = new File("F://Temp/"+name+"."+style);
        FileInputStream fis = new FileInputStream(infile);
        FileOutputStream f[] =new  FileOutputStream[cu];
        for (int i = 0; i < f.length; i++) {
            f[i] =  new FileOutputStream(new File("F://Temp/"+name+(i+1)+"."+style));
        }
        byte [] a = new byte[1024];
        int dex = (int)(infile.length()/(a.length*f.length));
        int index = 0,i=0,length;
        while((length=fis.read(a))!=-1){
            f[i].write(a,0,length);
            if(index<dex+1){
                index++;
            }else{
                f[i].flush();
                index =0;
                i++;
            }
        }

        fis.close();
        for (int j = 0; j < cu; j++) {
            f[j].close();
        }
    }
    //合并
    public void add(String name,String style,int cu) throws Exception {
        File infile = new File("F://Temp/"+name+"新."+style);
        FileOutputStream fos = new FileOutputStream(infile);
        FileInputStream f []= new FileInputStream[cu];
        for (int i = 0; i < cu; i++) {
           f[i] =  new FileInputStream(new File("F://Temp/"+name+(i+1)+"."+style));
        }
        int index =0,length;
        byte a [] = new byte[1024];
        for (int i = 0; i < 3; i++) {
            while ((length=f[i].read(a))!=-1){
                fos.write(a,0,length);
            }
        }
        fos.close();
        for (int j = 0; j < cu; j++) {
            f[j].close();
        }
    }
}
