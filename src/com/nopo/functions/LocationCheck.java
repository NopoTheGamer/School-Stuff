package com.nopo.functions;

import java.util.Arrays;
import java.util.Scanner;

import static com.nopo.functions.Death.death;
import static com.nopo.functions.Fighting.fight;
import static com.nopo.functions.Movement.movement;
import static com.nopo.Main.*;
import static com.nopo.functions.Startup.rngSeed;
import static com.nopo.items.Inventory.items;

public class LocationCheck {
    //one time encounter flags
    public static boolean lootChest1 = false;
    public static boolean appleTree1 = false;
    public static int[] randomNumberX = new int[21];
    public static int[] randomNumberY = new int[21];

    public static void isImportant() {
        if (x == randomNumberX[0] && y == randomNumberY[0]) {
            System.out.println("You found a loot chest!");
            if (!lootChest1) {
                System.out.println("You found 10 coins!");
                coins += 10;
                System.out.println("You now have " + coins + " coins!");

                if (rngSeed > 50) {
                    System.out.println("Your attack increased by 2!");
                    atk += 2;
                } else {
                    System.out.println("Your defense increased by 2!");
                    def += 2;
                }
                lootChest1 = true;
            } else {
                System.out.println("But it's empty!");
            }
            movement();
        } else if (x == randomNumberX[1] && y == randomNumberY[1]) {
            System.out.println("Look out " + name + "! There's a monster!");
            System.out.println("Do you want to fight it? (y/n)");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("y")) {
                fight(10, 3, "Short Goblin");
            } else if (scanner.nextLine().equals("n")) {
                hp -= 5;
                System.out.println("You got hit for 5 hp");
                System.out.println("Your hp is now: " + hp);
                movement();
            } else {
                System.out.println("Invalid input");
                movement();
            }
        } else if (x == randomNumberX[2] && y == randomNumberY[2]) {
            if (!appleTree1) {
                System.out.println("Looks like an apple tree!" + ln + "Do you want to shake it? (y/n)");
                Scanner scanner = new Scanner(System.in);
                if (scanner.nextLine().equals("y")) {
                    if (rngSeed > 20) {
                        System.out.println("You found an apple!");
                        for (int i = 0; i < items.length; i++) {
                            if (items[i] == null) {
                                items[i] = "Apple";
                                break;
                            }
                        }
                    } else {
                        System.out.println("Some bees attacked you!" + ln + "You got hit for 5 hp");
                        hp -= 5;
                        if (hp < 1) {
                            death();
                        }
                    }
                    appleTree1 = true;
                } else if (scanner.nextLine().equals("n")) {
                    System.out.println("You didn't shake it!");
                }
            }
        } else {
            movement();
        }
    }
}
