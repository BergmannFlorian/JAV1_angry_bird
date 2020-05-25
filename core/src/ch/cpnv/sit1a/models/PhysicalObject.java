package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class PhysicalObject extends Sprite {
    public PhysicalObject(Texture texture, int posX, int posY, float scal){
        super(texture);
        this.setScale(scal);
        setPosition(posX, posY);
    }
    public boolean overlaps(PhysicalObject object){
        return Intersector.overlaps(this.getBoundingRectangle(), object.getBoundingRectangle());
    }
    public Vector2 getCenter(){
        return new Vector2(this.getX()+(this.getWidth()/2), this.getY()+(this.getHeight()/2));
    }
}
