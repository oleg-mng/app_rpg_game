package org.inwork.utils;

import org.inwork.items.Item;

import java.util.List;

public class Reward {
    private int gold;
    private int exp;
    private List<Item> item;

    public Reward(int gold, int exp, List<Item> item) {
        this.gold = gold;
        this.exp = exp;
        this.item = item;
    }
}
