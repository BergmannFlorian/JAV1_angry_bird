package ch.cpnv.sit1a.models.data;

import java.util.HashMap;

public class SemanticWord {
    private HashMap<String, String> values;
    public SemanticWord(){
        values = new HashMap<>();
    }
    public void addTranslation(String lang, String value){
        values.put(lang, value);
    }
    public String getValue(String lang){
        return values.get(lang);
    }
}
