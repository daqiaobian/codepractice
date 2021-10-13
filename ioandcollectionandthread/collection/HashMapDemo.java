package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
需求：
    创建一个hashmap集合，键是学号String，值是学生对象Student。存储三个键值对元素，并遍历
思路：
    1、定义学生类
    2、创建hashmap集合对象
    3、创建学生对象
    4、把学生添加到集合
    5、遍历集合
        方式一：键找值
        方式二：键值对对象找键和值
* */
public class HashMapDemo {
    public static void main(String[] args) {
       /* //创建hashmap集合对象
        HashMap<String, Student> hm = new HashMap<>();
        //创建学生对象
        Student s1 = new Student("林青霞",29);
        Student s2 = new Student("张曼玉",23);
        Student s3 = new Student("王主线",30);

        //把学生对象添加到集合
        hm.put("heima001",s1);
        hm.put("hwima002",s2);
        hm.put("hwima03", s3);
        //方式一：键找值
        Set<String> keyset = hm.keySet();
        for (String key : keyset){
            Student value = hm.get(key);
            System.out.println(key + "," + value.getName()+","+value.getAge());
        }
        System.out.println("_____________________");
        //方法二：键值对对象找键和值
        Set<Map.Entry<String, Student>> entrySet = hm.entrySet();
        for (Map.Entry<String, Student> me : entrySet){
            String key = me.getKey();
            Student value = me.getValue();
            System.out.println(key + "," + value.getName() + "," + value.getAge());
        }*/

        HashMap<Student, String> hm = new HashMap<>();

        Student s1 = new Student("林青霞",29);
        Student s2 = new Student("张曼玉",23);
        Student s3 = new Student("王主线",30);

        hm.put(s1, "武汉");
        hm.put(s2, "北京");
        hm.put(s3, "西安");



        Set<Student> keySet = hm.keySet();
        for (Student key : keySet){
            String value = hm.get(key);
            System.out.println(key.getName()+ "," + key.getAge()+"," + value);
        }
    }
}
/*
* V get(Object key)  根据键获取值
* Set<K> keySet()      获取所有键的集合
* Collection<V> values()    获取所有值的集合
* Set<Map.Entry<K,V>> entrySet   获取所有键值对对象的集合
* */