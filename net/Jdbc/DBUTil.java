package net.Jdbc;

import java.sql.*;

/**
 * Created by 存 on 2016/6/19.
 */
public class DBUTil {

    private Connection connection = null;
    private PreparedStatement ps = null ;
    private ResultSet resultSet = null;

    //zen shan gai
    public int executeUpdate(String sql,Object ... objects) {
        int result = 0;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //cha
    public ResultSet executeQuery(String sql,Object ... objects) {
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            resultSet = ps.executeQuery();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void close(){
        try {
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("关闭失败");
        }
    }

    public void setcon(){
        ConnectionPool.setMc(connection);
    }
    public void getcon(){
        connection = ConnectionPool.getMc();
    }
}
