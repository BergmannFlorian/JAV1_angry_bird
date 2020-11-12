package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import org.omg.CORBA.PUBLIC_MEMBER;

import ch.cpnv.sit1a.models.data.Word;

public class Button extends PhysicalObject {
    private BitmapFont fontWord;
    private String text;
    private String value;

    public Button(int posX, int posY, float scal, String text, String value){
        super(new Texture("button.png"), posX, posY, scal);

        this.text = text;
        this.value = value;

        fontWord = new BitmapFont();
        fontWord.setColor(Color.WHITE);
        fontWord.getData().setScale(5);
    }

    public String getValue(){ return value; }
    public String getText(){ return text; }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        fontWord.draw(batch, text, this.getX()+10,this.getY()+80);
    }
}
