package WhileDoWhileForBreakContinue;

public class WhileDoWhileForBreakContinue {
    public static void Main(String[] args){
        // TODO Задание 1
        int i = 1;

        while (i <= 50){
            if(i % 3 == 0){
                System.out.println(i);
            }
            ++i;
        }

        // TODO Задание 2
        int sum = 0;
        for (int j = 1; i <= 100; ++i){
            sum += i;
        }
    }
}
