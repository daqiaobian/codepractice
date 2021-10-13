package internetaddress;

import org.junit.Test;
import sun.reflect.generics.scope.Scope;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TCPTest03 {
    @Test
    public void client() throws IOException {
        //1、创建服务器对象，指明服务器端的ip和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2、获取输出流对象，用于输出数据
        OutputStream os = socket.getOutputStream();
        //3、读取文件用于写入
        FileInputStream fis = new FileInputStream(new File("E:\\test\\QQ图片20210408091034.jpg"));
        //4、写入文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();
        //5、接收来自服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while ((len1 = is.read(bufferr)) != -1){
            baos.write(bufferr,0,len1);
        }
        System.out.println(baos.toString());

        socket.close();
        os.close();
        is.close();
        fis.close();
    }
    @Test
    public void server() throws IOException {
        //1、设置服务器端的端口号
        ServerSocket ss = new ServerSocket(9090);
        //2、接受函数，接受客户端
        Socket socket = ss.accept();
        //3、获取输入流对象，用于读数据
        InputStream is = socket.getInputStream();
        //4、文件接收位置
        FileOutputStream fos = new FileOutputStream(new File("xixidabaobei.jpg"));

        //5、写入数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("图片传输完毕");
        //服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，收到的".getBytes(StandardCharsets.UTF_8));
        ss.close();
        socket.close();
        is.close();
        fos.close();
        os.close();
    }
}
