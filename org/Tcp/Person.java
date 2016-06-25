package org.Tcp;

/**
 * Created by 存 on 2016/5/20.
 */
public class Person {
    private boolean start;//是否开始 true为开始
    private boolean walk;//是否轮到本人走 true为轮到
    private boolean sente;//是否先手 true为先手
    private int time;//计时器如果time>60 则为输
    private int cp ;//棋子颜色 1为白色 2位黑色 ,先走为白色，后手为黑色
    private int op ;//对方棋子颜色

    public Person(boolean start,boolean sente) {
        this.start = start;
        this.walk = sente;//若是先手 则第一回个走
        this.sente = sente;
        this.cp = sente ? 1:2;
        this.op = sente ? 2:1;
    }

    public Person() {}//空构造器

    public boolean isStart() {return start;}
    public void setStart(boolean start) {this.start = start;}
    public void setStart() {start = start ? false : true;}//对setStart重载 实现变换里面的属性

    public boolean isWalk() {return walk;}
    public void setWalk(boolean walk) {this.walk = walk;}
    public void setWalk() {this.walk = this.walk ? false : true;time =0;}//对setWalk重载 实现 修改time的值

    public boolean isSente() {return sente;}//棋子颜色和是否先手有关，所以没有cp和op的set方法
    public void setSente(boolean sente) {this.sente = sente; this.cp = sente ? 1:2;this.cp = sente ? 2:1;}
    public int getCp() {return cp;}
    public int getOp() {return op;}

    public int getTime() {return time;}
    public void setTime() {
        this.time ++;
        if(time>60){
            setWalk(false);
        }
    }
}
