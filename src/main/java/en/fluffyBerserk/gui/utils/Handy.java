package en.fluffyBerserk.gui.utils;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.persistence.models.Character;

public class Handy {

    public static void backToGame(){
        Game game = Main.app.getGame();
        Main.app.changeScreen(Main.app.getGame().gameScreen);
        game.getGameLoop().start();
        game.getPlayer().refreshSprite();
        System.out.println("Back in same game");
    }
}
