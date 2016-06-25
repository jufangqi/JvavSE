package edu.Oracle.D5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 存 on 2016/5/18.
 */
public class D516 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",6768);
        Writer w = new OutputStreamWriter(socket.getOutputStream());
        Reader r = new InputStreamReader(socket.getInputStream());
        Scanner sc = new Scanner(System.in);
        while (true){
            w.write(sc.nextLine());
            w.flush();
            char [] temp = new char[1024];
            int length = r.read(temp) ;
            for (int i = 0; i < length; i++) {
                System.out.print(temp[i]);
            }
            System.out.println();
        }
    }
}
