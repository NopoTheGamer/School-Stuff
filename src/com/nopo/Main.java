package com.nopo;

import java.util.Scanner;

public class Main {

    public static String ln = System.lineSeparator();
    public static String name = "Nopo";

    public static int x = 0;
    public static int y = 0;
    //Player stats
    public static int hp = 100;
    public static int atk = 2;
    public static int def = 0;
    public static int coins = 0;
    public static String[] items = new String[10];
    //Fight stats
    public static int monsterHealth = 0;
    public static int monsterAttack = 0;
    //one time encounter flags
    public static boolean lootChest1 = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your characters name");
        name = scanner.nextLine();
        System.out.println("Hello \"" + name + "\"");
        isImportant();
    }

    public static void movement() {
        System.out.println("What way do you want to go? (u/d/l/r)");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine();
        switch (direction) {
            case "u", "w" -> {
                y++;
                getLocation();
            }
            case "d", "s" -> {
                y--;
                getLocation();
            }
            case "l", "a" -> {
                x--;
                getLocation();
            }
            case "r" -> {
                x++;
                getLocation();
            }
            default -> {
                System.out.println("Invalid input");
                movement();
            }
        }
    }

    public static void getLocation() {
        if (x < 0) {
            System.out.println("You can't go that way");
            x = 0;
            getLocation();
        } else if (y < 0) {
            System.out.println("You can't go that way");
            y = 0;
            getLocation();
        }
        System.out.println("Your location is: x: " + x + ", y: " + y);
        isImportant();
    }

    //check x and y values and if its somewhere important it prompts the user to go to the next location
    public static void isImportant() {
        if (x == 0 && y == 0) {
            System.out.println("Welcome to the world of Nopo");
            movement();
        } else if (x == 0 && y == 1) {
            movement();
        } else if (x == 1 && y == 0) {
            movement();
        } else if (x == 1 && y == 1) {
            movement();
        } else if (x == 1 && y == 2) {
            movement();
        } else if (x == 0 && y == 3) {
            System.out.println("You found a loot chest!");
            if (!lootChest1) {
                System.out.println("You found 10 coins!");
                coins += 10;
                System.out.println("You now have " + coins + " coins!");
                System.out.println("Your attack increased by 2!");
                atk += 2;
                lootChest1 = true;
            } else {
                System.out.println("But it's empty!");
            }
            movement();
        } else if (x == 2 && y == 0) {
            System.out.println("Watch out for the monsters");
            movement();
        } else if (x == 3 && y == 0) {
            System.out.println("Look out " + name + "! There's a monster!");
            System.out.println("Do you want to fight it? (y/n)");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("y")) {
                fight(10, 2, "deez");
            } else if (scanner.nextLine().equals("n")) {
                hp -= 5;
                System.out.println("You got hit for 5 hp");
                System.out.println("Your hp is now: " + hp);
                movement();
            } else {
                System.out.println("Invalid input");
            }
        } else {
            movement();
        }
    }


    public static void fight(int monsterHp, int monsterAtk, String monsterName) {
        monsterHealth = monsterHp;
        monsterAttack = monsterAtk;
        System.out.println("You have " + hp + " hp");
        System.out.println(monsterName + " has " + monsterHp + " hp");
        while (hp > 0 && monsterHealth > 0) {
            int monsterDamage = (int) ((Math.random() * 2) * monsterAttack);
            int playerDamage = (int) ((Math.random() * 4) * atk);
            System.out.println("What do you want to do? (a/d)");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "a" -> {
                    monsterHealth = monsterHealth - playerDamage;
                    hp = hp - monsterDamage;
                    System.out.println("You hit the monster for " + playerDamage + " damage");
                    if (monsterHealth > 0) {
                        System.out.println("The monster has " + monsterHealth + " hp");
                        System.out.println("The monster hits you for " + monsterDamage + " damage");
                        System.out.println("You have " + hp + " hp");
                    } else {
                        monsterHealth = 0;
                    }
                }
                case "d" -> {
                    if (def == 0) {
                        System.out.println("You can't do this without defence smh");
                    } else {
                        System.out.println("run code");
                    }
                }
                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
        if (hp > 0) {
            System.out.println("You defeated " + monsterName);
            System.out.println("You have " + hp + " hp");
            coins += 5;
            System.out.println("You gained 5 coins!" + ln + "You now have " + coins + " coins");
            movement();
        } else {
            System.out.println("You died!");
            coins /= 2;
            System.out.println("You lost half your coins!" + ln + "You now have " + coins + " coins");
            death();
        }
    }

    public static void death() {
        x = 0;
        y = 0;
        hp = 75;
        movement();
    }

}