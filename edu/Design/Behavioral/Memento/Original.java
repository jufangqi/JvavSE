package edu.Design.Behavioral.Memento;

/**
 * Created by 存 on 2016/6/12.
 */
public class Original {

    private String value;

    public Original(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento createMemento(){
        return new Memento(value);
    }

    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}
