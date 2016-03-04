package com.drafthj.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by huojia on 2016/3/4 13:11.
 */
public class FileChannelTest {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("D://test.txt", "rw")) {
            FileChannel inchannel = randomAccessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inchannel.read(buf);
            while (bytesRead != -1){
                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining()){
                    System.out.println((char)buf.get());
                }
            buf.clear();
            bytesRead = inchannel.read(buf);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
