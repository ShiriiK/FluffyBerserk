package en.fluffyBerserk.game.logic.maps;

public class MapLoader{
    public Map mapToLoad = new Map1();

    public Map loadMapById(int mapId){
        switch (mapId) {
            case 1:
                mapToLoad = new Map1();
                break;
            case 2:
                mapToLoad = new Map2();
                break;
            case 3:
                mapToLoad = new Map3();
                break;
            case 4:
                mapToLoad = new Map4();
                break;
            case 6:
                mapToLoad = new Map6();
                break;
        }
        return mapToLoad;
    }
}
