package Lists1;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();
        while (true) {
            System.out.println();
            System.out.println("1 - добавить студента");
            System.out.println("2 - удалить студента по номеру");
            System.out.println("3 - показать студента по номеру");
            System.out.println("4 - показать всех");
            System.out.println("5 - очистить список");
            System.out.println("6 - проверить, пуст ли список");
            System.out.println("7 - записать в файл");
            System.out.println("8 - прочитать из файла");
            System.out.println("0 - выход");
            String choice = sc.nextLine();
            if (choice.equals("0")) {
                break;
            }
            if (choice.equals("1")) {
                Student s = new Student();
                s.read(sc);
                list.add(s);
            } else if (choice.equals("2")) {
                System.out.print("Номер: ");
                int n = Integer.parseInt(sc.nextLine());
                if (list.remove(n)) {
                    System.out.println("Удалено");
                } else {
                    System.out.println("Нет такого номера");
                }
            } else if (choice.equals("3")) {
                System.out.print("Номер: ");
                int n = Integer.parseInt(sc.nextLine());
                list.printElement(n);
            } else if (choice.equals("4")) {
                list.printAll();
            } else if (choice.equals("5")) {
                list.clear();
                System.out.println("Список очищен");
            } else if (choice.equals("6")) {
                if (list.isEmpty()) {
                    System.out.println("Список пуст");
                } else {
                    System.out.println("В списке элементов: " + list.size());
                }
            } else if (choice.equals("7")) {
                System.out.print("Имя файла: ");
                list.saveToFile(sc.nextLine());
            } else if (choice.equals("8")) {
                System.out.print("Имя файла: ");
                list.loadFromFile(sc.nextLine());
            }
        }
    }
}