package com.nopo;

import java.util.Locale;
import java.util.Scanner;

public class Utils {

    public static String ln = System.lineSeparator();
    public static String lnt = ln + "|" + printSpaces(40) + "|";
    public static String lt = "|" + printSpaces(40) + "|";

    public static String getSpaceLength(String str, int length) {
        int strLength = str.length();
        int dashLength = 35;
        int spaceLength = dashLength - strLength - length;
        return " ".repeat(spaceLength);
    }
    public static String getSpaceLength(int number, int maxLength) {
        int spaceLength = String.valueOf(number).length();
        return " ".repeat(maxLength - spaceLength);
    }
    public static void printTrimmer() {
        System.out.println("|----------------------------------------|");
    }

    public static String printSpaces(int number) {
        return " ".repeat(number);
    }

    public static void printFormattedLine(String str) {
        System.out.println( "| " +
                str +
                " ".repeat(39 - str.length()) +
                "|");
    }
    public static void printFormattedLineFront(String str) {
        System.out.println( "|" +
                " ".repeat(39 - str.length()) +
                str +
                " |");
    }

    public static String textInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.toLowerCase(Locale.ENGLISH);
    }
}