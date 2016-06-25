package net.Util.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by 存 on 2016/6/21.
 */
public class ConnectionPool {

    private static Stack<Connection> stack = new Stack<Connection>();

    public ConnectionPool(){
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String name =  "scott";
        String password = "tiger";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            for (int i = 0; i < 5; i++) {
                stack.add(DriverManager.getConnection(url,name,password));
            }
            System.out.println("加载完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMc(Connection connection){
        stack.push(connection);
    }

    public static Connection getMc(){
        int i =0;
        long start = System.currentTimeMillis();
        long end ;
        while (stack.empty()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"获取连接中...");
            if((end-start)/1000>20){
                System.out.println("连接超时");
                return null;
            }
        }
        return stack.pop();
    }
}
