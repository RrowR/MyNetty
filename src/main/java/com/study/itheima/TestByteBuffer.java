package com.study.itheima;


import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Rrow
 * @date: 2024/2/15 17:02
 * Description:
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            while (true) {
                // 划分十个字节作为缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(10);
                // 从channel中读，向buffer中写入
                int read = channel.read(buffer);
                // log.info("读取到的字节：" + read);
                // 判断是否读取结果为 -1 （为空） 则退出循环
                if (read == -1) {
                    break;
                }
                // 打印buffer的内容
                buffer.flip();      // 切换为读模式
                // 判断buffer里是否还有剩余的数据
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.info("((char) b) = " + ((char) b));
                }
            }
        } catch (IOException e) {
        }
    }
}
