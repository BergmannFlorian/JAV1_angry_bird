package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import ch.cpnv.sit1a.models.data.Word;

public class Pig extends TextualObject {
    private int points;
    private Word word;
    private Bubble bubble=null;

    public Pig(int posX, int posY, Word word) {
        super(new Texture("pig.png"), posX, posY, 0.15f, word);
        this.word = word;
    }

    public Bubble showOrHiddeBubble(){
        bubble= bubble == null ? new Bubble(this) : null;
        return bubble;
    }
    public Word getWord(){return word;}
    public Bubble getBubble(){return bubble;}
}
