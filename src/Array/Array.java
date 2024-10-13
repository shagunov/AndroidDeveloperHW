package Array;

public class Array {
    public static void main(String[] args){
        // TODO Решение задания 1
        int[] array = {3, 87, 12, 98, 2, 4, 66};

        System.out.println("Числа в обратном порядке");
        for(int j = array.length - 1; j >= 0; --j){
            System.out.println(array[j]);
        }

        // TODO Решение задания 2
        int[] array1 = {6, 117, 44, 5, 32, 81, 9};

        System.out.println("\nЧётные числа:");
        for(int num : array1){
            if(num % 2 == 0){
                System.out.println(num);
            }
        }
    }
}
