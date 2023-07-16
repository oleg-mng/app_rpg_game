package org.inwork.units;

import org.inwork.Game;
import org.inwork.items.Armor;
import org.inwork.items.Weapon;
import org.inwork.utils.Inventory;

public class Unit {
    Game game;


    int level;
    String name;
    int hp;
    int hpMax;
    Weapon weapon;
    Armor armor;
    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getHpMax() {
        return hpMax;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public Unit(Game game, String name, int hpMax, Weapon weapon, Armor armor) {
        this.game = game;
        this.level = 1;
        this.name = name;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.weapon = weapon;
        this.armor = armor;
    }

    public void attack(Unit target) {
        int actualDamage = target.takeDamage(weapon.getDamage());
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
        System.out.printf("Инфо: Имя:%s(%d) ХП: %d/%d Оружие: %s Броня: %s\n", name, level, hp, hpMax,
                weapon.info(), armor.info());
    }

    public void startTurn() {
        info();
    }

    public void skipTurn() {
        System.out.printf("%s персонаж пропустил свой ход\n", name);
    }

    public int takeDamage(int amount) {
        amount -= armor.getDefense();
        if (amount < 0) amount = 0;
        hp -= amount;
        return amount;
    }
}
