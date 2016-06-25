package org.Tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by �� on 2016/5/18.
 */
public class Server extends Thread{

    ServerSocket ss = null;
    int index = 0;
    ArrayList<Socket> list = new ArrayList<Socket>();

    public Server() {
        try {
            ss = new ServerSocket(6768);
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Ip:" + ip);
        } catch (IOException e) {}
    }

    public static void main(String[] args) {
        Server s= new Server();
        s.start();
    }
    @Override
    public void run() {
        while (true) {
            try {
                Socket s = ss.accept();
                list.add(s);
                index++;
                System.out.println(list.get(index-1).getInetAddress() + "连入");
                if(index==2){
                    System.out.println("开房");
                    new Camber(list.get(index-2), list.get(index-1));
                }
            } catch (IOException e) {}

        }
    }
}
class Camber {//
    Socket s1 = null;
    Socket s2 = null;
    BufferedReader br[] = new BufferedReader[2];
    BufferedWriter bw[] = new BufferedWriter[2];
    boolean live = true;
    int b_temp =0;
    String message=null;

    public void Send(int i){
        try {
            do{
                bw[i].write(message);
            }while (message!=null);
            bw[i].newLine();
            bw[i].flush();
        } catch (IOException e) {}
    }

    public String Get(int i){
        String str =null;
        try {
            do{
                str =  br[i].readLine();
            }while (str!=null);
        } catch (IOException e) {}
        return str;
    }

    public Camber(Socket s1,Socket s2){
        this.s1 = s1;
        this.s2 = s2;
        try {
            bw[0] = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
            br[0] = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            bw[1] = new BufferedWriter(new OutputStreamWriter(s2.getOutputStream()));
            br[1] = new BufferedReader(new InputStreamReader(s2.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("开房成功");
        try {
            bw[0].write("t@t");bw[0].newLine();bw[0].flush();
            bw[1].write("t@f");bw[1].newLine();bw[1].flush();
        } catch (IOException e) {}
        Begin();
    }
    public void Begin() {
        while (live){
            try{
                message = Get(b_temp);
                System.out.println("发送消息"+message+"给另一个"+b_temp);
                Send(b_temp==1?0:1);
                b_temp = b_temp==1 ? 0:1;
            }catch (Exception e){
                System.out.println("报错");
                live = false;
                try {
                    for (int i = 0; i < 2; i++) {
                        br[i].close();bw[i].close();
                    }
                } catch (Exception e1) {}finally {
                    System.out.println(s1.getInetAddress()+"and"+s2.getInetAddress()+"关闭");
                }
            }
        }
    }
}
