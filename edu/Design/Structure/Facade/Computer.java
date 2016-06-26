package edu.Design.Structure.Facade;

/**
 * Created by 存 on 2016/6/11.
 */
public class Computer {

    private CPU cpu;

    private Memory memory;

    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void startup(){
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished!");
    }

    public void shutdown(){
        System.out.println("begin to close computer!");
        disk.shutdowm();
        memory.shutdowm();
        cpu.shutdown();
        System.out.println("GG");
    }
}
