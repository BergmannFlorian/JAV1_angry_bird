package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Slingshot extends Sprite {
    Bird bird;
    Sprite slingshotBack;
    Sprite slingshotFront;
    Sprite rubberBack;
    Sprite rubberFront;

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
        rubberFront.setSize(30, 0);
        rubberBack.setSize(30, 0);
    }
    public void update(){
        if(!bird.getmoving()){
            double theta = 180.0 / Math.PI * Math.atan2(bird.getX() - this.getX(), bird.getY() - this.getY());
            rubberBack.setRotation((float) (theta));
            double dist = Math.hypot(Math.abs(bird.getX() - this.getX()), Math.abs(bird.getOriginY() - this.getY()));
            rubberFront.setRegionHeight((int) dist);
            rubberBack.setSize(30, (float) dist);
        }
    }
    public void drawBack(Batch batch){
        slingshotBack.draw(batch);
        rubberBack.draw(batch);
    }
    public void drawFront(Batch batch){
        rubberFront.draw(batch);
        slingshotFront.draw(batch);
    }
}
