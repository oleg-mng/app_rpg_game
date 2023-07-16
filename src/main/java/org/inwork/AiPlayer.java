package org.inwork;

import org.inwork.items.Armor;
import org.inwork.items.Weapon;
import org.inwork.units.Monster;
import org.inwork.units.Unit;

public class AiPlayer {
    private Game game;
    private Monster monster;

    public Unit getMonster() {
        return monster;
    }

    public AiPlayer(Game game) {
        this.game = game;
        this.monster = new Monster(game, 1,"Scalp", 6, new Weapon("Mace", 1,
                5), new Armor("Rags", 1));
        ;
    }

    public void makeTurn() {
        System.out.println("ход монстра");
        monster.startTurn();
        int monsterAction = (int) (Math.random() * 3) + 1;
        if (monsterAction == 1) monster.attack(game.getPlayer().getHero());
        else if (monsterAction == 2) monster.rest();
        else if (monsterAction == 3) monster.skipTurn();
    }

    private final String[] MONSTER_NAMES_ARRAY = {"Орк", "Гоблин", "Скелет", "Зомби"};
    private final String[] MONSTER_TITLES_ARRAY = {"Дубина", "Топор", "Лук", "Коса"};

    public void checkTeam(int heroLevel) {
        int targetLevel = heroLevel + (int) Math.random() * 3;

        int minWeaponDamage = (int) (1 + Math.random() * targetLevel * 3);
        int maxWeaponDamage = (int) (minWeaponDamage + Math.random() * targetLevel * heroLevel * 4);
        if (!monster.isAlive()) {
            monster = new Monster(game,
                    targetLevel,
                    MONSTER_NAMES_ARRAY[(int) Math.random() * MONSTER_NAMES_ARRAY.length],
                    4 + (int) (Math.random() * 8) + targetLevel * 2,
                    new Weapon(MONSTER_TITLES_ARRAY[(int) Math.random() * MONSTER_TITLES_ARRAY.length],
                            minWeaponDamage, maxWeaponDamage),
                    new Armor("Тряпье", 1));

            System.out.printf("Появляется новый монстр %s", monster.getName());
        }
    }
}

