package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

public class Tnt extends PhysicalObject {
    private int negativePoints;

    public Tnt(int posX, int posY) {
        super(new Texture("tnt.png"), posX, posY, 1);
    }
}
