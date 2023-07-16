package org.inwork.units;

import org.inwork.Game;
import org.inwork.items.Armor;
import org.inwork.items.Weapon;

public class Monster extends Unit{
    public Monster(Game game, int level, String name, int hpMax, Weapon weapon, Armor armor) {
        super(game, name, hpMax, weapon, armor);
        this.level = level;
    }

}
