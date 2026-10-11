class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}

public class TestAuthor {
    public static void main(String[] args) {
        Author a = new Author("Лев Толстой", "tolstoy@mail.ru", 'm');
        System.out.println(a);
        a.setEmail("new@mail.ru");
        System.out.println(a.getEmail());
        System.out.println(a.getName() + ", " + a.getGender());
    }
}