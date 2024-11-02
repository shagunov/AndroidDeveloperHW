public class WhileDoWhileForBreakContinue {
    public static void main(String[] args){
        // TODO Задание 1
        int i = 1;
        System.out.print("Числа от 1 до 50, кратные 3: [");
        while (i <= 50){
            if(i % 3 == 0){
                System.out.print(i + ", ");
            }
            ++i;
        }
        System.out.println("\b\b]");

        // TODO Задание 2
        int sum = 0;
        for (int j = 1; j <= 100; ++j){
            sum += j;
        }
        System.out.println("\nСумма чисел от 1 до 100: " + sum);
    }
}
