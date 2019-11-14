package HW4;

public class Split {
    public static void main(String[] args) {

        String a = "Сколько в этой строке слов?";
        System.out.println("В этой строке " + countWord(a) + " слов.");
    }

    static int countWord(String a) {
        String[] text = a.split("[ ]");
        return text.length;
    }
}