//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // TODO: Задача 1.
        // Проверяемые переменные
        int x = 2, y = 2;
        System.out.println("Число x: " + x);
        System.out.println("Число y: " + y + "\n");

        // Вариант со вложенным if
        if(x % 2 == 0){
            if(y % 2 == 0) {
                System.out.println("Удачное совпадение");
            }
        } else if (x % 2 == 1) {
            if (y % 2 == 1){
                System.out.println("Удачное совпадение");
            }
        }

        //Более краткий код с применением оператора конъюнкции и дизъюнкции
        if((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)){
            System.out.println("Удачное совпадение");
        }

        // TODO: задача 2
        //Число для проверки
        int day = 10;
        System.out.println("\nТекущий день: " + day);

        // Решение включает проверку на корректность числа месяца
        // 1-10 - первая декада
        // 11-20 - вторая декада
        // 21-31 - третья декада

        // Вариант со вложенным if
        if (day <= 31) {
            if(day >= 1){
                switch ((day - 1) / 10) {
                    case 0:
                        System.out.println("Первая декада");
                        break;
                    case 1:
                        System.out.println("Вторая декада");
                        break;
                    case 2:
                    case 3:
                        System.out.println("Третья декада");
                        break;
                    default:
                        System.out.println("Некорректно введено число месяца");
                }
            } else {
                System.out.println("Некорректно введено число месяца");
            }
        } else {
            System.out.println("Некорректно введено число месяца");
        }

        // Более краткий вариант с конъюнкцией
        if(day <= 31 && day >= 1) {
            switch ((day - 1) / 10) {
                case 0:
                    System.out.println("Первая декада");
                    break;
                case 1:
                    System.out.println("Вторая декада");
                    break;
                case 2:
                case 3:
                    System.out.println("Третья декада");
                    break;
                default:
                    System.out.println("Некорректно введено число месяца");
            }
        } else {
            System.out.println("Некорректно введено число месяца");
        }
    }
}