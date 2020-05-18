package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;

import java.util.ArrayList;

public class Scenery {
    private ArrayList<PhysicalObject> sceneObject;
    private ArrayList<Sprite> sceneSprite;

    public Scenery(float width, float height){
        sceneSprite = new ArrayList<Sprite>();
        Sprite background = new Sprite(new Texture("background.jpg"));
        Sprite slingshotBack = new Sprite(new Texture("slingshot1.png"));
        Sprite slingshotFront = new Sprite(new Texture("slingshot2.png"));
        background.setSize(width, height);
        slingshotBack.setPosition(200, 220);
        slingshotFront.setPosition(200, 220);
        sceneSprite.add(background);
        sceneSprite.add(slingshotBack);
        sceneSprite.add(slingshotFront);

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
    public void addElement(PhysicalObject object){
        sceneObject.add(object);
    }
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
