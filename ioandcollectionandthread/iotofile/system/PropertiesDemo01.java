package iotofile.system;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo01 {
    public static void main(String[] args) {
       /* Properties prop = new Properties();

        //存储元素
        prop.put("mangmang","yuanyuan");
        prop.put("bao","skjf");
        prop.put("asdf","jkl;");

        //遍历集合
        Set<Object> keySet = prop.keySet();
        for (Object o : keySet){
            Object value = prop.get(o);
            System.out.println(o + "  " + value);
        }*/

        Properties prop = new Properties();
//Object setProperty(String key, String value)：设置集合的键和值，都是

        prop.setProperty("itheima001", "林青霞");
/*
Object setProperty(String key, String value) {
return put(key, value);
}
Object put(Object key, Object value) {
return map.put(key, value);
}
*/
        prop.setProperty("itheima002", "张曼玉");
        prop.setProperty("itheima003", "王祖贤");
//String getProperty(String key)：使用此属性列表中指定的键搜索属性
// System.out.println(prop.getProperty("itheima001"));
// System.out.println(prop.getProperty("itheima0011"));
// System.out.println(prop);
//Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中

        Set<String> names = prop.stringPropertyNames();
        for (String key : names) {
// System.out.println(key);
            String value = prop.getProperty(key);
            System.out.println(key + "," + value);
        }
    }
}
