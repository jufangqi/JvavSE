package org.LoadTxt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 存 on 2016/5/12.
 */
public class MySoctetServet {
    public static void main(String[] args) throws IOException {
        MySoctetServet mss = new MySoctetServet();
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("服务器等待连接中");

        while(true){
            Socket user  = ss.accept();
                InputStream is = user.getInputStream();
                mss.Connection(is);
        }
    }

    public void Connection(InputStream is) throws IOException {
        int temp ;
        while((temp = is.read())!=-1){
            System.out.print((char)temp);
        }
        System.out.println();
    }
}
