package ch.cpnv.sit1a.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import javax.xml.datatype.Duration;

import ch.cpnv.sit1a.models.data.Word;

public class Bubble extends TextualObject {
    private Duration duration;
    private BitmapFont font;
    private GlyphLayout glyph;

    public Bubble(Pig pig) {
        super(new Texture("bubble.png"), (int)pig.getX(), (int)(pig.getY()+pig.getHeight()), 1, pig.getWord());
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(3);
        glyph = new GlyphLayout(font, word.getValue1());
        this.setSize((float)(glyph.width*1.5), glyph.height*4);
        this.setX(this.getX()-(this.getWidth()/2));
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        font.draw(batch, glyph, this.getX()+(this.getWidth()/6),(float) (this.getY()+(this.getHeight()/1.4)));
    }
}
