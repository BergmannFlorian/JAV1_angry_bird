package ch.cpnv.sit1a.models.data;

public class Language {
    private String displayName;
    private String ISO_639_1;

    public Language(String ISO, String name){
        displayName = name;
        ISO_639_1 = ISO;
    }

    public String getDisplayName() { return displayName; }
    public String getISO_639_1() {return ISO_639_1; }
}
