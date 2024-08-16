package base.JavaIO;

import java.io.*;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;

/**
 * @author wbq
 * @version 1.0
 * @title InputStream
 * @description
 * @create 2024/7/15 13:38
 *
 * 涉及到的涉及模式主要是：1. 装饰器模式（BufferedInputStream对inputStream的动态增强）；
 * 2. 适配器模式（IO 流中的字符流和字节流的接口不同，他们之间的协调工作基于适配器模型完成）；
 */

public class ByteAndCharStream {
    public static void main(String[] args) {
        testByteStream();
        // note： 由于字节流读取中文字符等场景会乱码，因此涉及字符操作最好直接使用字符流
        testCharStream();
        // note： 装饰器模式 增强 InputStream 和 OutputStream 的功能,  使用一个缓冲区一次读取多个字节
        testBufferedStream();
        testBuffer();
    }

    public static void testByteStream() {
        try (InputStream inputStream = new FileInputStream("input.txt")) {
            System.out.println("number of available bytes: " + inputStream.available());
            System.out.print("The byte read from file:");
            for (int content; (content = inputStream.read()) != -1; ) {
                System.out.print((char) content);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream outputStream = new FileOutputStream("output.txt")) {
            byte[] ba = "wangbiqiang".getBytes();
            outputStream.write(ba);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testCharStream() {
        try (FileReader fileReader = new FileReader("input.txt")) {
            System.out.print("The char read from file:");
            for (int content; (content = fileReader.read()) != -1; ) {
                System.out.print((char) content);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testBufferedStream() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input.txt"))) {
            System.out.print("The byte read from file with buffer method:");
            for (int content; (content = bufferedInputStream.read()) != -1; ) {
                System.out.print((char) content);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new FileReader("input.txt");
             BufferedReader fileReader = new BufferedReader(reader)) {
            System.out.print("The char read from file with buffer method:");
            for (int content; (content = fileReader.read()) != -1; ) {
                System.out.print((char) content);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testBuffer() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntBuffer buffer = IntBuffer.wrap(arr);
        System.out.println(buffer.get(1));
    }


}
