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
        this.hero = new Hero(game, "Spartacus", 20, new Weapon("Mini-gun",
                1, 8), new Armor("quilted vest", 2));;
    }

    public void makeTurn() {
        System.out.println("ход игрока");
        hero.startTurn();
        while (true) {
            int heroAction = game.getInputSystem().select("Выберите действие: \n1.Атаковать \n2.Отдохнуть " +
                    "\n3.Пропустить ход \n4.Посмотреть сумку", 1, 4);
            if (heroAction == 1) {
                hero.attack(game.getAiPlayer().getMonster());
                break;
            }
            else if (heroAction == 2) {
                hero.rest();
                break;
            }
            else if (heroAction == 3) {
                hero.skipTurn();
                break;
            }
            else if (heroAction == 4) {
                System.out.println("4");
                hero.getInventory().printInfo();

            }
        }

    }
}
