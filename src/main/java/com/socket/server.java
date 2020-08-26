package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        //定义输出流dos
        DataOutputStream dos = null;
        //定义输入流dis
        DataInputStream dis = null;
        //实例化Socket
        Socket s1 = null;
        try {
            //实例化ServerSocket，并将端口8888给ServerSocket
            ServerSocket s = new ServerSocket(8888);
            System.out.println("服务端已经启动！");
            //当s1接到8888端口的请求
            s1 = s.accept();
            //获得到输出流地址
            dos = new DataOutputStream(s1.getOutputStream());
            //获得到输出流地址
            dis = new DataInputStream(s1.getInputStream());
            //定义Str存放数据
            String str = null;
            //接收信息
            while(true) {
                if((str = dis.readUTF()).equals("88")==false) {
                    System.out.println("客户说：" + str);
                    dos.writeUTF("Tom said: " + str + "!");
                }else {
                    dos.writeUTF("Tom said: " + str + "!");
                    break;
                }

            }
        } catch (IOException e) {
            System.out.println("服务端启动失败！");
            e.printStackTrace();
        }finally{
            try {
                //关闭输入输出流
                dis.close();
                dos.close();
                //关闭连接
                s1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
