package headfirst;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字A:");
            String A = sc.nextLine();
            System.out.println("请选择运算符（+、-、*、/）:");
            String str = sc.nextLine();
            System.out.println("请输入数字B:");
            String B = sc.nextLine();
            String strResult;
            switch (str){
                case "+":
                    strResult = String.valueOf(Integer.parseInt(A) + Integer.parseInt(B));
                    System.out.println("结果是"+strResult);
                    break;
                case "-":
                    strResult = String.valueOf(Integer.parseInt(A) - Integer.parseInt(B));
                    System.out.println("结果是"+strResult);
                    break;
                case "*":
                    strResult = String.valueOf(Integer.parseInt(A) * Integer.parseInt(B));
                    System.out.println("结果是"+strResult);
                    break;
                case "/":
                    if (Integer.parseInt(B) != 0){
                        strResult = String.valueOf(Integer.parseInt(A) / Integer.parseInt(B));
                        System.out.println("结果是"+strResult);
                    }else
                        strResult = "除数不能除0";
                    System.out.println(strResult);
                    break;
            }

        }catch (Exception ex){
            System.out.println("输入有错"+ex.getMessage());
        }
    }
}
