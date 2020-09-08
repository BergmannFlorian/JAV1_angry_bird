package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Board extends Sprite {
    public Board(int posX, int posY){
        super(new Texture("panel.png"));
        setPosition(posX, posY);
    }
    public Board(int posX, int posY, int height, int width){
        super(new Texture("panel.png"));
        setPosition(posX, posY);
        setSize((float)width, (float)height);
    }
}
