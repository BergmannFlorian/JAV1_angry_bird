package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class Wasp extends MovingObject {
    long startTime = TimeUtils.millis();
    public Wasp(int posX, int posY) {
        super(new Texture("wasp.png"), posX, posY, 0.2f);
    }

    @Override
    public void accelerate(float dt) {

    }

    @Override
    public void move(float dt) {
        long globalCounter = TimeUtils.timeSinceMillis(startTime);
        Vector2 cycleLength = new Vector2(1500,300);
        Vector2 cycleScale = new Vector2(900, 300);
        Vector2 centerPos = new Vector2(900, 800);
        float x = (float) Math.sin(globalCounter/cycleLength.x)*cycleScale.x + centerPos.x;
        float y = (float) Math.cos(globalCounter/cycleLength.y)*cycleScale.y + centerPos.y;
        this.setPosition(x, y);
    }
}
