package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

import ch.cpnv.sit1a.models.data.SemanticWord;
import ch.cpnv.sit1a.models.data.Word;

public abstract class TextualObject extends PhysicalObject {
    protected SemanticWord word;

    public TextualObject(Texture texture, int posX, int posY, float scal, SemanticWord word) {
        super(texture, posX, posY, scal);
        this.word = word;
    }

    protected SemanticWord getWord(){
        return word;
    }
}
