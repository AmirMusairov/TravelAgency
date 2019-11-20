package HW6;

public class Main {
    public static void main(String args[]) {

        Candy jelly = new Jelly("jelly", 10, 50);
        Candy chocolate = new Chocolate("chocolate", 15, 90);
        Candy caramel = new Caramel("caramel", 5, 74);

        Present present = new Present();

        present.putCandy(jelly);
        present.putCandy(chocolate);
        present.putCandy(caramel);

        present.showWeight();
        present.sortCandies();
        present.showMeContent();
        present.showCandyWithSugarLevel(50);
    }
}