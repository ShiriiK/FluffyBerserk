package en.fluffyBerserk.logic;

import en.fluffyBerserk.gui.utils.Observer;
import en.fluffyBerserk.gui.utils.SubjectOfChange;
import en.fluffyBerserk.logic.objects.creatures.player.Player;

import java.util.HashSet;
import java.util.Set;

public class GameState implements SubjectOfChange {
    private final Inventory inventory;
    private final Player player;
    private final Set<Observer> observers = new HashSet<>();

    public GameState(){
        player = new Player(null);
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
