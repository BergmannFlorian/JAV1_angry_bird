package ch.cpnv.sit1a.models.data;

public class Word {
    private String value1;
    private String value2;
    private boolean allocated = false;
    private boolean found = false;

    public Word(String value1, String value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1(){return value1;}
    public String getValue2(){return value2;}
}
