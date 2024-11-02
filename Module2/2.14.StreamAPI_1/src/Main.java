import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> listString = new LinkedList<>(Arrays.asList(
                "Milk",
                "Cow",
                "Wolf",
                "Monkey",
                "Money",
                "Man",
                "Woman",
                "Child",
                "Minister"
        ));

        char symbol = 'M';

        long countStringsOnM = listString.stream()
                .filter(element -> element.charAt(0) == symbol)
                .count();

        System.out.println("Список слов: " + listString);
        System.out.println("Количество слов на M: " + countStringsOnM + "\n");


        List<Person> personList = new ArrayList<>(Arrays.asList(
        new Person("Sergey",27),
        new Person("July",30),
        new Person("Mark",24),
        new Person("Oleg",34),
        new Person("Anna",35),
        new Person("Anton",32),
        new Person("Serafima",32),
        new Person("Mary",23),
        new Person("Josef",32),
        new Person("Elena",35),
        new Person("Elizabeth",25)));

        personList.stream()
                .filter(element -> element.getAge() > 30)
                .forEach(element -> System.out.printf("Name: %s, age: %d\n", element.getName(), element.getAge()));
    }
}
