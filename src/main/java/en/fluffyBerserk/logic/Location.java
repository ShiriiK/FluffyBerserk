package en.fluffyBerserk.logic;

import en.fluffyBerserk.logic.objects.creatures.Creature;
import en.fluffyBerserk.logic.objects.items.Item;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Instances of this class represent particular locations.
 */

public class Location{
    private final String name;
    private final Set<Location> exits;
    private final Set<Item> items;
    private final Set<Creature> npcs;
    private final int phase;

    // Constructor
    public Location(String name, int phase){
        this.name = name;
        this.phase = phase;
        exits = new HashSet<>();
        items = new HashSet<>();
        npcs = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Identifies if location is available
     * @return phase
     */
    public int getPhase() {
        return phase;
    }

    /**
     * Adds npcs to location
     * @param npcs npcs that will be added to location
     */
    public void addNpcs(Collection<Creature> npcs){
        npcs.addAll(npcs);
    }

    /**
     * @param npcName name of npc
     * @return npc based on its name
     */
    public Creature getNpc(String npcName){
        for(Creature currnet : npcs){
            if(currnet.getName().equals(npcName)){
                return currnet;
            }
        }
        return null;
    }

    /**
     * Removes npc from location
     * @param npcName name of npc
     */
    public void removeNpc(String npcName){
        for(Creature current : npcs){
            if(current.getName().equals(npcName)){
                npcs.remove(current);
                break;
            }
        }
    }

    /**
     * Adds exits to location
     * @param locations locations to which is desired location connected to
     */
    public void addExits(Collection<Location> locations){
        exits.addAll(locations);
    }

    /**
     * @param exitName name of location
     * @return location based on its name
     */
    public Location getExit(String exitName){
        for (Location current : exits) {
            if (current.getName().equals(exitName)) {
                return current;
            }
        }
        return null;
    }

    /**
     * Adds items to location
     * @param items item
     */
    public void addItems(Collection<Item> items) {
        items.addAll(items);
    }

    /**
     * @param itemName name of item
     * @return item based on its name
     */
    public Item getItem(String itemName) {
        for (Item current : items) {
            if (current.getName().equals(name)) {
                return current;
            }
        }
        return null;
    }

    /**
     * Removes item from location
     * @param itemName name of item
     */
    public void removeItem(String itemName) {
        for (Item current : items) {
            if (current.getName().equals(itemName)) { //TODO - prevent the removal of items that are not pickable
                items.remove(current);
                break;
            }
        }
    }

    /**
     * @return collection of all npcs in the location
     */
    public Set<Creature> getNpcs() {
        return new HashSet<>(npcs);
    }

    /**
     * @return collection of all exits leading from location
     */
    public Set<Location> getExits() {
        return new HashSet<>(exits);
    }

    /**
     * @return collection of all items in the location.
     */
    public Set<Item> getItems() {
        return new HashSet<>(items);
    }

}
