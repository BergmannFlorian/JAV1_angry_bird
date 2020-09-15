package ch.cpnv.sit1a;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ch.cpnv.sit1a.models.*;

public class Angry_Bird extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	float w;
	float h;
	Bird bird;
	Wasp wasp;
	Scenery scene;
	Slingshot slingshot;
	Board board;

	// ------------------------------------------------------------
	// Main methods

	@Override
	public void create () {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		scene = new Scenery(w, h);
		batch = new SpriteBatch();
		bird = new Bird(200,420);
		slingshot = new Slingshot(bird);
		wasp = new Wasp(200,300);
		board = new Board((int)(w-2000)/2,(int)h-250, 300, 2000);
		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void render () {
		batch.begin();
		update();
		scene.draw(batch);
		board.draw(batch);
		slingshot.drawBack(batch);
		bird.draw(batch);
		slingshot.drawFront(batch);
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
		slingshot.update();
		wasp.move(dt);
		PhysicalObject itemOverlaps = scene.overlaps(bird);
		if(itemOverlaps!=null){
			if(itemOverlaps.getClass() == Tnt.class)board.decreaseScore();
			else if(itemOverlaps.getClass() == Pig.class)board.increaseScore();
			if(itemOverlaps.destructible())scene.removeObject(itemOverlaps);
			reset();
		}
		if(wasp.overlaps(bird))reset();
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
		slingshot.reset();
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(!bird.getmoving() && slingshot.arround(new Vector2(screenX, h - screenY), 400)) {
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
