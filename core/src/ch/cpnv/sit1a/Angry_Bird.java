package ch.cpnv.sit1a;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import ch.cpnv.sit1a.activities.Play;
import ch.cpnv.sit1a.activities.Welcome;

public class Angry_Bird extends ApplicationAdapter{

	private ApplicationAdapter page;

	// ------------------------------------------------------------
	// Main methods

	@Override
	public void create () {
		page = new Play();
		//page = new Welcome();
		page.create();
	}
	@Override
	public void render () {
		page.render();
	}
}
