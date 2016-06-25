package edu.Oracle.D5;

import java.util.*;

/**
 * Created by 存 on 2016/5/2.
 */
public class D502 {

    public static void main(String[] args) {
        Person s1 = new Person("A",12);
        Person s2 = new Person("B",13);
        Person s3 = new Person("C",14);
        Person s4 = new Person("C",14);
        HashSet hs = new HashSet();
        hs.add(s2);
        hs.add(s1);
        hs.add(s3);
        hs.add(s4);
        hs.add(s4);
        hs.add(new Person("C",14));
        System.out.println(s3.hashCode()+" "+s4.hashCode());
        Iterator it = hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
class Person implements Comparable{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名："+this.name+" 年龄："+this.age;
    }

//    @Override
//    public int hashCode(){
//        System.out.println("            "+super.hashCode());
//        return super.hashCode();
//    }
//    @Override
//    public boolean equals(Object o){
//        System.out.println("zoulrrr");
//        Person pp = (Person)o;
//        if(pp.name.equals(this.name) && pp.age==this.age)
//            return true;
//        return false;
//    }

    @Override
    public int compareTo(Object o) {
        Person s = (Person)o;
        String s1 = s.toString();
        String s2 = this.toString();
        return -s1.compareTo(s2);
    }
}
