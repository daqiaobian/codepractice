package binarysearch;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDANCDABDE";
        String str2 = "BBC";
        int[] next = kmpNext(str2);
        System.out.println("next=" + Arrays.toString(next));
        int index = kmpSearch(str1,str2,next);
        System.out.println("index=" + index);
    }

    //写出我们的kmp搜索算法
    /*
    * str1源字符串
    * str2 字串
    * next 部分匹配表，时字串对应的部分匹配表
    * 如果是-1就是没有匹配到，否则返回第一个匹配的位置
    * */
    public static int kmpSearch(String str1, String str2, int[] next){
        //遍历
        for (int i = 0, j = 0; i < str1.length(); i++){
            //需要处理str1.charAt(i) != str2.charAt(j),去调整j的大小
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()) { //找到了 j=3i
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取一个字符串（字串）的部分匹配值表
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串长度为1，部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++){
            //当dest.charAt(i) != dest.charAt(j),我们需要从next[j-1]获取新的j
            //直到我们发现，有 dest.charAt(i) == dest.charAt(j)成立退v出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }
            //当dest.charAt(i) == dest.charAt(j)满足时，部分匹配就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
