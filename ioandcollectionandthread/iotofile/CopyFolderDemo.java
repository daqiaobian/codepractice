package iotofile;

/*把“E:\itcast”这个文件夹复制到模块目录下
        1.2.2分析步骤
        1. 创建数据源目录File对象，路径是E:\itcast
        2. 获取数据源目录File对象的名称
        3. 创建目的地目录File对象，路径由(模块名+第2步获取的名称)组成
        4. 判断第3步创建的File是否存在，如果不存在，就创建
        5. 获取数据源目录下所有文件的File数组
        6. 遍历File数组，得到每一个File对象，该File对象，其实就是数据源文件
        7. 获取数据源文件File对象的名称
        8. 创建目的地文件File对象，路径由(目的地目录+第7步获取的名称)组成
        9. 复制文件
        由于不清楚数据源目录下的文件都是什么类型的，所以采用字节流复制文件
        采用参数为File的构造方法*/


import java.io.*;

public class CopyFolderDemo {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("E:\\test");
        File destFile = new File("D:\\");

        //写方法实现文件夹的复制，参数为数据源File对象和目的地File对象
        copyFolder(srcFile, destFile);
    }
    private static void copyFolder(File srcFile, File destFile) throws IOException{
        //判断数据源File是否是目录
        if (srcFile.isDirectory()){
            //在目的地下创建和数据源File名称一样的目录
            String srcFileName = srcFile.getName();
            File newFolder = new File(destFile,srcFileName); //D:\\test
            if (!newFolder.exists()){
                newFolder.mkdir();
            }

            //获取数据源File下所有文件或者目录File数组
            File[] fileArray = srcFile.listFiles();

            //遍历该File数组，得到每一个File对象
            for (File file : fileArray){
                //把该File作为数据源File对象，递归调用复制文件夹的方法
                copyFolder(file, newFolder);
            }
        }else{
            //说明是文件，直接复制，用字节流
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }
    private static void copyFile(File srcFile, File destFile) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] byt = new byte[1024];
        int len;
        while ((len = bis.read(byt)) != -1){
            bos.write(byt, 0, len);
        }
        bos.close();
        bis.close();
    }
}
