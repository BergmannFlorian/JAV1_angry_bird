package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

public abstract class TextualObject extends PhysicalObject {
    protected String word;

    public TextualObject(Texture texture, int posX, int posY, float scal) {
        super(texture, posX, posY, scal);
    }

    protected String getWord(){
        return word;
    }
}
