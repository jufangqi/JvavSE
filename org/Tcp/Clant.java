package org.Tcp;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by cun on 2016/5/19.
 */
public class Clant {

    private Socket socket = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;

    Person person = null;
    String emassage;

    public static void main(String[] args) {
        Date date = new Date();
        Clant c = new Clant("");

       Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        c.Send(str);
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

    public void Send(String ee){
        try {
            bw.write(ee);
            bw.newLine();
            bw.flush();
            System.out.println("发送: "+ee);
        } catch (IOException e) {
            emassage = "发送失败";
        }
    }

    public Clant(String ip){
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
