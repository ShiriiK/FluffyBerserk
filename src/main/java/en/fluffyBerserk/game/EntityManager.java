package en.fluffyBerserk.game;

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

    public List<Entity> getEntities() {
        return entities;
    }
}
