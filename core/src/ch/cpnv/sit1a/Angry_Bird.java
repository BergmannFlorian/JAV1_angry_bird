package ch.cpnv.sit1a;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.cpnv.sit1a.models.*;

public class Angry_Bird extends ApplicationAdapter {
	MathUtils math;
	SpriteBatch batch;
	Texture background;
	Bird bird;
	Wasp wasp;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.jpg");
		bird = new Bird(500,500);
		wasp = new Wasp(100,100);
	}

	@Override
	public void render () {
		update();
		batch.begin();
		batch.draw(background, 0, 0);
		bird.draw(batch);
		wasp.draw(batch);
		batch.end();
	}

	public void update(){
		wasp.translate(math.random(-20, 20), math.random(-20, 20));
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
