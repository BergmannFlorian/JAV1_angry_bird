package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Scenery {
    private ArrayList<PhysicalObject> sceneObject;
    private ArrayList<Sprite> sceneSprite;

    public Scenery(float width, float height){
        sceneSprite = new ArrayList<Sprite>();
        Sprite background = new Sprite(new Texture("background.jpg"));
        background.setSize(width, height);
        sceneSprite.add(background);

        sceneObject = new ArrayList<PhysicalObject>();
        for(int posX = 500; posX < width; posX += 86){
            PhysicalObject block = new PhysicalObject(new Texture("block.png"), posX, 150, 1);
            sceneObject.add(block);
        }
        for(int posX = 700; posX < width; posX += 300){
            Pig pig = new Pig(posX, -110);
            sceneObject.add(pig);
        }
    }
    public void addObject(PhysicalObject object){
        sceneObject.add(object);
    }
    public void addSprite(PhysicalObject object){ sceneSprite.add(object); }
    public void draw(Batch batch){
        for(Sprite sprite : sceneSprite){sprite.draw(batch);}
        for(PhysicalObject object : sceneObject){object.draw(batch);}
    }
    public boolean overlaps(PhysicalObject object1){
        for(PhysicalObject object2 : sceneObject){
            if(object1.overlaps(object2))return true;
        }
        return false;
    }
}
