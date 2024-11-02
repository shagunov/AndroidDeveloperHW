import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Enum_ {
    enum Alphabet{
        A(1),
        B(2),
        C(3),
        D(4),
        E(5),
        F(6),
        G(7),
        H(8),
        I(9),
        J(10),
        K(11),
        L(12),
        M(13),
        N(14),
        O(15),
        P(16),
        Q(17),
        R(18),
        S(19),
        T(20),
        U(21),
        V(22),
        W(23),
        X(24),
        Y(25),
        Z(26),
        INVALID(27);

        final private int type;

        Alphabet(int type){
            this.type = type;
        }

        public int getType(){
            return type;
        }

    };

    public static void main(String[] args){
        Alphabet letter = Alphabet.A;

        System.out.println("Буква " + letter + " " + getLetterPosition(letter) + "-ая в алфавите");

        List<Person2> personList = new ArrayList<>();
        personList.add(new Person2("Sergey", 27, Person2.Gender.MALE));
        personList.add(new Person2("July", 30, Person2.Gender.FEMALE));
        personList.add(new Person2("Mark", 24, Person2.Gender.MALE));
        personList.add(new Person2("Oleg", 34, Person2.Gender.MALE));
        personList.add(new Person2("Anna", 35, Person2.Gender.FEMALE));
        personList.add(new Person2("Anton", 32, Person2.Gender.MALE));
        personList.add(new Person2("Serafima", 32, Person2.Gender.FEMALE));
        personList.add(new Person2("Mary", 23, Person2.Gender.FEMALE));
        personList.add(new Person2("Josef", 32, Person2.Gender.MALE));
        personList.add(new Person2("Elena", 35, Person2.Gender.FEMALE));
        personList.add(new Person2("Elizabeth", 25, Person2.Gender.FEMALE));

        System.out.println("Мужчины: " + getGenderList(personList, Person2.Gender.MALE));
        System.out.println("Женщины: " + getGenderList(personList, Person2.Gender.FEMALE));
    }

    public static int getLetterPosition(Alphabet letter){
        return letter.getType();
    }

    public static LinkedList<Person2> getGenderList(Collection<Person2> people, Person2.Gender gender){
        LinkedList<Person2> result = new LinkedList<>();
        for(var person : people){
            if(person.getGender() == gender){
                result.add(person);
            }
        }
        return result;
    }
}
