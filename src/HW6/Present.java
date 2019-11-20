package HW6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Present {
        private List<Candy> candies = new ArrayList();

        public void showMeContent() {
            candies.stream().forEach(x -> System.out.println(x));
            System.out.println();
        }

        public void showWeight() {
            int sum = candies.stream().mapToInt(x -> x.getWeight()).sum();
            System.out.println("Present weight is " + sum);
            System.out.println();
        }

        public void showCandyWithSugarLevel(int SugarLevel) {
            candies.stream().filter(x -> x.getLevelOfSugar() == SugarLevel).forEach(System.out::println);
            System.out.println();
        }

        public void putCandy(Candy candy) {
            this.candies.add(candy);
        }
        public void sortCandies() {
        Collections.sort(candies);
        }
}