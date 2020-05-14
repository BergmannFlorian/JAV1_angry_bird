package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

public class Pig extends TextualObject {
    private int points;

    public Pig(int posX, int posY) {
        super(new Texture("pig.png"), posX, posY, 0.15f);
    }

    public void sayWord(){

    }
}
