package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

import javax.xml.datatype.Duration;

public class Bubble extends TextualObject {
    private Duration duration;

    public Bubble(int posX, int posY) {
        super(new Texture("bubble.png"), posX, posY, 1, "?");
    }
}
