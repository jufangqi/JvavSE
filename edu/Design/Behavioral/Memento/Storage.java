package edu.Design.Behavioral.Memento;

/**
 * Created by 存 on 2016/6/12.
 */
public class Storage {

    private Memento memento ;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
