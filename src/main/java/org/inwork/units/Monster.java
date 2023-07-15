package org.inwork.units;

import org.inwork.Game;
import org.inwork.items.Armor;
import org.inwork.items.Weapon;
import org.inwork.utils.Reward;

import java.util.Collections;

public class Monster extends Unit{
    public Monster(Game game, String name, int hpMax, Weapon weapon, Armor armor) {
        super(game, name, hpMax, weapon, armor);
    }
    public Reward generateReward(){
        return new Reward(1, 1, Collections.emptyList());
    }

}
