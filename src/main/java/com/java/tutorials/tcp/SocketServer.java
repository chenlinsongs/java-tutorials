package com.java.tutorials.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author linsong.chen
 * @date 2020-08-01 14:39
 *
 * 该例子用来模拟tcp TIME_WAIT、CLOSE_WAIT、FIN_WAIT_2三种状态的生成
 *
 * 一.FIN_WAIT_2状态生成
 *   1.服务器主动关闭连接
 *   2.客户端不关闭连接，忽略连接
 *
 * 二.TIME_WAIT状态生成-主动关闭方
 *   1.服务器主动关闭连接
 *   2.客户端睡2两秒，然后也关闭连接
 *
 * 三.CLOSE_WAIT状态生成-被动关闭方
 *   1.屏蔽服务端连接的close方法
 *   2.客户端主动关闭连接
 *
 */
public class SocketServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9100);
        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("socket:"+clientSocket.toString());
            clientSocket.getOutputStream().write("hello".getBytes());
            clientSocket.getOutputStream().flush();
            Thread.sleep(1000);
            clientSocket.close();
            System.out.println("socket close");
        }

    }
}
