package com.calc;


public class Calculator {

    public static int calculateArabNumbers(int number1, int number2, String operand) {

        return switch (operand) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "/" -> number1 / number2;
            case "*" -> number1 * number2;
            default -> 0;
        };
    }

}
