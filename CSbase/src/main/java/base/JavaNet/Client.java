package base.JavaNet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title Client
 * @description
 * @create 2024/7/22 11:06
 */

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             Scanner sc = new Scanner(System.in)) {
            System.out.println("已连接到服务端！");
            OutputStream stream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(stream);  //通过转换流来帮助我们快速写入内容
            System.out.println("请输入要发送给服务端的内容：");
            String text = sc.nextLine();
            writer.write(text+'\n');   //因为对方是readLine()这里加个换行符
            writer.flush();
            System.out.println("数据已发送："+text);
        } catch (IOException e) {
            System.out.println("服务端连接失败！");
            e.printStackTrace();
        } finally {
            System.out.println("连接断开");
        }
    }
}
