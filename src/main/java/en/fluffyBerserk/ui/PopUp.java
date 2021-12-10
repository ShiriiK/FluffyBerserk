package main.java.en.fluffyBerserk.ui;

import javafx.scene.Node;

public interface PopUp {

    public void setSize(int width, int height);

    public void setPosition(int x, int y);

    public Node popUp();

    public void close();

    public void show();

}
