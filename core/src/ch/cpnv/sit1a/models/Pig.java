package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

import ch.cpnv.sit1a.models.data.Word;

public class Pig extends TextualObject {
    private int points;
    private Word word;

    public Pig(int posX, int posY, Word word) {
        super(new Texture("pig.png"), posX, posY, 0.15f, word.getValue2());
        this.word = word;
    }

    public void sayWord(){

    }
    public Word getWord(){return word;}
}
