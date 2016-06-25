package org.LoadTxt;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 存 on 2016/5/11.
 */
public class TestSocket {


    public static void main(String[] args) throws IOException {
//        ServerSocket ss = new ServerSocket(6666);
//        System.out.println("等待连接。。。");
//        Socket sc = ss.accept();
//        System.out.println("连接成功。。。");
//
//        //接收客户端传过来的数据
//        sc.getInputStream();

        //客户端
        Socket socket = new Socket("192.168.43.29",6666);
        OutputStream oos  =  socket.getOutputStream();
        String str = "aaaaa";
        oos.write(str.getBytes());
        oos.flush();
        oos.close();
    }
}
