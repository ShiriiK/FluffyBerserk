package en.fluffyBerserk.gui.animations;

import en.fluffyBerserk.gui.utils.LocateImage;

/**
 * Class for keeping and managing existing sprites
 */
public class SpritesFactory {

    public static LocateImage fluf1 = new LocateImage("player/fluf1.png",0);
    public static LocateImage fluf2 = new LocateImage("player/fluf2.png",1);
    public static LocateImage fluf3 = new LocateImage("player/fluf3.png",2);
    public static LocateImage fluf4 = new LocateImage("player/fluf4.png",3);
    public static LocateImage fluf5 = new LocateImage("player/fluf5.png",4);
    public static LocateImage fluf6 = new LocateImage("player/fluf6.png",5);
    public static LocateImage fluf7 = new LocateImage("player/fluf7.png",6);
    public static LocateImage fluf8 = new LocateImage("player/fluf8.png",7);
    public static LocateImage fluf9 = new LocateImage("player/fluf9.png",8);
    public static LocateImage fluf10 = new LocateImage("player/fluf10.png",9);
    public static LocateImage fluf11 = new LocateImage("player/fluf11.png",10);
    public static LocateImage fluf12 = new LocateImage("player/fluf12.png",11);
    public static LocateImage fluf13 = new LocateImage("player/fluf13.png",12);

    public static LocateImage grass = new LocateImage("tiles/grass.png",13);


    public static LocateImage enemy1 = new LocateImage("npcs/enemy1.png",30);

    public static LocateImage[] skin = new LocateImage[14];
    public static LocateImage[] getImages() {
        skin[0] = fluf1;
        skin[1] = fluf2;
        skin[2] = fluf3;
        skin[3] = fluf4;
        skin[4] = fluf5;
        skin[5] = fluf6;
        skin[6] = fluf7;
        skin[7] = fluf8;
        skin[8] = fluf9;
        skin[9] = fluf10;
        skin[10] = fluf11;
        skin[11] = fluf12;
        skin[12] = fluf13;
        skin[13] = enemy1;
        return skin;
    }
}
