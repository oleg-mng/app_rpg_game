package org.inwork;

import org.inwork.items.Armor;
import org.inwork.items.Weapon;
import org.inwork.units.Hero;
import org.inwork.units.Unit;

public class Player {
    private Game game;
    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public Player(Game game) {
        this.game = game;
        this.hero = new Hero(game, "Spartacus", 10, new Weapon("Mini-gun",
                1, 4), new Armor("quilted vest", 2));;
    }

    public void makeTurn() {
        System.out.println("ход игрока");
        hero.startTurn();
        int heroAction = game.getInputSystem().select("1.Атаковать 2.Отдохнуть 3.Пропустить ход", 1, 3);
        if (heroAction == 1) hero.attack(game.getAiPlayer().getMonster());
        else if (heroAction == 2) hero.rest();
        else if (heroAction == 3) hero.skipTurn();

    }
}
