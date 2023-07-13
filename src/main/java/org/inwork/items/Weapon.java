package org.inwork.items;

public class Weapon {
    private String title;
    private int minAttack;
    private int maxAttack;

    public int getDamage(){
        return minAttack + (int) (Math.random() * (maxAttack - minAttack + 1));
    }

}
