package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class Slingshot extends Sprite {
    Bird bird;
    Sprite slingshotBack;
    Sprite slingshotFront;
    Sprite rubberBack;
    Sprite rubberFront;
    Vector2 origin;

    public Slingshot(Bird bird){
        this.bird = bird;
        slingshotBack = new Sprite(new Texture("slingshot1.png"));
        slingshotFront = new Sprite(new Texture("slingshot2.png"));
        rubberBack = new Sprite(new Texture("rubber.png"));
        rubberFront = new Sprite(new Texture("rubber.png"));
        slingshotBack.setPosition(bird.getCenter().x-50, bird.getCenter().y-250);
        slingshotFront.setPosition(bird.getCenter().x-50, bird.getCenter().y-250);
        rubberBack.setPosition(bird.getCenter().x+30, bird.getCenter().y);
        rubberFront.setPosition(bird.getCenter().x-30, bird.getCenter().y);
        origin = new Vector2(bird.getCenter().x, bird.getCenter().y);
        rubberFront.setSize(0, 0);
        rubberBack.setSize(0, 0);
    }
    public void update(){
        if(!bird.getmoving()){
            Vector2 vector = bird.getCenter().sub(origin);
            updateRubber(rubberBack, vector, 30);
            updateRubber(rubberFront, vector, -30);
        }
    }
    public void updateRubber(Sprite rubber, Vector2 vector, int decalX){
        rubber.setBounds(origin.x+decalX, origin.y, vector.len(), 20);
        rubber.setOrigin(0,0);
        rubber.setRotation((vector.angle()));
    }
    public void drawBack(Batch batch){
        slingshotBack.draw(batch);
        rubberBack.draw(batch);
    }
    public void drawFront(Batch batch){
        rubberFront.draw(batch);
        slingshotFront.draw(batch);
    }
    public boolean arround(Vector2 point, int radius){
        return origin.dst(point) < radius;
    }
    public void reset(){
        rubberFront.setSize(0, 0);
        rubberBack.setSize(0, 0);
    }
}
