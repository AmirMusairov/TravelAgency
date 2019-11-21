package HW6;

public abstract class Candy implements Comparable<Candy> {
    public String nameOfCandy;
    public int weight;
    public int levelOfSugar;

    public Candy(String nameOfCandy, int weight, int levelOfSugar) {
        this.nameOfCandy = nameOfCandy;
        this.weight = weight;
        this.levelOfSugar = levelOfSugar;
    }

    public int getWeight() {
        return weight;
    }

    public int getLevelOfSugar() {
        return levelOfSugar;
    }

    @Override
    public String toString() {
        return  nameOfCandy +
                ", weight " + getWeight() +
                ", levelOfSugar " + getLevelOfSugar();
    }

    @Override
    public int compareTo(Candy anotherCandy) {
        return this.getWeight() - anotherCandy.getWeight();
    }
}

class Jelly extends Candy {
    public Jelly(String nameOfCandy, int weight, int levelOfSugar) {
        super(nameOfCandy, weight, levelOfSugar);
    }
}

class Chocolate extends Candy {
    public Chocolate(String nameOfCandy, int weight, int levelOfSugar) {
        super(nameOfCandy, weight, levelOfSugar);
    }
}

class Caramel extends Candy {
    public Caramel(String nameOfCandy, int weight, int levelOfSugar) {
        super(nameOfCandy, weight, levelOfSugar);
    }
}