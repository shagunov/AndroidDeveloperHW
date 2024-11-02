import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // TODO решение 1-го задания
        String[] stringArray = {"ab", "cd", "ef"};

        System.out.println("Исходная строка: " + Arrays.toString(stringArray));
        char[] charArray = new char[6];

        for(int i = 0; i < stringArray.length; ++i){
            stringArray[i].getChars(0, 2, charArray, i * 2);
        }

        System.out.println("Массив символов: " + Arrays.toString(charArray) + '\n');

        // TODO решение 2-го задания
        String stroke = "12345";
        String result_stroke = new String(new char[]{stroke.charAt(0), stroke.charAt(stroke.length() - 1)});
        System.out.println("Исходная строка: " + stroke);
        System.out.println("Полученная строка: " + result_stroke + '\n');

        // TODO решение 3-го зодания
        String stroke1 = "1203405";
        int zero_first_match_position = stroke1.indexOf('0');
        System.out.println("Исходная строка: " + stroke1);
        System.out.println("Позиция первого нуля: " + zero_first_match_position);
    }
}
