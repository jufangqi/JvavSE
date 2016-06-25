package net.Util.Xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

public class SecondDemo {
	public static void main(String[] args){

	}
	public static void set() throws Exception{
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("deicer","mysql.jdbc.driver.mysqlDriver");
		pro.setProperty("url", "jdbc:mysql://localhost:/3308:oc");
		pro.setProperty("uesrname", "ding");
		pro.setProperty("password", "tiger");

		//使用相对路径存储到工程
		pro.store(new FileOutputStream(new File("src/constant.properties")), "ding");

		pro.store(new FileOutputStream(new File("src/constant.xml")), "ding");
	}
	public static void get() throws Exception{
		Properties pro  = new Properties();

		//读取
		pro.load(new FileReader("src/constant.xml"));
		System.out.println(pro.getProperty("url","notfound"));
	}
}
