package edu.Design.Structure.Bridge;

/**
 * Created by 存 on 2016/6/11.
 */
public abstract class Bridge {

    private Sourceable sourceable;

    public void method(){
        sourceable.method();
    }

    public Sourceable getSourceable() {
        return sourceable;
    }

    public void setSourceable(Sourceable sourceable) {
        this.sourceable = sourceable;
    }
}
