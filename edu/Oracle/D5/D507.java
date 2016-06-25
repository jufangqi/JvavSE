package edu.Oracle.D5;

/**
 * Created by 存 on 2016/5/7.
 */

import java.io.*;
import java.util.Scanner;

/**
 * 读取文件中的内容
 * FileInputStream
 */
public class D507 {

    public static void main(String[] args)  throws Exception {
        D507 d = new D507();
        File file =new File("F://Temp/a.txt");
        //d.ReadIo2(file);
      //  d.ReadIo(file);
        File outfile = new File("F://Temp/aa.txt");
        d.WriteIo(file,outfile);
       // d.www(outfile);
    }
    public void www(File file) throws IOException {
        Scanner sc = new Scanner(System.in);
        byte temp [] = sc.next().getBytes();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(temp);
        fos.flush();
        fos.close();
    }

    /**
     * 读多少写多少
     * @param file
     * @param outfile
     * @throws Exception
     */
    public void WriteIo(File file,File outfile) throws Exception {
        FileOutputStream fos = new FileOutputStream(outfile);
        FileInputStream fis  = new FileInputStream(file);
        int length;
        byte [] a = new byte[1024];
        while((length=fis.read(a))!=-1){
                fos.write(a,0,length);
        }
        fos.flush();
        fis.close();
        fos.close();
    }
    //读取，一次读1024个字节
    public void ReadIo(File file) throws Exception {
        long start = System.currentTimeMillis();
        InputStream fis = new FileInputStream(file);
        StringBuffer str=new StringBuffer();
        byte [] temp = new byte[128];
        int length;
        while((length = fis.read(temp))!=-1){
            for (int i =0 ;i<length;i++) {
                str.append((char)temp[i]);
            }
        }
        System.out.println(str.toString());
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("1024个字节读取时间是："+(end-start));
    }
    //读取，一次读1个字节
    public void ReadIo2(File file) throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(file);
        StringBuffer str=new StringBuffer();
        int a ;
        while((a=fis.read())!=-1){
           str.append((char)a);
        }
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("单个字节读取时间是："+(end-start));
    }
}
