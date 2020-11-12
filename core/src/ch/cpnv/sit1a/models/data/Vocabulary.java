package ch.cpnv.sit1a.models.data;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class Vocabulary {
    private String vocName;
    private ArrayList<SemanticWord> words = new ArrayList<>();

    public Vocabulary(String vocName){
        this.vocName = vocName;
    }

    public void addSemanticWord(SemanticWord word){
        words.add(word);
    }

    public SemanticWord pickAWord(){
        return words.get(MathUtils.random(0, words.size()-1));
    }
}
