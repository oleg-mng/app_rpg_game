package org.inwork.utils;

import org.inwork.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int gold;
    private List<Item> items;

    public Inventory() {
        this.gold = 0;
        this.items = new ArrayList<>();
    }

    public int getGold() {
        return gold;
    }

    public List<Item> getItems() {
        return items;
    }


    public void addGold(int amount) {
        gold += amount;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItem(List<Item> items) {
        items.addAll(items);
    }

    public void printInfo() {
        System.out.printf("Сумка:\n Золото: %d\n", gold);
        if (items.isEmpty()) System.out.println("Нет предметов");
        else {
            for (Item o : items) {
                System.out.println(o.getClass());
            }
        }
        System.out.println();
    }

}
