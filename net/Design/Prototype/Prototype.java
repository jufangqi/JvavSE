package net.Design.Prototype;

import java.io.*;

/**
 * Created by 存 on 2016/6/11.
 */
public class Prototype implements Cloneable , Serializable {

    private static final long serivalVersionUID = 1L;

    private String string;

    private SerializableObject object;

    /**
     * 这里实现克隆
     * 浅表复制
     * 调用的Object的方法 而Object调用本地的方法
     * @return Object
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    /**
     * 这里实现克隆
     * 深表复制
     * 调用的Object的方法 而Object调用本地的方法
     * @return Object
     * @throws
     */
    public Object deepclone() throws IOException, ClassNotFoundException {

        /*写入对象到二进制流*/
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        /*读出二进制流产生的新对象*/
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
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
