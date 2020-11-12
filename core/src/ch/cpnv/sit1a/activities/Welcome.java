package ch.cpnv.sit1a.activities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import ch.cpnv.sit1a.Angry_Bird;
import ch.cpnv.sit1a.models.Button;

public class Welcome extends ApplicationAdapter implements InputProcessor{
	private SpriteBatch batch;
	private float w;
	private float h;
	private ArrayList<Sprite> sceneSprite;
	private BitmapFont titleText, langText;
	private String lang1, lang2, displayLang1, displayLang2;
	private ArrayList<Button> listButtonLeft, listButtonRight;
	private Button playButton;

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
		listButtonLeft = new ArrayList<>();
		listButtonRight = new ArrayList<>();
		displayLang1 = "(choisir)";
		displayLang2 = "(choisir)";

		Sprite background = new Sprite(new Texture("background.jpg"));
		background.setSize(w, h);
		sceneSprite.add(background);

		titleText = new BitmapFont();
		langText = new BitmapFont();
		titleText.setColor(Color.BLACK);
		langText.setColor(Color.BLACK);
		titleText.getData().setScale(10);
		langText.getData().setScale(5);

		int posXleft = 800;
		int posXright = 1300;
		this.generateButton(posXleft, posXright);
		playButton = new Button((int)w/2, (int)h/2, 2, "Play", "");

		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void render () {
		batch.begin();
		update();
		for(Sprite sprite : sceneSprite){sprite.draw(batch);}
		titleText.draw(batch, "Angry Wird", w/3, h-50);
		langText.draw(batch, "Exercice de "+displayLang1+" en "+displayLang2, w/3, h-250);
		for (Button button: listButtonLeft) {
			button.draw(batch);
		}
		for (Button button: listButtonRight) {
			button.draw(batch);
		}
		if(lang1 != null && lang2 != null)playButton.draw(batch);
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
	public void generateButton(int posXleft, int posXright){
		Button button = new Button(posXleft, (int)h-500, 2, "Français", "fr");
		listButtonLeft.add(button);
		button = new Button(posXright, (int)h-500, 2, "Français", "fr");
		listButtonRight.add(button);
		button = new Button(posXleft, (int)h-800, 2, "Anglais", "en");
		listButtonLeft.add(button);
		button = new Button(posXright, (int)h-800, 2, "Anglais", "en");
		listButtonRight.add(button);
		button = new Button(posXleft, (int)h-1100, 2, "Espagnol", "es");
		listButtonLeft.add(button);
		button = new Button(posXright, (int)h-1100, 2, "Espagnol", "es");
		listButtonRight.add(button);
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
		for (Button mybutton : listButtonLeft) {
			if(mybutton.touch(new Vector2(screenX, h - screenY))){
				lang1 = mybutton.getValue();
				displayLang1 = mybutton.getText();
			}
		}
		for (Button mybutton : listButtonRight) {
			if(mybutton.touch(new Vector2(screenX, h - screenY))){
				lang2 = mybutton.getValue();
				displayLang2 = mybutton.getText();
			}
		}
		if(lang1 != null)listButtonLeft.clear();
		if(lang2 != null)listButtonRight.clear();
		if(playButton.touch(new Vector2(screenX, h - screenY))){
			Angry_Bird.changeActivity(Angry_Bird.activities.play);
		}
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
