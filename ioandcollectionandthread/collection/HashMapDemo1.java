package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo1 {
    public static void main(String[] args) {
        Map<String, String> mm = new HashMap<>();

        mm.put("001", "001");
        mm.put("002","lin");
        mm.put("key", "value");

        Set<String> keySet = mm.keySet();

        for (String key : keySet){
            String value = mm.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
