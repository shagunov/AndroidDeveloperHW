import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> colorList = new ArrayList<>();

        colorList.add("green");
        colorList.add("blue");
        colorList.add("yellow");
        colorList.add("red");
        colorList.add("magenta");
        colorList.add("grey");
        colorList.add("white");

        String color = "White";
        boolean isContain = isContainColor(colorList, color);
        if(isContain){
            System.out.println("Collection contains " + color + " color.");
        } else {
            System.out.println("Collection don't contain " + color + " color." );
        }

        List<Integer> numbers = new LinkedList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(9);
        numbers.add(123);

        System.out.println("\nИзначальный список: " + numbers);
        System.out.println("Список с переменой мест первого и посленего члена: " + swapBeginEnd(numbers));


    }

    public static List<Integer> swapBeginEnd(List<Integer> numbersList){
        var tmp = numbersList.get(0);
        numbersList.set(numbersList.size() - 1, numbersList.get(0));
        numbersList.set(0, tmp);
        return numbersList;
    }

    public static boolean isContainColor(List<String> arrayColors, String color){
        for(var color_ : arrayColors){
            if(color_.equalsIgnoreCase(color)) return true;
        }
        return false;
    }

}
