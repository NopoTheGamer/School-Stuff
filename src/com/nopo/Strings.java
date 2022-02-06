package com.nopo;

import static com.nopo.Main.*;
import static com.nopo.functions.Shop.appleStock;

public class Strings {

    public static String invalidInput = "Invalid input";

    public static String inputName = "Input your characters name";
    public static String tooLong = "Your name is too long,";
    public static String trimmed = "so I trimmed it for you";
    public static String helloName = "Hello \"" + name + "\"";
    public static String welcome = "Welcome to the world of Nopo";

    public static String lootChest1 = "You found a loot chest!";
    public static String lootChest2 = "You found 10 coins!";
    public static String lootChest3 = "You now have " + (coins+10) + " coins!";
    public static String lootChest4 = "Your attack increased by 2!";
    public static String lootChest5 = "Your defense increased by 2!";
    public static String lootChest6 = "But it's empty!";

    public static String goblin1 = "Look out " + name + "! There's a monster!";
    public static String goblin2 = "Look out " + name;
    public static String goblin3 = "There's a monster!";
    public static String goblin4 = "Do you want to fight it?";
    public static String goblin5 = "      (Y)es       |        (N)o       ";
    public static String goblin6 = "You got hit for 5 hp!";
    public static String goblin7 = "Your hp is now: " + (hp-5);

    public static String appleTree1 = "Looks like an apple tree!";
    public static String appleTree2 = "Do you want to shake it?   (y) | (n)  ";
    public static String appleTree3 = "You found an apple!";
    public static String appleTree4 = "Some bees attacked you!";
    public static String appleTree5 = "You got hit for 5 hp!";
    public static String appleTree6 = "You didn't shake it!";

    public static String rustySword1 = "You found a rusty sword";
    public static String rustySword2 = "It was just lying on the ground!";
    public static String rustySword3 = "It gives you +3 attack!";

    public static String purse1 = "Looks like someone dropped their purse";
    public static String purse2 = "You took the money from the purse!";
    public static String purse3 = "You now have " + coins + " coins!";

    public static String giantSpider1 = "Look out " + name + "!";
    public static String giantSpider2 = "There's a giant spider!";

    public static String shop1 = "There is a shop!";
    public static String shop2 = "Go inside?      (y)     |     (n)     ";
    public static String shop3 = "Everything is too expensive to buy.";
    public static String notEnoughCoins = "You dont have enough coins to buy this";
    public static String outOfStock = "Sorry, we're out of stock of this item";
    public static String dontHaveItem = "We dont have that item.";
    public static String typeExit = "If you want to exit, type 'exit'";
    public static String shop8 = "Welcome to the shop!";
    public static String shop9 = "What would you like to buy?";
    public static String shop10 = "You have " + coins + " coins.";
    public static String shop11 = "Apple (3 Coins) (" + appleStock + "x left)";
    public static String shop12 = "Key (25 Coins)";
    public static String shop13 = "(R)andom encounters (35 Coins)";
    public static String shop14 = "This shop is out of stock!";
    public static String shop15 = "Type 'exit' to exit";

    public static String ironSword1 = "You found an iron sword";
    public static String ironSword2 = "It was left on the side of this rock";

    public static String keyDoor1 = "Looks like there is a door here!";
    public static String keyDoor2 = "Its locked, you need a key to get in";

    //Items
    public static String apple1 = "That apple must of been rotten.";
    public static String apple2 = "You ate the apple and gained 10 HP!";

    public static String key1 = "You took out the key";
    public static String key2 = "It fits perfectly in the door";
    public static String key3 = "The door and you see a chest!";
    public static String key4 = "You open up the chest and you find";
    public static String key5 = "A shield that gives you 5 defense";
    public static String key6 = "35 Coins";
    public static String key7 = "And a mouldy cookie";
    public static String wrongKeySpot = "There is nowhere to use this key";

    public static String cookieBad = "You bit into the cookie";
    public static String cookieBad1 = "Btw mold isn't good for you";
    public static String cookieGood = "You ate the cookie!";

    //Item Utils
    public static String inventory1 = "Use an item? (item name/n)";
    public static String inventory2 = "You have nothing.";
    public static String inventory3 = "You have:";
}
