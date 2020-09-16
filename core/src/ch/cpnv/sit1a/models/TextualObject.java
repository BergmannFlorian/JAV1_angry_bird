package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

import ch.cpnv.sit1a.models.data.Word;

public abstract class TextualObject extends PhysicalObject {
    protected Word word;

    public TextualObject(Texture texture, int posX, int posY, float scal, Word word) {
        super(texture, posX, posY, scal);
        this.word = word;
    }

    protected Word getWord(){
        return word;
    }
}
