package StreamAPI_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI_2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 4, 6, 13, 15, 64, 267, 124, 2011));
        numbers.stream()
                .filter(element -> element % 2 == 0)
                .reduce(Integer::sum)
                .ifPresent(evenSum -> System.out.println("Сумма всех чётных чисел: " + evenSum));

        numbers.stream()
                .filter(integer -> integer % 2 == 1)
                .reduce(Integer::sum)
                .ifPresent(oddSum -> System.out.println("Сумма всех нечётных чисел: " + oddSum));

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(3, 4, 3, 6, 3, 13, 6, 4, 15, 64, 267, 124, 2011));
        System.out.println("Исходный ряд: " + numbers2);
        System.out.println("Ряд без повторений: " +
        numbers2.stream()
                .distinct()
                .toList());
    }
}
