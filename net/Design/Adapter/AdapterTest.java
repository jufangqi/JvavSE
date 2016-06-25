package net.Design.Adapter;

/**
 * Created by 存 on 2016/6/11.
 * Adapter 测试类
 */
public class AdapterTest {

    public static void main(String[] args) {
       AdapterTest adapterTest = new AdapterTest();
//        adapterTest.TestTargetable();
//        adapterTest.TestWrapple();
        adapterTest.TestInterface();
    }

    /**
     * 类的测试方法
     * 这样两个方法就都能掉了
     * 如果要在类里面在加方法  这个思路来搞 很OK
     */
    public void TestTargetable(){
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }

    /**
     * 对象的测试方法
     */
    public void TestWrapple(){
        Source source = new Source();
        Wrapper wrapper = new Wrapper(source);
        Wrapper wrapper1 = new Wrapper();//or
        wrapper.method1();
        wrapper.method2();
    }

    /**
     * 接口测试方法
     * 接口中定义了太多的方法，以致于有时我们在一些实现类中并不是都需要
     */
    public void TestInterface(){
        SourceSub1 sourceSub1 = new SourceSub1();
        SourceSub2 sourceSub2 = new SourceSub2();

        sourceSub1.method1();
        sourceSub1.method2();//调用的是Wrapple2里面的method2方法 同下
        sourceSub2.method1();
        sourceSub2.method2();//调用的是Wrapple2里面的method2方法 里面什么都没偶有
    }
}
