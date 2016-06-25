package org.LoadTxt;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by 存 on 2016/5/13.
 */
public class Shu {
    /**
     * 对书进行管理
     * $$ 为首
     * s.addBook(new OBCK("书名","5 13 2016",0,true,"类型"));
     *  s.remove("书名");
     * ArrayList<OBCK> list = s.search("书名");
     * ArrayList<OBCK> list = s.search("书名","类型");
     */

    private static String MainPath;

    public void Chu(String type) throws IOException {//出错之后运行 type 随便来
        File file = new File(MainPath);
        File [] files = file.listFiles();
        for (File f:files) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(MainPath+f.getName()+"/$$"));
            String ParentName = f.getName();
            File [] Temp_File = f.listFiles();
            for (int i = 0; i < Temp_File.length; i++) {
                String Temp_File_name = (Temp_File[i].getName()).replace(".txt","");
                OBCK ok = new OBCK(Temp_File_name,"5 13 2016",0,true,ParentName);
                bw.write(ok.toString()+"\r\n");
                bw.flush();
            }
            bw.close();
        }
        System.out.println("目录跟新完毕");
    }

    public void remove(String name) throws Exception {
        ArrayList<OBCK> list ;
        File file = new File(MainPath);
        File [] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            list = getOBCK(files[i].getName());
            int index = -1;
            for (int j=0;j<list.size();j++) {
                if(name.equals(list.get(j).getName())){//找
                    list.remove(j);
                    File dltemp = new File(files[i].getPath()+"\\"+name+".txt");
                    dltemp.delete();
                    index =i;
                }
            }
            if(index != -1){
                String str = MainPath+files[i].getName()+"/$$";
                BufferedWriter bw = new BufferedWriter(new FileWriter(str));
                for (OBCK ook:list) {
                    bw.write(ook.toString());
                }
                bw.flush();
                bw.close();
            }
        }
    }

    public void addBook(OBCK ok) throws Exception {
        File file = new File(MainPath);
        File [] files = file.listFiles();
        ArrayList<OBCK> list;
        list = getOBCK(ok.getType());
            for (int i=0;i<list.size();i++) {
                if(list.get(i).getName().equals(ok.getName())){
                    list.remove(i);
                }
            }
        list.add(ok);
        FileWriter fw = new FileWriter(MainPath+ ok.getType() + "/$$");
            for (OBCK obck:list) {
                fw.write(obck.toString()+"\r\n");
                fw.flush();
            }
        fw.close();
    }

    public ArrayList<OBCK> search(String name) throws Exception {
        File file = new File(MainPath);
        File [] files = file.listFiles();
        ArrayList<OBCK> list =new ArrayList<OBCK>();
        for (File f:files) {
            list.addAll(getOBCK(f.getName()));
        }
        int index =0;
        while (index<list.size()){
            if(!name.equals(list.get(index).getName())){
               list.remove(index);
               index--;
            }
            index++;
        }
        return list;
    }

    public ArrayList<OBCK> search(String name,String type) throws Exception {
        File file = new File(MainPath);
        String newfile =null;
        ArrayList<OBCK> list = new ArrayList<OBCK>();
        for (File f:file.listFiles()) {//获取type路径
            if(f.getName().equals(type)){
                newfile = f.getName();
            }
        }
        if(newfile==null){
           return list;
        }
        else if(!name.equals("")){
            list = getOBCK(newfile);
            for (int i=0;i<list.size();i++) {
                if(!list.get(i).getName().equals(name)){
                    list.remove(i--);
                }
            }
        }
        else{
            list = getOBCK(newfile);
        }
        return list;
    }

    private ArrayList<OBCK> getOBCK(String path) throws Exception {
        ArrayList<OBCK> list = new ArrayList<OBCK>();
        String tx_1 = MainPath+path+"/$$";
        BufferedReader bw = new BufferedReader(new FileReader(new File(tx_1)));
        String temp ;
        while ((temp =bw.readLine())!=null){
            String str []  =temp.split("&");
            for (int i=0;i<str.length;i++) {
                str[i] = str[i].split("=")[1];
            }
            list.add(new OBCK(str[0],str[1],new Integer(str[2]),str[3].equals("true")?true:false,str[4]));
        }
        return list;
    }

    public Shu(String MainPath) {
        this.MainPath = MainPath;
    }

}
