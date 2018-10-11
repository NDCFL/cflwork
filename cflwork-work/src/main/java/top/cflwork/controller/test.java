package top.cflwork.controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * Created by chenfeilong on 2017/11/21.
 */

//主类Tanzi，开始
public class test extends Frame{

    /**
     * 图形库界面
     * 实现一些功能：记事本、画图板、关机、重启、
     * cmd命令
     */

    //创建标签按钮
    private Button btn_notepad=new Button("记事本");
    private Button btn_mspaint=new Button("画图板");
    private Button btn_shutdown=new Button("关机");
    private Button btn_restart=new Button("重启");
    //创建鼠标事件侦听器
    MouseEventHandler handler=new MouseEventHandler();




    //构造方开始
    public test(String title){

        super(title);

        //为窗体 注册 窗口事件侦听器
        this.addWindowListener(new WindowAdapter(){
            //重写windowClosing()方法
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });


        //为按钮 注册 事件侦听器
        btn_notepad.addMouseListener(handler);
        btn_mspaint.addMouseListener(handler);
        btn_shutdown.addMouseListener(handler);
        btn_restart.addMouseListener(handler);
        //将按钮添加到窗体中
        this.add(btn_notepad);
        this.add(btn_mspaint);
        this.add(btn_shutdown);
        this.add(btn_restart);

        //设置窗体的尺寸，设置卡片布局管理器，并使窗体在屏幕上居中放置
        this.setSize(300,300);
        this.setLayout(new GridLayout(2,2));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //构造方法结束




    //main方法开始
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new test("test");
    }
    //main方法结束




    //定义承接MouseAdapter适配器的事件侦听器类，开始
    class MouseEventHandler extends MouseAdapter{

        //定义mousePress(MouseEvent e)方法，开始
        public void mousePress(MouseEvent e) throws IOException{

            Runtime rt=Runtime.getRuntime();//获取运行时

            //检测事件源是哪一个按钮，并作出相应的操作
            if(e.getSource()==btn_notepad){
                rt.exec("cmd.exe /c notepad");//获取进程
                System.exit(0);
            }

            if(e.getSource()==btn_mspaint){
                rt.exec("cmd.exe /c mspaint");//获取进程
            }

            if(e.getSource()==btn_shutdown){
                rt.exec("cmd.exe /c shutdown -t 10");//获取进程
            }

            if(e.getSource()==btn_restart){
                rt.exec("cmd.exe /c restart");//获取进程
            }

        }
        //定义mousePress(MouseEvent e)方法，结束
    }
    //定义承接MouseAdapter适配器的事件侦听类，结束



}
//主类Tanzi，结束


