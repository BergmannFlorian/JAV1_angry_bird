package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingObject extends PhysicalObject {
    public Vector2 speed;
    protected int x;
    protected int y;

    public MovingObject(Texture texture, int posX, int posY, float scal){
        super(texture, posX, posY, scal);
    }

    public void move(float dt){

    }
    public abstract void accelerate(float dt);
}
