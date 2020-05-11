package ch.cpnv.sit1a;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;

import ch.cpnv.sit1a.models.*;

public class Angry_Bird extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	float w;
	float h;
	Sprite background;
	Bird bird;
	Wasp wasp;
	Sprite slingshotBack;
	Sprite slingshotFront;

	// ------------------------------------------------------------
	// Main methods

	@Override
	public void create () {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		background = new Sprite(new Texture("background.jpg"));
		bird = new Bird(-10,200);
		wasp = new Wasp(100,100);
		slingshotBack = new Sprite(new Texture("slingshot1.png"));
		slingshotFront = new Sprite(new Texture("slingshot2.png"));
		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void render () {
		batch.begin();
		update();
		background.setSize(w, h);
		background.draw(batch);
		slingshotBack.setPosition(200, 220);
		slingshotBack.draw(batch);
		bird.draw(batch);
		slingshotFront.setPosition(200, 220);
		slingshotFront.draw(batch);
		wasp.draw(batch);
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
		bird.move(dt);
	}
	public void reset(){
		bird.reset();
	}

	// ------------------------------------------------------------
	// Inputs

	@Override
	public boolean keyTyped(char character) {
		if(character == 'r')reset();
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		bird.fire();
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(!bird.getmoving()) {
			bird.setPosition(screenX - (bird.getWidth() / 2), h - screenY - (bird.getHeight() / 2));
		}
		return false;
	}

	@Override
	public boolean keyDown(int keycode) { return false; }
	@Override
	public boolean keyUp(int keycode) { return false; }
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
	@Override
	public boolean mouseMoved(int screenX, int screenY) { return false; }
	@Override
	public boolean scrolled(int amount) { return false; }
}
