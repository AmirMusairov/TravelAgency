package Test;

public class Museum {
    public  static  void main(String[] args) {
        Artifact mask = new Artifact(124);
        Artifact helmet = new Artifact(432,"AncientRome");
        Artifact sword = new Artifact(543,"IndianaJones",15);

        System.out.println("Артефакт МАСКА " + "Порядковый номер: " + mask.number);
        System.out.println("Артекфакт ШЛЕМ " + "Порядковый номер: " + helmet.number + " " + "Культура: " + helmet.culture);
        System.out.println("Артефакт МЕЧ " +"Порядковый номер: " + sword.number + " " + "Культура: " + sword.culture + " " + "Век: " + sword.century);
    }
}