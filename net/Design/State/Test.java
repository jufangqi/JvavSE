package net.Design.State;

/**
 * Created by 存 on 2016/6/12.
 */
public class Test {

    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        state.setValue("state1");
        context.method();
        state.setValue("state2");
        context.method();

    }
}
