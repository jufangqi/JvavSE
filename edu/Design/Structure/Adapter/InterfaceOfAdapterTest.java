package edu.Design.Structure.Adapter;

/**
 * Created by 存 on 2016/6/26.
 */
public class InterfaceOfAdapterTest {

    public static void main(String[] args) {
        Sourceable sourceable1 = new SourceSub2();
        Sourceable sourceable2 = new SourceSub1();
        sourceable1.method1();
        sourceable1.method2();
        sourceable2.method1();
        sourceable2.method2();
    }
}
