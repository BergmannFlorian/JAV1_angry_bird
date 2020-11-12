package ch.cpnv.sit1a.models.data;

import java.util.HashMap;

import ch.cpnv.sit1a.customException.DuplicatedTranslationException;

public class SemanticWord {
    private HashMap<String, String> values;
    public SemanticWord(){
        values = new HashMap<>();
    }
    public void addTranslation(String lang, String value) throws DuplicatedTranslationException {
        if(values.containsKey(lang)) throw new DuplicatedTranslationException("The translation "+lang+" : "+value+" is alreday present");
        values.put(lang, value);
    }
    public String getValue(String lang){
        return values.get(lang);
    }
}
