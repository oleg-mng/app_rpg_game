package org.inwork.units;

import org.inwork.Game;
import org.inwork.items.Armor;
import org.inwork.items.Weapon;
import org.inwork.utils.Inventory;
import org.inwork.utils.RewardCalculator;

import java.util.Collections;

public class Hero extends Unit {
    private Inventory inventory;
    private int exp = 0;
    private int[] exTo = {0, 1000, 2000, 4000, 8000, 12000, 15000, 1000000};

    public Hero(Game game, String name, int hpMax, Weapon weapon, Armor armor) {
        super(game, name, hpMax, weapon, armor);
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addExp(int amount) {
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

    @Override
    public void attack(Unit target) {
        super.attack(target);
        if (!isAlive()){
            int expReward = RewardCalculator.generateExp(this.level, target.getLevel(), target.getHpMax());
            int goldReward = RewardCalculator.generateGold(target.getHpMax());
            System.out.printf("Герой побкдил монстра и получил награду %d exp %d золота\n", expReward, goldReward);
            addExp(expReward);
            inventory.addGold(goldReward);
            inventory.addItem(Collections.emptyList());
        }
    }
}
