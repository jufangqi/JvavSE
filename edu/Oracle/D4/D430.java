package edu.Oracle.D4;

import java.util.*;

/**
 * Created by 存 on 2016/4/29.
 */
public class D430{

    /**
     * 去除相同的Object
     * @param list
     * @return
     */
    public ArrayList noRepeat(ArrayList list){
        ArrayList temp =new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if(temp.indexOf(list.get(i))==-1){
                temp.add(list.get(i));
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);list.add(2);list.add(2);list.add(3);
        D430 ds = new D430();
        ArrayList l = ds.noRepeat(list);
        System.out.println(l.toString());
        System.out.println("****************");
        Student a = new Student("a",2);Student b = new Student("b",1);Student c = new Student("c",3);
        Student d = new Student("d",5);Student e = new Student("e",4);Student f = new Student("f",6);
        ArrayList<Student> lisst = new ArrayList<Student>();
        lisst.add(a);lisst.add(b);lisst.add(c);lisst.add(d);lisst.add(e);lisst.add(f);
        Collections.sort(lisst);//对其进行排序
        for (Student s : lisst) {
            System.out.print(s.age+":"+s.name+"     ");
        }
    }
}
class  sss implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student s =(Student)o1;
        Student s1= (Student)o2;
        return s1.age-s.age;
    }
}
class Student implements Comparable{
    //继承Comparable 实现比较规则
     String name;
     int age;
    static int a = 1;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * 返回0 两对象相等
     * 返回正数 我比你大
     */
    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
       return this.age-s.age;
    }
}
