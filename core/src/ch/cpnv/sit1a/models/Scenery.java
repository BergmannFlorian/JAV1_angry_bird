package ch.cpnv.sit1a.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.cpnv.sit1a.customException.OutOfSceneryException;
import ch.cpnv.sit1a.models.data.Vocabulary;

public class Scenery {
    private ArrayList<PhysicalObject> sceneObject;
    private ArrayList<Sprite> sceneSprite;
    private float maxWidth = Gdx.graphics.getWidth();
    private float maxHeight = Gdx.graphics.getHeight();

    public Scenery(float width, float height, Vocabulary voc) {
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
        //Tnt
        for(int i = 0; i < 5 ; i++){
            Tnt tnt = new Tnt(MathUtils.random(500, (int)width-100), 150);
            moveUpToOverlaps(tnt);
            addObject(tnt);
        }
        //Pig
        for(int i = 0; i < 10 ; i++){
            Pig pig = new Pig(MathUtils.random(500, (int)width-100), 150, voc.pickAWord());
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
    public void removeObject(PhysicalObject object){
        sceneObject.remove(object);
    }
    public void addSprite(PhysicalObject object){ sceneSprite.add(object); }
    public void draw(Batch batch){
        for(Sprite sprite : sceneSprite){sprite.draw(batch);}
        for(PhysicalObject object : sceneObject){object.draw(batch);}
    }
    public PhysicalObject overlaps(PhysicalObject object1){
        for(PhysicalObject object2 : sceneObject){
            if(object1.overlaps(object2)) return object2;
        }
        return null;

    }
    public PhysicalObject touch(Vector2 point){
        for(PhysicalObject object : sceneObject){
            if(object.touch(point)) return object;
        }
        return null;
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
    public int countPig(){
        int count = 0;
        for(PhysicalObject object : sceneObject){
            if(object.getClass() == Pig.class)count++;
        }
        return count;
    }
    public Pig getAPig(){
        if(countPig()==0)return null;
        PhysicalObject pig;
        do {
            pig = sceneObject.get(MathUtils.random(0, sceneObject.size()-1));
        }while (pig.getClass() != Pig.class);
        return (Pig)pig;
    }
}
