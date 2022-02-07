package com.nopo;

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
}