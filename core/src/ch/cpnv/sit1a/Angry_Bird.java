package ch.cpnv.sit1a;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import ch.cpnv.sit1a.activities.Play;
import ch.cpnv.sit1a.activities.Welcome;

public class Angry_Bird extends ApplicationAdapter{

	private static ApplicationAdapter activity;
	private static ApplicationAdapter playActivity;
	private static ApplicationAdapter welcomeActivity;

	@Override
	public void create () {
		playActivity = new Play();
		welcomeActivity = new Welcome();
		activity = welcomeActivity;
	}
	@Override
	public void render () {
		activity.render();
	}

	public static void changeActivity(activities toActivity){
		if(toActivity == activities.play)activity = playActivity;
		else if(toActivity == activities.welcome)activity = welcomeActivity;
		Gdx.input.setInputProcessor((InputProcessor) activity);
	}
	public enum activities{
		play,
		welcome
	}
}
