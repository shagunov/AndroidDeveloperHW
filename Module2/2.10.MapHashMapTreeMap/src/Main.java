import java.util.*;

public class Main {
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

    public static Map<Integer, String> mapTransform(Map<Integer, String> map){
        Map<Integer, String> result = new HashMap<>();

        for(var entry : map.entrySet()){
            if(entry.getValue().length() > 3){
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }
}
