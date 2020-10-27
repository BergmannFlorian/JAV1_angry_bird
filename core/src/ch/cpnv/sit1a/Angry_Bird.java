package ch.cpnv.sit1a;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.Stack;

import ch.cpnv.sit1a.activities.Play;
import ch.cpnv.sit1a.activities.Welcome;

public class Angry_Bird extends ApplicationAdapter{

	private static ApplicationAdapter activity;
	private static ApplicationAdapter playActivity;
	private static ApplicationAdapter welcomeActivity;

	private static Stack<ApplicationAdapter> screens;

	@Override
	public void create () {
		playActivity = new Play();
		welcomeActivity = new Welcome();
		activity = welcomeActivity;

		screens = new Stack<>();
		screens.push(playActivity);
	}
	@Override
	public void render () {
		activity.render();
//		screens.peek().render();
	}

	public static void changeActivity(activities toActivity){
		if(toActivity == activities.play)activity = playActivity;
		if(toActivity == activities.welcome)activity = welcomeActivity;
		Gdx.input.setInputProcessor((InputProcessor) activity);
	}

	public static void openActivity(activities toActivity){
		if(toActivity == activities.play)screens.push(playActivity);
		if(toActivity == activities.welcome)screens.push(welcomeActivity);
		Gdx.input.setInputProcessor((InputProcessor) screens.peek());
	}
	public static void closeActivity(){
		screens.pop();
	}

	public enum activities{
		play,
		welcome
	}
}
