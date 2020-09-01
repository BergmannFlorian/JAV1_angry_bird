package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.awt.Point;

public class Bird extends MovingObject {
    private float v0 = 0;
    private float angle = 0;
    private float time = 0;
    private boolean moving = false;
    private int originX;
    private int originY;
    MathUtils math;

    public Bird(int posX, int posY){
        super(new Texture("bird.png"), posX, posY, 0.2f);
        originX = posX;
        originY = posY;
    }

    @Override
    public void accelerate(float dt) {

    }

    @Override
    public void move(float dt) {
        if(moving){
            time += dt;
            this.translate(this.Vx(), this.Vy(time));
            if(this.getY() < -500)this.reset();
        }
    }

    public void fire(){
        if(!moving){
            double theta = 180.0 / Math.PI * Math.atan2(originX - this.getX(), originY - this.getY());
            this.angle = (float) (90-theta);
            double dist = Math.hypot(Math.abs(originX - this.getX()), Math.abs(originY-this.getY()));
            this.v0 = (float) (dist/15);
            this.moving = true;
        }
    }

    public void reset(){
        this.moving = false;
        this.setPosition(originX, originY);
        this.time = 0;
    }

    private float Vx(){
        return v0*math.cosDeg(angle);
    }
    private float Vy(float t){
        return v0*math.sinDeg(angle)-10*t;
    }

    public boolean getmoving(){ return moving; }
    public Vector2 getOrigin(){ return new Vector2(originX, originY); }
}
