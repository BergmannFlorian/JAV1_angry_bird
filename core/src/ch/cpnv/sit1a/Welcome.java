package ch.cpnv.sit1a;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.cpnv.sit1a.models.Bird;
import ch.cpnv.sit1a.models.Board;
import ch.cpnv.sit1a.models.Bubble;
import ch.cpnv.sit1a.models.PhysicalObject;
import ch.cpnv.sit1a.models.Pig;
import ch.cpnv.sit1a.models.Scenery;
import ch.cpnv.sit1a.models.Slingshot;
import ch.cpnv.sit1a.models.Tnt;
import ch.cpnv.sit1a.models.Wasp;
import ch.cpnv.sit1a.models.data.Vocabulary;
import ch.cpnv.sit1a.providers.VocProvider;

public class Welcome extends ApplicationAdapter implements InputProcessor{
	private SpriteBatch batch;
	private float w;
	private float h;
	private ArrayList<Sprite> sceneSprite;

	// ------------------------------------------------------------
	// Main methods

	@Override
	public void create () {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		sceneSprite = new ArrayList<Sprite>();

		Sprite background = new Sprite(new Texture("background.jpg"));
		background.setSize(w, h);
		sceneSprite.add(background);

		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void render () {
		batch.begin();
		update();
		for(Sprite sprite : sceneSprite){sprite.draw(batch);}
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
	public boolean keyTyped(char character) { return false; }
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
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
