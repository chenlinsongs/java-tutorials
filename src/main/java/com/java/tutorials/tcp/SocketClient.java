package com.java.tutorials.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @author linsong.chen
 * @date 2020-08-01 14:42
 */
public class SocketClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0;i < 60;i++){
            System.out.println(i);
            Socket socket = new Socket("104.160.47.21", 9100);
            byte[] bb = new byte[5];
            socket.getInputStream().read(bb);
            System.out.println(new String(bb));
            Thread.sleep(2000);
            socket.close();

        }

        System.out.println();

    }
}
