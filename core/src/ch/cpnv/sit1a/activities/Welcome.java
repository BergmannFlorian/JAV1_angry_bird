package ch.cpnv.sit1a.activities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import ch.cpnv.sit1a.Angry_Bird;

public class Welcome extends ApplicationAdapter implements InputProcessor{
	private SpriteBatch batch;
	private float w;
	private float h;
	private ArrayList<Sprite> sceneSprite;
	private BitmapFont fontWord;

	// ------------------------------------------------------------
	// Main methods
	public Welcome(){
		create();
	}
	@Override
	public void create () {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		sceneSprite = new ArrayList<Sprite>();

		Sprite background = new Sprite(new Texture("background.jpg"));
		background.setSize(w, h);
		sceneSprite.add(background);

		fontWord = new BitmapFont();
		fontWord.setColor(Color.BLACK);
		fontWord.getData().setScale(20);

		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void render () {
		batch.begin();
		update();
		for(Sprite sprite : sceneSprite){sprite.draw(batch);}
		fontWord.draw(batch, "Welcome", w/4, h/2);
		batch.end();
	}
	@Override
	public void dispose () {
		batch.dispose();
	}

	// ------------------------------------------------------------
	// Methods

	public void update(){
		float dt = Gdx.graphics.getDeltaTime();
	}

	// ------------------------------------------------------------
	// Inputs

	@Override
	public boolean keyTyped(char character) {
		if(character == 'p') Angry_Bird.changeActivity(Angry_Bird.activities.play);
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Angry_Bird.changeActivity(Angry_Bird.activities.play);
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
	@Override
	public boolean keyDown(int keycode) { return false; }
	@Override
	public boolean keyUp(int keycode) { return false; }
	@Override
	public boolean mouseMoved(int screenX, int screenY) { return false; }
	@Override
	public boolean scrolled(int amount) { return false; }
}
