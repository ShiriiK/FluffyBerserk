package en.fluffyBerserk.game.gamecontrolls;

import en.fluffyBerserk.game.logic.objects.Entity;

import java.util.ArrayList;
import java.util.List;

public final class EntityManager {

    private final List<Entity> entities = new ArrayList<>();

    public boolean addEntity(Entity entity) {
        return entities.add(entity);
    }

    public boolean removeEntity(Entity entity) {
        return entities.remove(entity);
    }

    public void removeAll() {
        entities.clear();
    }

    public void addEntites(ArrayList<Entity> mapsEntities){ entities.addAll(mapsEntities);}

    public void removeEntites(ArrayList<Entity> mapsEntities){entities.removeAll(mapsEntities);}

    public List<Entity> getEntities() {
        return entities;
    }
}
