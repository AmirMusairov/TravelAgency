package HW5;
import java.util.Arrays;

    public class Book {
        private int id;
        private String name;
        private String author;
        private String publishingHouse;
        private int creationYear;
        private int NumbersOfPages;
        private String price;
        private String typeOfBinding;

        public Book(int id, String name, String author, String publishingHouse, int creationYear,
                        int NumbersOfPages, String price, String typeOfBinding) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.publishingHouse = publishingHouse;
            this.creationYear = creationYear;
            this.NumbersOfPages = NumbersOfPages;
            this.price = price;
            this.typeOfBinding = typeOfBinding;
            }

        public int getId() {
            return id;
            }

        public void setId(int id) {
            this.id = id;
            }

        public String getName() {
            return name;
            }

        public void setName(String name) {
            this.name = name;
            }

        public String getAuthor() {
            return author;
            }

        public void setAuthor(String author) {
            this.author = author;
            }

        public String getPublishingHouse() {
            return publishingHouse;
            }

        public void setPublishingHouse(String publishingHouse) {
            this.publishingHouse = publishingHouse;
            }

        public int getCreationYear() {
            return creationYear;
            }

        public void setCreationYear(int creationYear) {
            this.creationYear = creationYear;
            }

        public int getNumbersOfPages() {
            return NumbersOfPages;
            }

        public void setNumbersOfPages(int numbersOfPages) {
            NumbersOfPages = numbersOfPages;
            }

        public String getPrice() {
            return price;
            }

        public void setPrice(String price) {
            this.price = price;
            }

        public String getTypeOfBinding() {
            return typeOfBinding;
            }

        public void setTypeOfBinding(String typeOfBinding) {
            this.typeOfBinding = typeOfBinding;
            }

        @Override
        public String toString() {
            return "Book {" +
                    "id = " + id +
                    ", name = '" + name + '\'' +
                    ", author = '" + author + '\'' +
                    ", publishingHouse = '" + publishingHouse + '\'' +
                    ", creationYear = '" + creationYear + '\'' +
                    ", NumbersOfPages = '" + NumbersOfPages + '\'' +
                    ", price = " + price +
                    ", typeOfBinding = '" + typeOfBinding + '\'' +
                    '}';
        }
    }

    class Library {
        public static void main(String[] args) {
            Book[] book = addBooks();

            System.out.println("List of Given Author's Book:");
            listOfAuthor(book);
            System.out.println();
            System.out.println("List of Given Publishing House:");
            listOfPublishingHouse(book);
            System.out.println();
            System.out.println("List of Given Year:");
            listOfYears(book);
        }

        private static void listOfAuthor(Book[] books) {
            System.out.println("S.King");
            for (Book book : books) {
                if (book.getAuthor().equals("S.King"))
                    System.out.println(book);
            }
        }

        private static void listOfPublishingHouse(Book[] books) {
            System.out.println("HarperCollins");
            for (Book book : books) {
                if (book.getPublishingHouse().equals("HarperCollins"))
                    System.out.println(book);
            }
        }

        private static void listOfYears(Book[] books) {
            System.out.println("From 2010");
            for (Book book : books) {
                if (book.getCreationYear() >= 2010)
                    System.out.println(book);
            }
        }


        static String inputAuthor = "S.King";
        static String inputPublishing = "HarperCollins";
        static int inputYear = 2010;

        private static Book[] addBooks() {
            Book[] book = new Book[4];
            book[0] = new Book(154, "It", "S.King", "Pearson", 1986,
                    1138, "57$", "Sewn binding");
            book[1] = new Book(88, "Lord of the Rings", "R.Tolkien", "HarperCollins", 2014,
                    1358, "65$", "Glued binding");
            book[2] = new Book(215, "Breaking Bad", "V.Gilligan", "HarperCollins", 2008,
                    874, "23$", "Plastic Grip");
            book[3] = new Book(100, "Doctor Sleep", "S.King", "Penguin Random House", 2013,
                    531, "30$", "Spiral");

            return book;
        }
    }