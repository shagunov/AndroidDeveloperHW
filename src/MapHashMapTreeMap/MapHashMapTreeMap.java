package MapHashMapTreeMap;

import java.util.*;

public class MapHashMapTreeMap {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();

        map.put(4, "Sun");
        map.put(6, "Mars");
        map.put(8, "Saturn");

        System.out.println("Коллекция: " + map);
        System.out.println("Ключи: " + enumerateMapKeys(map));

        System.out.println("Новая преобразованная коллекция: " + mapTransform(map));
    }

    public static Set<Integer> enumerateMapKeys(Map<Integer, String> map){
        return map.keySet();
    }

    public static Map<String, Integer> mapTransform(Map<Integer, String> map){
        Map<String, Integer> result = new HashMap<>();

        for(var entry : map.entrySet()){
            if(entry.getValue().length() > 3){
                result.put(entry.getValue(), entry.getKey());
            }
        }

        return result;
    }
}
