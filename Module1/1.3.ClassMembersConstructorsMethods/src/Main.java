public class Main {
    public static void main(String[] args){
        Calculator calculator = new Calculator();

        calculator.a = 6;
        calculator.b = 9;

        System.out.println("Число a: " + calculator.a);
        System.out.println("Число b: " + calculator.b);

        System.out.println("\nСумма чисел: " + calculator.sum());
        System.out.println("Разность чисел: " + calculator.sub());

        System.out.print("\nПроизведение чисел: ");
        calculator.mul();
        System.out.print("Частное чисел: ");
        calculator.div();
    }
}
