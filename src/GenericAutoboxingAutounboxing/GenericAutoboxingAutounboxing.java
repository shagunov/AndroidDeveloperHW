package GenericAutoboxingAutounboxing;

import java.util.Arrays;

public class GenericAutoboxingAutounboxing {


    public static void main(String[] args){
        Integer[] integers1 = {3,2,2};
        States<Integer> states1 = new States<>(integers1);
        Integer[] integers2 = {3,2,2};
        States<Integer> states2 = new States<>(integers2);

        Integer[] integers3 = {1,2,2};
        States<Integer> states3 = new States<>(integers3);

        Integer[] integers4 = {3,2,2,2};
        States<Integer> states4 = new States<>(integers4);

        Double[] doubles = {3.0, 2.0, 2.0};
        States<Double> states5 = new States<>(doubles);

        System.out.println(states1.isEqualTo(states2));
        System.out.println(states1.isEqualTo(states3));
        System.out.println(states1.isEqualTo(states4));

        System.out.println("Изначальный массив: " + states1);
        states1.swap(0, 2);
        System.out.println("После обмена позициями индексов: " + states1);

    }
}
