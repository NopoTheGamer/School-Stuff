package com.nopo.functions;

import com.nopo.Utils;

public class BattleHouse {
    public static int maxMonsterKilled = 0;
    public static void enter() {
        Utils.printTrimmer();
        Utils.printFormattedLine("Welcome to the coliseum!");
        Utils.printTrimmer();
        Utils.printFormattedLine("(1) Small Bat");
        Utils.printFormattedLine("(2) Goblin" + (maxMonsterKilled < 1 ? " (LOCKED)" : ""));
        Utils.printFormattedLine("(3) Dragon" + (maxMonsterKilled < 2 ? " (LOCKED)" : ""));
        Utils.printFormattedLine("(4) Skeleton" + (maxMonsterKilled < 3 ? " (LOCKED)" : ""));
        Utils.printFormattedLine("(5) Magma Monster" + (maxMonsterKilled < 4 ? " (LOCKED)" : ""));
        Utils.printFormattedLine("(6) Revenant" + (maxMonsterKilled < 5 ? " (LOCKED)" : ""));
        System.out.println(Utils.lt);
        Utils.printFormattedLine("(exit) to exit");
        Utils.printTrimmer();
        pickFight();
    }

    public static void pickFight() {
        switch (Utils.textInput()) {
            case "1" -> {
                if (maxMonsterKilled == 0) {
                    maxMonsterKilled = 1;
                }
                Fighting.fight(5, 6, "Small bat", 2, "", 0, true);
            }
            case "2" -> {
                if (maxMonsterKilled == 1) {
                    maxMonsterKilled = 2;
                }
                if (maxMonsterKilled > 0) {
                    Fighting.fight(50, 3, "Goblin", 3,"", 0, true);
                }
                enter();
            }
            case "3" -> {
                if (maxMonsterKilled == 2) {
                    maxMonsterKilled = 3;
                }
                if (maxMonsterKilled > 1) {
                    Fighting.fight(40, 6, "Dragon", 4,"", 0, true);
                }
                enter();
            }
            case "4" -> {
                if (maxMonsterKilled == 3) {
                    maxMonsterKilled = 4;
                }
                if (maxMonsterKilled > 2) {
                    Fighting.fight(20, 8, "Skeleton", 5,"", 0, true);
                }
                enter();
            }
            case "5" -> {
                if (maxMonsterKilled == 4) {
                    maxMonsterKilled = 5;
                }
                if (maxMonsterKilled > 3) {
                    Fighting.fight(65, 6, "Magma Monster", 3,"", 0, true);
                }
                enter();
            }
            case "6" -> {
                if (maxMonsterKilled == 5) {
                    maxMonsterKilled = 6;
                }
                if (maxMonsterKilled > 4) {
                    Fighting.fight(35, 10, "Revenant", 3,"", 0, true);
                }
                enter();
            }
            case "exit" -> {
                Movement.movement();
            }
            default -> {

            }
        }
    }
}
