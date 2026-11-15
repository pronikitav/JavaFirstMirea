package Lists2;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private String group;
    Student next;
    Student prev;

    public Student() {
    }

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public void read(Scanner sc) {
        System.out.print("Имя: ");
        name = sc.nextLine();
        System.out.print("Возраст: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.print("Группа: ");
        group = sc.nextLine();
    }

    public void print() {
        System.out.println(name + ", возраст " + age + ", группа " + group);
    }
}