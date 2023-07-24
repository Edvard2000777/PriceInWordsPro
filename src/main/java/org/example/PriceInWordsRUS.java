package org.example;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;


public class PriceInWordsRUS {
    private static final String[] units = {
            "", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять", "десять",
            "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };

    private static final String[] tens = {
            "", "", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    };

    private static final String[] hundreds = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"
    };

//    private static final String[] largeUnits = {
//            "", "тысяч", "миллионов",
//    };

    public static String Thousend(int unitIndex, long number1) {
        // 1000 000
        String cur1 = " ";
        String cur = String.valueOf(number1);
        if (number1 > 9) {
            number1 = CHar(0, number1);
        }
        StringBuilder words = new StringBuilder("");
        if (unitIndex == 0) {
            return " ";
        } else if (unitIndex == 1) {

            cur1 = StringUtils.right(cur, 2);
            if (cur1.equals(new String("11"))||cur1.equals(new String("12"))||cur1.equals(new String("13"))||cur1.equals(new String("14"))){
                return "тысяч";
            }
            // int number1=CHar( 4, number);
            if (number1 == 1) {
                words.append("тысяча").append("");
            } else if (number1 > 1 && number1 < 5) {
                words.append("тысячи").append(" ");
            } else if (number1 >= 5 && number1 == 0) {
                words.append("тысяч").append(" ");
            }
        } else if (unitIndex == 2) {
            // int number1=CHar( 7, number);
            cur1 = StringUtils.right(cur, 2);
            if (cur1.equals(new String("11"))||cur1.equals(new String("12"))||cur1.equals(new String("13"))||cur1.equals(new String("14"))){
                return "милионов";
            }
            if (number1 == 1) {
                words.append("милион").append(" ");
            } else if (number1 > 1 && number1 < 5) {
                words.append("милиона").append(" ");
            } else if (number1 >= 5 && number1 == 0) {
                words.append("милионов").append(" ");
            }
        }
        return String.valueOf(words);
    }

    public static String convertToWords(long number) {
        if (number == 0) {
            return "ноль";
        }

        if (number < 0) {
            return "минус " + convertToWords(Math.abs(number));
        }

        StringBuilder words = new StringBuilder();

        int unitIndex = 0;

        while (number > 0) {
            if (number % 1000 != 0) {
                String currentWords = convertToWordsUnderThousand((int) (number % 1000), unitIndex);
                if (unitIndex > 0) {
                    currentWords += " " + Thousend(unitIndex, number);
                }
                words.insert(0, currentWords + " ");
            }
            number /= 1000;
            unitIndex++;
        }

        return words.toString().trim();
    }

    public static int CHar(int Index, long number) {
        String cur = String.valueOf(number);
        // int lastIndex = cur.length() - 1;
        char lastCharacter = cur.charAt(Index);
        int numberOne = Integer.valueOf("" + lastCharacter);
        return numberOne;
    }

    public static String Curency(int number) {
        String cur1 = " ";
        String cur = String.valueOf(number);
        cur1 = StringUtils.right(cur, 2);
    //    if (cur1 == "11" && cur1 == "12" && cur1 == "13" && cur1 == "14")
        if (cur1.equals(new String("11"))||cur1.equals(new String("12"))||cur1.equals(new String("13"))||cur1.equals(new String("14"))){
            return "рублей";
        }
        int lastIndex = cur.length() - 1;
        int numberOne = CHar(lastIndex, number);

        if (numberOne == 1) {
            return cur1 = "рубль";
        } else if (numberOne > 1 && numberOne < 5) {
            return cur1 = "рубля";
        } else //if (numberOne >= 5 && numberOne == 0) {
            return cur1 = "рублей";
    }

    private static String convertToWordsUnderThousand(int number, int unitIndex) {
        StringBuilder words = new StringBuilder();

        if ((number / 100) > 0) {
            words.append(hundreds[number / 100]).append(" ");
            number %= 100;
        }

        if (number > 0) {
            if (number < 20) {
                words.append(getUnits(number, unitIndex)).append(" ");
            } else {
                words.append(tens[number / 10]).append(" ");
                if ((number % 10) > 0) {
                    words.append(getUnits(number % 10, unitIndex)).append("");
                }
            }
        }

        return words.toString().trim();
    }

    private static String getUnits(int number, int unitIndex) {
        if (unitIndex == 1 && number == 1) {
            return "одна";
        } else if (unitIndex == 1 && number == 2) {
            return "две";
        } else {
            return units[number];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        scanner.close();

        String priceInWords = convertToWords(number) + " " + Curency(number);
        System.out.println(priceInWords);
    }
}
