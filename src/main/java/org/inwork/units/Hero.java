package org.inwork.units;

import org.inwork.Game;

public class Hero extends Unit {
    private int exp = 0;
    private int[] exTo = {0, 1000, 2000, 4000, 8000, 12000, 15000, 1000000};

    public Hero(Game game, String name, int hpMax, int attack, int defence) {
        super(game, name, hpMax, attack, defence);
    }

    public void levelExp(int amount) {
        exp += amount;
        while (exp >= exTo[level]) {
            levelUp();
            exp -=exTo[level];
        }

    }

    public void levelUp() {
        level++;
        System.out.printf("Персонаж %s повысил свой уровень до %d", name, level);
        hpMax = level * 2 - 1;
        hp = hpMax;
    }
}
