package com.nopo.functions;

import static com.nopo.items.Inventory.items;

public class GetItem {
    public static void getItem(String item, int Amount) {
        int amount = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                amount++;
                items[i] = item;
                if (amount == Amount) {
                    break;
                }
            }
        }
    }
}
