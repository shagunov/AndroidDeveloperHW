package Debugger;

import java.util.Arrays;

public class Debugger {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 5, 6, 1, 45, 98, 34, 113};

        int maxEven = 0;
        for(var number : numbers){
            if(maxEven < number && number % 2 == 0){
                maxEven = number;
            }
        }

        System.out.println("В ряде чисел: " + Arrays.toString(numbers) + " " + maxEven + " - самое большое чётное число");

        var stroke = "Привет, Александр, с праздником, с Новым Годом";
        var strokeChars = stroke.toCharArray();

        for(int i = 0; i < strokeChars.length; ++i){
            if(Character.isUpperCase(strokeChars[i])) strokeChars[i] = Character.toLowerCase(strokeChars[i]);
            else if(Character.isLowerCase(strokeChars[i])) strokeChars[i] = Character.toUpperCase(strokeChars[i]);
        }

        String switchCaseStroke = new String(strokeChars);
        System.out.println("Исходная строка: " + stroke);
        System.out.println("Строка с изменённым регистром в словах: " + switchCaseStroke);
    }
}
