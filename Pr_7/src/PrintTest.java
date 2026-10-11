interface Printable {
    void print();
}

class Book implements Printable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void print() {
        System.out.println("Книга '" + title + "', автор " + author);
    }

    public static void printBooks(Printable[] printable) {
        for (int i = 0; i < printable.length; i++) {
            if (printable[i] instanceof Book) {
                Book b = (Book) printable[i];
                System.out.println(b.getTitle());
            }
        }
    }
}

class Magazine implements Printable {
    private String name;
    private int number;

    public Magazine(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Журнал '" + name + "', номер " + number);
    }

    public static void printMagazines(Printable[] printable) {
        for (int i = 0; i < printable.length; i++) {
            if (printable[i] instanceof Magazine) {
                Magazine m = (Magazine) printable[i];
                System.out.println(m.getName());
            }
        }
    }
}

public class PrintTest {
    public static void main(String[] args) {
        Printable[] items = {
                new Book("Война и мир", "Л. Н. Толстой"),
                new Magazine("Деловой гусь", 5),
                new Book("Отцы и дети", "И. С. Тургенев"),
                new Magazine("Мурзилка", 12)
        };

        System.out.println("Все данные:");
        for (int i = 0; i < items.length; i++) {
            items[i].print();
        }

        System.out.println();
        System.out.println("Только книги:");
        Book.printBooks(items);

        System.out.println();
        System.out.println("Только журналы:");
        Magazine.printMagazines(items);
    }
}