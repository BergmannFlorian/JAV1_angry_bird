package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Board extends Sprite {
    private String word = "Test";
    private int score = 0;
    private BitmapFont fontWord, fontScore;

    public Board(int posX, int posY, int height, int width){
        super(new Texture("panel.png"));
        setPosition(posX, posY);
        setSize((float)width, (float)height);

        fontWord = new BitmapFont();
        fontWord.setColor(Color.BLACK);
        fontWord.getData().setScale(5);

        fontScore = new BitmapFont();
        fontScore.setColor(Color.BLACK);
        fontScore.getData().setScale(5);
    }

    public void decreaseScore(){ score--; }
    public void increaseScore(){ score++; }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        fontWord.draw(batch, word, this.getX()+(this.getWidth()/6),this.getY()+(this.getHeight()/2));
        fontScore.draw(batch, "Score : "+score, this.getX()+(this.getWidth()*3/4),this.getY()+(this.getHeight()/2));
    }
}
