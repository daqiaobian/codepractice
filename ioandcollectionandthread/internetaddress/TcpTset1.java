package internetaddress;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/*
* 实现tcp的网络编程
* 例子1：客户端发送信息给服务端，服务端将数据显示控制台
* */
public class TcpTset1 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try{
            //创建socket对象，指明服务器端的IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);
            //  获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //写出数据的操作
            os.write("nihao ".getBytes(StandardCharsets.UTF_8));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //资源关闭
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket =null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            //调用accept()便是接收来自于客户端的socket
            socket = ss.accept();
            //获取输入流
            is = socket.getInputStream();
            //4、读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("laizi jjj...");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (baos != null ){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null ){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
