package com.drafthj.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by huojia on 2016/3/4 17:38.
 */
public class SocketChannelTest {
    public static void main(String[] args) {
        try (SocketChannel socketChannel = SocketChannel.open();

        ){
            socketChannel.configureBlocking(true);
            socketChannel.bind(new InetSocketAddress("http://www.gkoudai.com/",80));
            System.out.println(socketChannel.isConnected());
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int readByes = socketChannel.read(byteBuffer);
            while (readByes != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char) byteBuffer.get());
                }
                byteBuffer.clear();
                readByes = socketChannel.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
