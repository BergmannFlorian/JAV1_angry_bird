package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

public class Wasp extends MovingObject {

    public Wasp(int posX, int posY) {
        super(new Texture("wasp.png"), posX, posY, -0.8f);
    }

    @Override
    public void accelerate(float dt) {

    }
}
