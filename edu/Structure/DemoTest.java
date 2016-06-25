package edu.Structure;

/**
 * Created by 存 on 2016/5/11.
 */
public class DemoTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
       list.add("as");
        list.add("ba");
        list.add("cs");
        list.add("ds");
        list.add("es");
        list.add("fs");
        list.remove("fs");
//        String arr [] = {"aa","bb","cc","dd","ee","ff"};
//        String qq [] = new String[9];
//        System.arraycopy(arr,0,arr,1,arr.length-1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
