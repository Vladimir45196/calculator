package com.calc;


import java.util.Scanner;

public class Main {
    private static final String ROMAN_NUMBERS = "^(M{0,4})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private static final String ARAB_POS_NUMBERS = "[0-9]+";
    private static final String EXIT = "!";
    private static final String SPACES = "\\s+";
    private static final String MATH_OPERATORS = "[-+/*]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString;
        System.out.println("> Enter an expression with spaces(Example:2 + 2) : ");
        do {

            inputString = scanner.nextLine();
            inputListen(inputString);

        } while (!inputString.matches(EXIT));

    }

    public static String calc(String input) {

        String[] inputNumbers = input.split(SPACES);

        int number1, number2;

        if (inputNumbers.length < 3)
            throw new IllegalArgumentException("String is not a mathematical operation");

        if (inputNumbers.length > 3)
            throw new IllegalArgumentException("The format of the mathematical operation does not satisfy (+, -, /, *)");

        if (!inputNumbers[1].matches(MATH_OPERATORS))
            throw new IllegalArgumentException("Invalid operator.");

        if (inputNumbers[0].matches(ARAB_POS_NUMBERS) && inputNumbers[2].matches(ARAB_POS_NUMBERS)) {

            number1 = Integer.parseInt(inputNumbers[0]);
            number2 = Integer.parseInt(inputNumbers[2]);

            if (number2 < 1 || number2 > 10 || number1 < 1 || number1 > 10)
                throw new IllegalArgumentException("Invalid operand.");

            System.out.println("Valid Arabic numerals entered.");
            return String.valueOf(Calculator.calculateArabNumbers(number1, number2, inputNumbers[1]));

        } else if (inputNumbers[0].matches(ROMAN_NUMBERS) && inputNumbers[2].matches(ROMAN_NUMBERS)) {

            number1 = RomanToNum.romanToInteger(inputNumbers[0]);
            number2 = RomanToNum.romanToInteger(inputNumbers[2]);

            if (number2 < 1 || number2 > 10 || number1 < 1 || number1 > 10)
                throw new IllegalArgumentException("Invalid operand.");

            System.out.println("Valid Roman numerals entered.");

            int checkResult = Calculator.calculateArabNumbers(number1, number2, inputNumbers[1]);

            if (checkResult < 1)
                throw new IllegalArgumentException("The result is outside the conditions.");

            return ConvertRoman.integerToRoman(checkResult);

        } else
            throw new IllegalArgumentException("Invalid operand (requires both numbers to be either Roman or Arabic numbers).");
    }

    public static void inputListen(String inputString) {

        if (!inputString.matches("(^!)")) {
            System.out.print("> Input Validation: ");
            System.out.println("> Result: " + calc(inputString));
        }
    }
}