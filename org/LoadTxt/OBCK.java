package org.LoadTxt;

/**
 * Created by 存 on 2016/5/13.
 */

import java.io.Serializable;

/**
 * 存储整本书的信息
 */
public class OBCK implements Serializable{

    private String name;//书名
    private String date;//下载时间
    private int number;//访问次数
    private boolean over;//是否下载完毕
    private String Type;//类型

    @Override
    public String toString() {
        return "name=" + name+"&date=" + date + "&number=" + number + "&over=" + over + "&Type=" + Type ;
    }

    public OBCK(String name, String date, int number, boolean over, String type) {
        this.name = name;
        this.date = date;
        this.number = number;
        this.over = over;
        Type = type;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
