package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;

public class Bird extends MovingObject {

    public Bird(int posX, int posY){
        super(new Texture("bird.png"), posX, posY, -0.5f);
    }

    @Override
    public void accelerate(float dt) {

    }
}
