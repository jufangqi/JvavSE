package net.Design.FlyWeight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * Created by 存 on 2016/6/11.
 */
public class ConnectionPool {

    private Vector<Connection> pool;

    /*公有属性*/
    private String url = "";
    private String username="";
    private String password = "";
    private String driverClassName = "";
    private int poolSize = 100;
    private static Connection instance = null;
    Connection connection = null;

    /*构造方法初始化一些工作*/
    private ConnectionPool(){
        pool = new Vector<Connection>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverClassName);
                connection = DriverManager.getConnection(url,username,password);
                pool.add(connection);
            } catch (Exception e) {}
        }
    }

    /*返回连接到连接池*/
    public synchronized void release(){
        pool.add(connection);
    }

    /*返回连接池中的数据连接*/
    public synchronized Connection getConnection(){
        if(pool.size()>0){
            Connection connection_temp = pool.get(0);
            pool.remove(connection_temp);
            return connection_temp;
        }else {
            return null;
        }
    }
}
