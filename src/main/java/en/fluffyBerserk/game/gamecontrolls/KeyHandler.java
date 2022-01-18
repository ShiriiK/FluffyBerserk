package en.fluffyBerserk.game.gamecontrolls;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.bullets.Bullet;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import en.fluffyBerserk.gui.popups.PopUp;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import en.fluffyBerserk.gui.popups.PopUpPortal;
import en.fluffyBerserk.gui.screens.CharacterScreen;
import en.fluffyBerserk.gui.utils.Collision;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import org.jetbrains.annotations.Nullable;

public class KeyHandler {

    // Reference to the key currently handling moving on axis Y
    private static @Nullable KeyCode moveY = null;

    // Reference to the key currently handling moving on axis X
    private static @Nullable KeyCode moveX = null;

    private static PopUp popUpMenu = new PopUpMenu();

    public static void attachHandlers(Game game, Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    game.getPlayer().setMoveY(-Player.PLAYER_SPEED);
                    moveY = KeyCode.W;
                    break;
                case S:
                    game.getPlayer().setMoveY(Player.PLAYER_SPEED);
                    moveY = KeyCode.S;
                    break;
                case A:
                    game.getPlayer().setMoveX(-Player.PLAYER_SPEED);
                    moveX = KeyCode.A;
                    break;
                case D:
                    game.getPlayer().setMoveX(Player.PLAYER_SPEED);
                    moveX = KeyCode.D;
                    break;
                case ESCAPE:
                    if(!game.getCurrentMap().isForCombat()) {
                        Main.app.showPopUp(popUpMenu);
                        game.getPlayer().setMoveY(0F);
                        game.getPlayer().setMoveX(0F);
                        game.getGameLoop().stop();
                        System.out.println("Game loop stopped");
                    }
                    break;
                case SPACE:
                    if (game.getPlayer().canAttack() && game.getCurrentMap().isForCombat()) {
                        Bullet bullet = new Bullet();
                        switch (game.getPlayer().getDirection()) {
                            case UP:
                                bullet.setMoveY(-Bullet.SPEED);
                                break;
                            case DOWN:
                                bullet.setMoveY(Bullet.SPEED);
                                break;
                            case RIGHT:
                                bullet.setMoveX(Bullet.SPEED);
                                break;
                            case LEFT:
                                bullet.setMoveX(-Bullet.SPEED);
                                break;
                        }
                        bullet.setX(game.getPlayer().getX() + game.getPlayer().getWidth() / 4);
                        bullet.setY(game.getPlayer().getY() + game.getPlayer().getHeight() / 4);
                        game.getEntityManager().addEntity(bullet);
                        game.getPlayer().resetCooldown();
                    }
                    break;
                case E:
                    for (Entity object : game.getCurrentMap().getObjects()) {
                        if (Collision.objectsCollide2(object, game.getPlayer())) {
                            if (object.getType().equals(ObjectType.CLOSET) && Main.app.isUserLoggedIn()) {
                                Main.app.changeScreen(new CharacterScreen(game.getPlayer().getCharacter()));
                                game.getPlayer().setMoveY(0F);
                                game.getPlayer().setMoveX(0F);
                                Main.app.getGame().getGameLoop().stop();
                            } else if (object.getType().equals(ObjectType.PORTAL)) {
                                PopUpPortal portal = new PopUpPortal(game);
                                Main.app.showPopUp(portal);
                                game.getPlayer().setMoveY(0F);
                                game.getPlayer().setMoveX(0F);
                                Main.app.getGame().getGameLoop().stop();
                            }
                        }
                    }
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W:
                case S:
                    if (moveY == event.getCode()) {
                        game.getPlayer().setMoveY(0F);
                        moveY = null;
                    }
                    break;
                case A:
                case D:
                    if (moveX == event.getCode()) {
                        game.getPlayer().setMoveX(0F);
                        moveX = null;
                    }
                    break;
            }
        });
    }
}
