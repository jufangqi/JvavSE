package net.Design.Bridge;

/**
 * Created by 存 on 2016/6/11.
 */
public class BridgeTest {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();
        Sourceable sourceable1 = new SourceSub1();
        bridge.setSourceable(sourceable1);
        bridge.method();
        Sourceable sourceable2 = new SourceSub2();
        bridge.setSourceable(sourceable2);
        bridge.method();
    }
}
