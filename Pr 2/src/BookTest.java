class Book {
    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return author + " - " + title + " (" + year + ")";
    }
}

class Shelf {
    private Book[] books = new Book[20];
    private int count = 0;

    public void addBook(String author, String title, int year) {
        if (count < books.length) {
            books[count] = new Book(author, title, year);
            count++;
        }
    }

    public Book getOldest() {
        Book result = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() < result.getYear()) {
                result = books[i];
            }
        }
        return result;
    }

    public Book getNewest() {
        Book result = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() > result.getYear()) {
                result = books[i];
            }
        }
        return result;
    }

    public void sortByYear() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (books[j].getYear() > books[j + 1].getYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}

public class BookTest {
    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        shelf.addBook("Л. Толстой", "Война и мир", 1869);
        shelf.addBook("И. Тургенев", "Отцы и дети", 1862);
        shelf.addBook("А. Пушкин", "Капитанская дочка", 1836);
        shelf.addBook("М. Булгаков", "Мастер и Маргарита", 1967);
        System.out.println("Самая ранняя: " + shelf.getOldest());
        System.out.println("Самая поздняя: " + shelf.getNewest());
        shelf.sortByYear();
        shelf.print();
    }
}