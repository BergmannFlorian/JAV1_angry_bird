package ch.cpnv.sit1a.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

import ch.cpnv.sit1a.customException.OutOfSceneryException;

public class Scenery {
    private ArrayList<PhysicalObject> sceneObject;
    private ArrayList<Sprite> sceneSprite;
    float maxWidth = Gdx.graphics.getWidth();
    float maxHeight = Gdx.graphics.getHeight();

    public Scenery(float width, float height) {
        sceneSprite = new ArrayList<Sprite>();
        Sprite background = new Sprite(new Texture("background.jpg"));
        background.setSize(width, height);
        sceneSprite.add(background);

        sceneObject = new ArrayList<PhysicalObject>();
        //Ground
        for(int posX = 500; posX < width; posX += 86){
            PhysicalObject block = new PhysicalObject(new Texture("block.png"), posX, 150, 1);
            block.setdestructible(false);
            addObject(block);
        }
        //Block Pile
        for(int i = 0; i < 20 ; i++){
            PhysicalObject block = new PhysicalObject(new Texture("block.png"), MathUtils.random(500, (int)width), 150, 1);
            moveUpToOverlaps(block);
            addObject(block);
        }
        //Pig
        for(int posX = 700; posX < width; posX += 300){
            Pig pig = new Pig(posX, -110);
            moveUpToOverlaps(pig);
            addObject(pig);
        }
    }
    public void addObject(PhysicalObject object){
        try{
            if(object.getX()<0 || object.getX()>maxWidth || object.getY()<0 || object.getY()>maxHeight)throw new OutOfSceneryException("Pig out of scenery");
            sceneObject.add(object);
        }catch(OutOfSceneryException e){
            Gdx.app.log("OutOfSceneryException", e.getMessage());
        }
    }
    public void addSprite(PhysicalObject object){ sceneSprite.add(object); }
    public void draw(Batch batch){
        for(Sprite sprite : sceneSprite){sprite.draw(batch);}
        for(PhysicalObject object : sceneObject){object.draw(batch);}
    }
    public boolean overlaps(PhysicalObject object1, Board board){
        for(PhysicalObject object2 : sceneObject){
            if(object1.overlaps(object2)){
                if(object2.destructible()) {
                    if(object2.getClass() == Tnt.class)board.decreaseScore();
                    else if(object2.getClass() == Pig.class)board.increaseScore();
                    sceneObject.remove(object2);
                }
                return true;
            }
        }
        return false;
    }
    public void moveUpToOverlaps(PhysicalObject object1){
        boolean overlaps;
        do{
            overlaps = false;
            for(PhysicalObject object2 : sceneObject){
                if(object1.overlaps(object2)){
                    overlaps = true;
                    object1.translateY(object2.getHeight());
                }
            }
        }while(overlaps);
    }
}
