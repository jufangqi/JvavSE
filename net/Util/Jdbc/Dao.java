package net.Util.Jdbc;

import java.sql.ResultSet;

/**
 * Created by 存 on 2016/6/20.
 */
public abstract class Dao extends DBUTil implements Runnable {

    abstract public void doSomeThing();

    @Override
    public void run() {
        getcon();
        long start = System.currentTimeMillis();
        doSomeThing();
        start = System.currentTimeMillis()-start;
        setcon();
        System.out.println(start/1000+"秒");
    }

    public void select() {
        String sql = "select t.sname,e.degree,c.cname from student t,score e,course c where e.sno = t.sno and c.cno=e.cno and e.sno=?";
        ResultSet rs = executeQuery(sql,108);
        try {
            while (rs.next()) {
                System.out.println(Thread.currentThread().getName()+"执行 "+rs.getString(1)+"--"+
                        rs.getString(2)+"分--"+rs.getString(3));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public void insert(String t1,String t2) {
        String sql = "insert into javatest values (seq_javatest.nextval,?,?)";
        executeUpdate(sql,t1,t2);
    }
    public void delete() {
        String sql = "delete from student where sno = ?";
        executeUpdate(sql,110);
    }
    public void update() {
        String sql = "update student set sname=? where sno =?";
        executeUpdate(sql,"ddd",110);
    }
}

