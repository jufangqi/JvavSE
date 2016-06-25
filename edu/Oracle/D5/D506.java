package edu.Oracle.D5;

/**
 * Created by 存 on 2016/5/6.
 */
import java.io.File;

/**
 * I/O 测试类
 *show方法 递归调用展示每个文件夹目录
 *file2.mkdir();创建文件夹，懒。mkdir创建文件夹，勤。
 */
public class D506 {
    public static void main(String[] args) throws Exception {
        D506 d = new D506();
        File file = new File("F://Temp");
        d.show(file,0);
        File file2 = new File("F://Temp/Demo.txt");
        file2.createNewFile();
    }

    public void show(File file,int index){
        for (int i = 0; i < index; i++) {
            System.out.print("-");
        }
        System.out.print(file.getName());
        if(file.isHidden())
            System.out.print("   隐藏文件");
        System.out.println();
        if(file.isDirectory()){
            for (File f:file.listFiles()) {
                show(f,index+1);
            }
        }
    }
}
