package com.drafthj.nio.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * Created by huojia on 2016/3/4 16:31.
 */
public class FileChannelTransfer {
    /**
     * to从from复制
     * @param to
     * @param from
     */
    public static void copyFrom(String to,String from){
        try (RandomAccessFile fromFile = new RandomAccessFile(from,"rw");
             RandomAccessFile tofile = new RandomAccessFile(to,"rw");
             FileChannel fromChannel = fromFile.getChannel();
             FileChannel toChannel = tofile.getChannel();
        ){
            toChannel.transferFrom(fromChannel,0,fromChannel.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将from复制到to
     * @param from
     * @param to
     */
    public static void copyTo(String from,String to){
        try(RandomAccessFile fromFile = new RandomAccessFile(from,"rw");
            RandomAccessFile toFile = new RandomAccessFile(to,"rw");
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
        ){
            fromChannel.transferTo(0,fromChannel.size(),toChannel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        copyTo("D:/from.txt","D:/to.txt");
        copyFrom("D:/to.txt","D:/from.txt");
    }
}
