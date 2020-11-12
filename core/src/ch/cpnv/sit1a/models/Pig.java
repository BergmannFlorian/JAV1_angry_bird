package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import ch.cpnv.sit1a.customException.TranslationNotExistException;
import ch.cpnv.sit1a.models.data.SemanticWord;
import ch.cpnv.sit1a.models.data.Word;

public class Pig extends TextualObject {
    private int points;
    private SemanticWord word;
    private Bubble bubble=null;

    public Pig(int posX, int posY, SemanticWord word) {
        super(new Texture("pig.png"), posX, posY, 0.15f, word);
        this.word = word;
    }

    public Bubble showOrHiddeBubble() throws TranslationNotExistException {
        bubble= bubble == null ? new Bubble(this) : null;
        return bubble;
    }
    public SemanticWord getWord(){return word;}
    public Bubble getBubble(){return bubble;}
}
