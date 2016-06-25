package edu.Oracle.D4;

/**
 * String类的使用
 * equals的比较
 *  ==判断地址  equals判断字符串里面的值
 * Created by 存 on 2016/4/24.
 */
public class D424 {

    String string ;
    int age ;

    /**
     * 测试String方法
     */
    public static void TestStringMethod(){
        String string = "ab2221234acdefg";
        //indexOf() 方法 (**无论怎么弄都是从头开始的**)
        // 索引第一次出现的位置。后面的参数从第几个开始找,返回值为从头开始的索引。
        // 也可以传入char类型的值
        //split 切割 返回字符串数组
        int index = string.indexOf("a",2);
        String a = "abcdddefg";
        int x = a.lastIndexOf("dd",4);
        System.out.println(x);
        String string1 = string.substring(3);
        String string3 = string.substring(3,6);
        System.out.println(string1+"   "+string3);
    }
    /**
     * 测试String类
     * String 不可变性 如果对字符串进行操作，就等于新new出来一个String
     *  * * private final char value[];
     */
    public static void TestString(){
     //  s存在于常量区
        String s = "a";
     // ss存在于堆  两者地址不同
        String ss=new String("a");
        System.out.println(s==ss);
        System.out.println(s.equals(ss));
    }
    /**
     * 测试equals
     * 此equals为重写之后的方法
     */
    public static void Testequals(){
        D424 d423 = new D424("小王",12);
        D424 d424 = new D424("小王",12);
        System.out.println(d423.equals(d424));
    }
    /**
     * 重写equals实现比较
     * 方法里面的equals调用String的equals方法
     * @param obj
     * @return 是否相同
     */
    public boolean equals(Object obj){
        if(obj==this)
            return true;
        if(obj instanceof D424){
            if(this.string.equals(((D424) obj).string) && this.age == ((D424) obj).age)
             return true;
        }
        return false;
    }

    /**
     * 有参构造器
     * @param str
     * @param age
     */
    public D424(String str ,int age){
        this.age = age;
        this.string = str;
    }
    public static void main(String[] args) {
        Testequals();
        System.out.println("***************");
        TestString();
        System.out.println("***************");
        TestStringMethod();
    }
}
