package com.calc;

class ConvertRoman {
    private static final int[] arab = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public static String integerToRoman(int num) {

        String roman = "";

        if (num < 1 || num > 3999) {
            System.out.println("Result error. Roman numeral out of range 1 - 3999");
        }
        while (num > 0) {
            int maxFound = 0;
            for (int i = 0; i < arab.length; i++) {
                if (num >= arab[i]) {
                    maxFound = i;
                }
            }
            roman += romans[maxFound];
            num -= arab[maxFound];
        }
        return roman;
    }
}

