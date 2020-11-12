package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.sit1a.Angry_Bird;
import ch.cpnv.sit1a.customException.TranslationNotExistException;
import ch.cpnv.sit1a.models.data.SemanticWord;
import ch.cpnv.sit1a.models.data.Word;

public class Board extends Sprite {
    private SemanticWord word;
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
    public void setWord(SemanticWord word){this.word = word;}
    public SemanticWord getWord(){return word;}
    public Integer getScore(){return score;}

    public void decreaseScore(){ score--; }
    public void decreaseScore(int decrease){ score-=decrease; }
    public void increaseScore(){ score++; }
    public void increaseScore(int increase){ score+=increase; }

    public void reset(){
        score = 0;
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        try {
            fontWord.draw(batch, word.getValue(Angry_Bird.getLangFrom()), this.getX()+(this.getWidth()/6),this.getY()+(this.getHeight()/2));
        } catch (TranslationNotExistException e) {
            e.printStackTrace();
        }
        fontScore.draw(batch, "Score : "+score, this.getX()+(this.getWidth()*3/4),this.getY()+(this.getHeight()/2));
    }
}
