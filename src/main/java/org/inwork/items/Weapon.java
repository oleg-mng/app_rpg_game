package org.inwork.items;

public class Weapon implements Item{
    private String title;
    private int minDamage;
    private int maxDamage;

    public Weapon(String title){
        this.title = title;
    }

    public Weapon(String title, int minDamage, int maxDamage) {
        this.title = title;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }


    public int getDamage(){
        return minDamage + (int) (Math.random() * (maxDamage - minDamage + 1));
    }


    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
    public String info() {
        return String.format("%s [%d-%d]", title, minDamage, maxDamage);
    }

    @Override
    public String getTitle() {
        return title;
    }
}
