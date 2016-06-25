package edu.Oracle.D5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 存 on 2016/5/18.
 */
public class D517 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(6768);
        Socket ins = serverSocket.accept();
        System.out.println(ins.getInetAddress());
        //服务端接收客户端发来的信息
        Reader r = new InputStreamReader(ins.getInputStream());
        Writer w = new OutputStreamWriter(ins.getOutputStream());
        while (true){
            char [] temp = new char[1024];
            int length = r.read(temp) ;
            for (int i = 0; i < length; i++) {
                System.out.print(temp[i]);
            }
            System.out.println();
            w.write("我很烦 别给我发");
            w.flush();
        }
    }
}
