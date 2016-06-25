package org.Tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by cun on 2016/5/19.
 */
public class Clant1 {

    private Socket socket = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;

    Person person = null;
    String emassage;

    public static void main(String[] args) {
       Clant1 c =  new Clant1("");
        String s = c.Receive();
        System.out.println(s);
    }

    public String Receive(){
        String gstr = null;
        try {
            gstr = br.readLine();
            System.out.println("接收"+gstr);
        } catch (IOException e) {
            emassage = "接收失败";
        }
        return gstr;
    }

    public void Send(int x,int y){
        try {
            bw.write(x+"+"+y);
            bw.newLine();
            bw.flush();
            System.out.println("发送: "+x+"+"+y);
        } catch (IOException e) {
            emassage = "发送失败";
        }
    }

    public Clant1(String ip){
        String fmassage =null;
        try {
            socket = new Socket("localhost",6768);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            fmassage = br.readLine();
        } catch (IOException e) {
            emassage = "失败";
        }
        person = new Person(
                fmassage.charAt(0)=='t' ? true : false,
                fmassage.charAt(2)=='t' ? true : false);
        System.out.println(person.isStart()+"  "+person.isWalk());
    }

}
