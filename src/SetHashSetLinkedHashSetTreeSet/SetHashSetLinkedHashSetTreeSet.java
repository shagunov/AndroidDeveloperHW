package SetHashSetLinkedHashSetTreeSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetHashSetLinkedHashSetTreeSet {
    public static void main(String[] args){
        Set<String> colors1 = new HashSet<>();
        Set<String> colors2 = new HashSet<>();

        colors1.add("green");
        colors1.add("blue");
        colors1.add("yellow");
        colors1.add("red");
        colors1.add("pink");

        colors2.add("green");
        colors2.add("orange");
        colors2.add("yellow");
        colors2.add("white");
        colors2.add("pink");

        Set<String> commonColors = equalElements(colors1, colors2);
        System.out.println("Первый набор: " + colors1);
        System.out.println("Второй набор: " + colors2);
        System.out.println("Общие цвета: " + commonColors);

        Set<Integer> numbers = new HashSet<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(10);
        numbers.add(35);
        numbers.add(69);
        numbers.add(2);
        numbers.add(1);
        numbers.add(44);
        numbers.add(32);

        Set<Integer> evenGreater15Numbers = new HashSet<>();
        Set<Integer> otherNumbers = new HashSet<>();

        for(var number : numbers){
            if(number.compareTo(15) > 0 && number % 2 == 0){
                evenGreater15Numbers.add(number);
            }
            else {
                otherNumbers.add(number / 2);
            }
        }

        System.out.println("\nИсходный массив: " + numbers);
        System.out.println("Чётные числа больше 15: " + evenGreater15Numbers);
        System.out.println("Остальные числа, поделённые на два: " + otherNumbers);
    }

    public static Set<String> equalElements(Set<String> lhs, Set<String> rhs){
        Set<String> result = new HashSet<>();

        for(var rhsElement : rhs){
            if(lhs.contains(rhsElement)){
                result.add(rhsElement);
            }
        }

        return result;
    }
}
