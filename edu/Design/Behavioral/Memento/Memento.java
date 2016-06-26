package edu.Design.Behavioral.Memento;

/**
 * Created by 存 on 2016/6/12.
 */
public class Memento {

    private String value;

    public Memento(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
