package iotofile.system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class SystemOutDemo {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("E:\\test\\fos.txt"),true);
        pw.println("hyuihui");
        pw.println("ahui ");
        pw.close();
    }
}
