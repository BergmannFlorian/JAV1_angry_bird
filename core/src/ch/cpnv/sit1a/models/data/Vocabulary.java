package ch.cpnv.sit1a.models.data;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class Vocabulary {
    private String vocName;
    private ArrayList<Word> words = new ArrayList<Word>();

    public Vocabulary(String vocName){
        this.vocName = vocName;
    }

    public void addWord(Word word){
        words.add(word);
    }

    public Word pickAWord(){
        return words.get(MathUtils.random(0, words.size()-1));
    }
}
