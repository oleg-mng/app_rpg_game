package org.inwork.units;

import org.inwork.Game;

public class Unit {
    Game game;
    int level;
    String name;
    int hp;
    int hpMax;
    int attack;
    int defence;

    public boolean isAlive() {
        return hp > 0;
    }

    public Unit(Game game, String name, int hpMax, int attack, int defence) {
        this.game = game;
        this.level = 1;
        this.name = name;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.attack = attack;
        this.defence = defence;
    }

    public void attack(Unit target) {
        int actualDamage = target.takeDamage(attack);
        System.out.printf("%s персонаж нанес урон %s %d единиц урона\n", name, target.name, actualDamage);
        target.info();
    }

    public void rest() {
        heal(2);
    }

    public void heal(int amount) {
        if (hp + amount > hpMax) amount = hpMax - hp;
        System.out.printf("%s персонаж восстановил %d единиц здоровья\n", name, amount);
        info();
    }

    public void info() {
        System.out.printf("Инфо: Имя:%s(%d) ХП: %d/%d атака: %d защита: %d\n", name, level, hp, hpMax, attack, defence);
    }

    public void startTurn() {
        info();
    }

    public void skipTurn() {
        System.out.printf("%s персонаж пропустил свой ход\n", name);
    }

    public int takeDamage(int amount) {
        amount -= defence;
        if (amount < 0) amount = 0;
        hp -= amount;
        return amount;
    }
}
