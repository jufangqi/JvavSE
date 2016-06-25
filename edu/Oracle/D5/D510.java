package edu.Oracle.D5;
import java.io.*;
import java.util.ArrayList;
/**
 * Created by 存 on 2016/5/10.
 */

/**
 * DataInputStream 数据输入流	保存数据，还原出真实类型的数据
 * ObjectInputStream 对象流	将对象保存
 * BufferedReader 字符缓冲流  一次能读取一行
 * InputStreamReader(FileInputStream , charset)  转化流
 */
public class D510 {
    public static void main(String[] args) throws Exception {
        D510 d =new D510();
        //d.BufferedReaderTest();
        d.ObjectInputStreamTest();
    }
    public void InputStreamReaderTest() throws FileNotFoundException {
        //转化流 打开为字节流
        FileInputStream fis = new FileInputStream("F://Temp/aaa.txt");
        //isr为字符流
       // InputStreamReader isr = new InputStreamReader(fis);
        Reader isr = new InputStreamReader(fis);
    }

    /**
     * 对象流
     * 利用while循环，catch机制。如果读出报错，那么久将while循环停止
     */
    public void ObjectInputStreamTest(){
         ObjectInputStream  ois = null;
         ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream (new FileInputStream ("F://Temp/Object.txt"));
//            oos = new ObjectOutputStream(new FileOutputStream("F://Temp/Object.txt"));
//            oos.writeObject(new Students("zjn","hzz",13,'女',"米饭"));
//            oos.writeObject(new Students("dcc","hrb",12,'男',"饺子"));
//            oos.flush();
        } catch (Exception e) {}
        boolean live = true;
        ArrayList<Students> list = new ArrayList<Students>();
        while(live){
            try {
                list.add((Students)(ois.readObject()));
            } catch (Exception e) {
                live = false;
            }
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Students s:list) {
            System.out.println(s);
        }
    }

    public void BufferedReaderTest() throws IOException {
        //FileReader 继承自Reader  多态
        Reader re = new FileReader("F://Temp/aaa.txt");
        //缓冲流，特点一次可以读一行
        BufferedReader br = new BufferedReader(re);
       String temp = "";
        String str ="";
        //临界条件 当br.readLine()不为空
        while((temp=br.readLine())!=null){
            str +=temp;
        }
        System.out.println(str);
    }
}
/**
 * 测试类
 *  实现Serializable接口
 *  可序列化
 */
class Students implements Serializable{
    String name;
    String address;
    int age;
    char sex;
    static  String food ;

    public String toString(){
        return "name:"+this.name+"      address:"+address+"     age:"+age+"     sex:"+sex+"     food:"+food;
    }

    public Students(String name, String address, int age, char sex, String food) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.food = food;
    }
}