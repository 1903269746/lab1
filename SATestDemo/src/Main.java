import OOP1.Main1;
import OOP2.Main2;
import OOP3.Main3;
import OOP4.Main4;
import util.CustomJPanel;
import util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileUtil fileUtil = new FileUtil();
        Main1 m1 = new Main1();
        Main2 m2 = new Main2();
        Main3 m3 = new Main3();
        Main4 m4 = new Main4();


        Scanner in = new Scanner(System.in);
        System.out.println("1.主程序-子程序软件体系结构");
        System.out.println("2.面向对象软件体系结构");
        System.out.println("3.事件系统软件体系结构");
        System.out.println("4.管道-过滤软件体系结构");
        System.out.print("请选择：");
        int x = in.nextInt();

        //选择主程序-子程序软件体系结构
        if (x==1){
            CustomJPanel customJPanel = new CustomJPanel();
            File file = new File("D:\\Code\\JavaProject\\SATest1\\pngs\\1.png");
            customJPanel.setFile(file);
            m1.main1();
            System.out.println("转换后的文本为：");
            String filePathA = "D:\\Code\\JavaProject\\SATest1\\txts\\output.txt";
            String dbFileContentA = fileUtil.dbFileContent(filePathA);
            System.out.println(dbFileContentA);
        }

        //选择面向对象软件体系结构
        else if(x==2){
            CustomJPanel customJPanel = new CustomJPanel();
            File file = new File("D:\\Code\\JavaProject\\SATest1\\pngs\\2.png");
            customJPanel.setFile(file);
            m2.main2();
            System.out.println("转换后的文本为：");
            String filePathA = "D:\\Code\\JavaProject\\SATest1\\txts\\output.txt";
            String dbFileContentA = fileUtil.dbFileContent(filePathA);
            System.out.println(dbFileContentA);
        }


        //事件系统软件体系结构
        else if (x==3){
            CustomJPanel customJPanel = new CustomJPanel();
            File file = new File("D:\\Code\\JavaProject\\SATest1\\pngs\\3.png");
            customJPanel.setFile(file);
            m3.main3();
            System.out.println("转换后的文本为：");
            String filePathA = "D:\\Code\\JavaProject\\SATest1\\txts\\output.txt";
            String dbFileContentA = fileUtil.dbFileContent(filePathA);
            System.out.println(dbFileContentA);
        }


        //选择管道-过滤软件体系结构
        else{
            CustomJPanel customJPanel = new CustomJPanel();
            File file = new File("D:\\Code\\JavaProject\\SATest1\\pngs\\4.png");
            customJPanel.setFile(file);
            m4.main4();
            System.out.println("转换后的文本为：");
            String filePathA = "D:\\Code\\JavaProject\\SATest1\\txts\\output.txt";
            String dbFileContentA = fileUtil.dbFileContent(filePathA);
            System.out.println(dbFileContentA);
        }
    }
}
