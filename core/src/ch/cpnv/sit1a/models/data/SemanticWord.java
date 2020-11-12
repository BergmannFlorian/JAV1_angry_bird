package ch.cpnv.sit1a.models.data;

import java.util.HashMap;

public class SemanticWord {
    private HashMap<String, Word> values;
    public  SemanticWord(){
        values = new HashMap<>();
    }
    public void addTranslation(String lang, Word value){
        values.put(lang, value);
    }
    public Word getValue(String lang){
        return values.get(lang);
    }
}
