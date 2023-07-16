package org.inwork;

import org.inwork.units.Unit;

import java.util.Random;

public class Game {
    private Player player;
    private AiPlayer aiPlayer;
    private InputSystem inputSystem;

    public Player getPlayer() {
        return player;
    }

    public AiPlayer getAiPlayer() {
        return aiPlayer;
    }

    public InputSystem getInputSystem() {
        return inputSystem;
    }

    public void init() {
        inputSystem = new InputSystem();
        player = new Player(this);
        aiPlayer = new AiPlayer(this);
    }

    public void start() {
        System.out.println("Игра началась");
        player.getHero().info();
        aiPlayer.getMonster().info();
        while (true) {
            player.makeTurn();
            aiPlayer.checkTeam(player.getHero().getLevel());
            if(isGameAnd()) break;

            aiPlayer.makeTurn();
            if(isGameAnd()) break;

        }
    }
    public boolean isGameAnd(){
        if(!player.getHero().isAlive() && !aiPlayer.getMonster().isAlive()) {
            System.out.println("Ничья. Игра завершена");
            return true;
        }

        if(!aiPlayer.getMonster().isAlive()) {
            System.out.println("Игрок победил. Игра завершена");
            return true;
        }

        if(!player.getHero().isAlive()) {
            System.out.println("Монстры победили. Игра завершена");
            return true;
        }

        return false;

    }
}
