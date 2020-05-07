package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PhysicalObject extends Sprite {
    public PhysicalObject(Texture texture, int posX, int posY, float scal){
        super(texture);
        scale(scal);
        setPosition(posX, posY);
    }
}
