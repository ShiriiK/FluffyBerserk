package en.fluffyBerserk.logic;

import en.fluffyBerserk.gui.utils.Observer;
import en.fluffyBerserk.gui.utils.SubjectOfChange;

import java.util.HashSet;
import java.util.Set;

public class GameState implements SubjectOfChange {
    private final Inventory inventory;
    private final Set<Observer> observers = new HashSet<>();

    public GameState(){
        inventory = new Inventory();
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
