package edu.Design.Create.Prototype;

import java.io.*;

/**
 * Created by 存 on 2016/6/19.
 */
public class Prototype implements Cloneable,Serializable {

    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject object;

    /**
     * 浅复制
     */
    public Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    /**
     * 深复制
     */
    public Object deepclone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObject() {
        return object;
    }

    public void setObject(SerializableObject object) {
        this.object = object;
    }
}
class SerializableObject implements Serializable{

    private static final long serialVersionUID = 1L;
}
