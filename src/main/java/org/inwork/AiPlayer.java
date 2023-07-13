package org.inwork;

import org.inwork.units.Unit;

public class AiPlayer {
    private Game game;
    private Unit monster;

    public Unit getMonster() {
        return monster;
    }

    public AiPlayer(Game game) {
        this.game = game;
        this.monster = new Unit(game, "Scalp", 6, 4, 0);;
    }

    public void makeTurn() {
        System.out.println("ход монстра");
        monster.startTurn();
        int monsterAction = (int) (Math.random() * 3) + 1;
        if (monsterAction == 1) monster.attack(game.getPlayer().getHero());
        else if (monsterAction == 2) monster.rest();
        else if (monsterAction == 3) monster.skipTurn();
    }
}

