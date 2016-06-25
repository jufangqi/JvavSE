package org.LoadTxt;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 存 on 2016/5/12.
 */
public class MySocket {
    public static void main(String[] args) throws IOException {
        MySocket ms = new MySocket();
        Socket s = new Socket("127.0.0.1",6666);
        System.out.println("连接到服务器");
        while(true){
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(s.getOutputStream()));
            ms.Connect(bw);
        }
    }
    private void Connect(BufferedWriter bw) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        bw.write(str);
        bw.flush();
    }
}
