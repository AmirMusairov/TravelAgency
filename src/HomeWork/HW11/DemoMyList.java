package HW11;
import java.util.Arrays;
import java.util.Iterator;

public class DemoMyList {
    public static void main(String[] args) {
        DefaultMyList<String> myList = new DefaultMyList<>();

        String str = "My List";
        String str1 = "Your List";

        String number = "16";
        String strOutArr = "Text of This List";
        String moon = "1703";

        String math = String.valueOf(Math.PI);

        myList.add(str);
        myList.add(number);
        myList.add(math);
        myList.add(strOutArr);

        for(Object o: myList) {
            System.out.println("Adding:  " + o);
        }
        System.out.println();

        Boolean bool = myList.remove(math);

        for(Object o: myList) {
            System.out.println("Test of remove():  " + o);
        }
        System.out.println();

        Object[] arr = myList.toArray();
        System.out.println("Test of toArray():  " + Arrays.toString(arr));
        System.out.println();

        bool = myList.contains(math);
        System.out.println("Test of contains():  " + bool);
        System.out.println();

        DefaultMyList<String> yourList = new DefaultMyList<String>();

        yourList.add(str1);
        yourList.add(math);

        bool = myList.containsAll(yourList);
        System.out.println("Test of containsAll():  " + bool);
        System.out.println();

        Iterator<Object> iterMy = myList.iterator();
        while (iterMy.hasNext()) {
            System.out.println("Test Iterator of 'My': " + iterMy.next());
        }
        System.out.println();

        Iterator<Object> iterYour = yourList.iterator();
        for(Object o : yourList) {
            System.out.println("Test Iterator of 'Your': " + iterYour.next());
        }
        System.out.println();

        ListIterator listIterMy = myList.listIterator();
        listIterMy.next();
        listIterMy.set(moon);
        listIterMy.previous();

        while (listIterMy.hasNext()) {
            System.out.println("Test ListIterator of 'My': " + listIterMy.next());
        }

    }
}
