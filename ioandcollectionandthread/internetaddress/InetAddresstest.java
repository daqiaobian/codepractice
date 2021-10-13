package internetaddress;

import org.apache.spark.sql.sources.In;
import org.omg.CORBA.portable.UnknownException;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddresstest {
    public static void main(String[] args) {
        try{
            //File f = new File("");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            InetAddress int4 = InetAddress.getLocalHost();//获取本机IP
            System.out.println(int4);

            //getHostName
            //getHostAddress
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
/*
* 本地回路地址： 127.0.0.1  对应：localhost
* */