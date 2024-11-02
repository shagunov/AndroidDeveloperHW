import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // TODO Решение задания 1
        int[] array = {3, 87, 12, 98, 2, 4, 66};
        System.out.println("Исходный массив: " + Arrays.toString(array));

        System.out.print("Числа в обратном порядке: [");
        for(int j = array.length - 1; j >= 0; --j){
            System.out.print(array[j] + ", ");
        }
        System.out.print("\b\b]\n\n");

        // TODO Решение задания 2
        double[] array1 = {5.6, 8.2, 3.2, 3.6, 4.5};
        System.out.println("Исходный массив: " + Arrays.toString(array1));

        /* Сортировка вставками

        for(int i = 0; i < array1.length; ++i){
            for(int j = i; j >= 1; --j){
                if(array1[j] > array1[j -1]){
                    double tmp = array1[j];
                    array1[j] = array1[j - 1];
                    array1[j - 1] = tmp;
                }
            }
        } */

        /* Сортировка выбором

        for(int i = 0; i < array1.length; ++i){
            double current_max = array1[i];
            for(int j = i; j < array1.length; ++j){
                if(array1[j] > current_max) {
                    double tmp = current_max;
                    current_max = array1[j];
                    array1[j] = tmp;
                }
            }
            array1[i] = current_max;
        }*/

        boolean changed = false;
        do {
            changed = false;
            for (int i = 0; i < array1.length - 1; ++i) {
                if (array1[i] < array1[i + 1]) {
                    double tmp = array1[i + 1];
                    array1[i + 1] = array1[i];
                    array1[i] = tmp;
                    changed = true;
                }
            }
        } while(changed);

        System.out.println("Отсортированный массив: " + Arrays.toString(array1));

        // TODO Решение задания 3
        int[] array2 = {6, 117, 44, 5, 32, 81, 9};
        System.out.println("\nИсходный массив: " + Arrays.toString(array2));

        System.out.print("Чётные числа: [");
        for(int num : array2){
            if(num % 2 == 0){
                System.out.print(num + ", ");
            }
        }
        System.out.print("\b\b]");
    }
}
