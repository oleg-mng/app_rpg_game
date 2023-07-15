package org.inwork.items;

public class Armor implements Item{
    private String title;
    private int defense;

    public Armor(String title, int defense) {
        this.title = title;
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public String info() {
        return String.format("%s %d", title, defense);
    }
}
