package Test;

public class Artifact {
    int number;
    String culture;
    int century;

    public Artifact(int number) {
        this.number = number;
    }

    public Artifact(int number, String culture) {
        this.number = number;
        this.culture = culture;
    }

    public Artifact(int number, String culture, int century) {
        this.number = number;
        this.culture = culture;
        this.century = century;
    }
}