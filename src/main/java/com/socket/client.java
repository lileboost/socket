package com.socket;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        //定义输出流dos
        DataOutputStream dos = null;
        //定义输入流dis
        DataInputStream dis = null;
        //实例化socket
        Socket socket = null;
        String s = null;
        try {
            //实例化socket，端口号为8888，ip为localhost，建立连接
            socket = new Socket("localhost", 8888);
            //获得到输出流地址
            dos = new DataOutputStream(socket.getOutputStream());
            //获得到输出流地址
            dis = new DataInputStream(socket.getInputStream());
            while(true ){
                System.out.println("I said：");
                //从控制台获取输入
                Scanner input = new Scanner(System.in);
                String name = input.next();
                // 客户端向服务器端发送请求的内容
                dos.writeUTF(name);
                dos.flush();
                if((s = dis.readUTF()).equals("Tom said: 88!")==false ) {
                    System.out.println(s);
                }else {
                    System.out.println(s);
                    break;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                //关闭输入输出流
                dis.close();
                dos.close();
                //关闭连接
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
