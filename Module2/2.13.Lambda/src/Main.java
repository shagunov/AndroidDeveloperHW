import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> numbers = new ArrayList<>(Arrays.asList(3, 4, 7, 7, 8, 10, 100, 34, 42, 33));
        Sumable evenSum = (Collection<Integer> numbers_) -> {
            int sum = 0;
            for(var number : numbers_){
                if(number % 2 == 0) sum += number;
            }
            return sum;
        };

        System.out.println("Ряд: " + numbers);
        System.out.println("Сумма всех чётных чисел в ряду: " + evenSum.sum(numbers));

        Collection<String> strings = new ArrayList<>(Arrays.asList("Rise", "Down", "Finger", "Computer"));

        SentenceProcessor longestWord = (Collection<String> sentence) -> {
            int maxLength = 0;
            String result = "";
            for(var word : sentence){
                if(maxLength < word.length()) {
                    maxLength = word.length();
                    result = word;
                }
            }

            return result;
        };

        System.out.println("\nСписок слов: " + strings);
        System.out.println("Самое длинное слово: " + longestWord.processStroke(strings));

    }
}

@FunctionalInterface
interface Sumable{
    int sum(Collection<Integer> numbers);
}

@FunctionalInterface
interface SentenceProcessor{
    String processStroke(Collection<String> strokes);
}
