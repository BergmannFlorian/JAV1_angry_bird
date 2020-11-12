package ch.cpnv.sit1a.activities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.cpnv.sit1a.Angry_Bird;
import ch.cpnv.sit1a.customException.TranslationNotExistException;
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

public class Play extends ApplicationAdapter implements InputProcessor{
	private SpriteBatch batch;
	private float w;
	private float h;
	private Bird bird;
	private Wasp wasp;
	private Scenery scene;
	private Slingshot slingshot;
	private Board board;
	private VocProvider vocSource = VocProvider.getInstance();
	private Vocabulary voc;
	private ArrayList<Pig> pigBubble;

	// ------------------------------------------------------------
	// Main methods
	public Play(){
		create();
	}
	@Override
	public void create () {
		voc = vocSource.pickAVoc();
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		pigBubble = new ArrayList<Pig>();
		scene = new Scenery(w, h, voc);
		batch = new SpriteBatch();
		bird = new Bird(200,420);
		slingshot = new Slingshot(bird);
		wasp = new Wasp(200,300);
		board = new Board((int)(w-2000)/2,(int)h-250, 300, 2000);
		board.setWord(scene.getAPig().getWord());
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
		for (Pig pig : pigBubble) {
			pig.getBubble().draw(batch);
		}
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
			System.out.println(itemOverlaps.getClass());
			if(itemOverlaps.destructible())scene.removeObject(itemOverlaps);
			if(itemOverlaps.getClass() == Tnt.class)board.decreaseScore();
			if(itemOverlaps.getClass() == Pig.class) {
				pigBubble.remove((Pig)itemOverlaps);
				if(((Pig) itemOverlaps).getWord() == board.getWord()){
					board.increaseScore(5);
					board.setWord(scene.getAPig().getWord());
				}else board.increaseScore();
			}
			resetBird();
		}
		if(wasp.overlaps(bird)){
			resetBird();
			board.decreaseScore(5);
		}
		if(board.getScore() < 0){
			Angry_Bird.changeActivity(Angry_Bird.activities.play);
			resetScene();
		}
	}
	public void resetBird(){
		bird.reset();
	}
	public void resetScene(){
		board.reset();
		scene.generateScene(w,h,voc);
		board.setWord(scene.getAPig().getWord());
		bird.reset();
		pigBubble.clear();
	}

	// ------------------------------------------------------------
	// Inputs

	@Override
	public boolean keyTyped(char character) {
		if(character == 'r')resetBird();
		if(character == 't')resetScene();
		if(character == 'p')Angry_Bird.changeActivity(Angry_Bird.activities.welcome);;
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(!bird.getmoving() && slingshot.arround(new Vector2(screenX, h - screenY), 400)) {
			bird.fire();
			slingshot.reset();
		}
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		PhysicalObject object = scene.touch(new Vector2(screenX, h - screenY));
		if(object != null && object.getClass() == Pig.class){
			Bubble bubble = null;
			try {
				bubble = ((Pig) object).showOrHiddeBubble();
			} catch (TranslationNotExistException e) {
				e.printStackTrace();
			}
			if ((bubble != null)) {pigBubble.add((Pig) object);
			} else { pigBubble.remove((Pig) object); }
		}
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
	public boolean mouseMoved(int screenX, int screenY) { return false; }
	@Override
	public boolean scrolled(int amount) { return false; }
}
