package Lists1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentList {
    private Student head;
    private int size;

    public StudentList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    private Student getNode(int number) {
        Student cur = head;
        for (int i = 1; i < number; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void add(Student s) {
        if (head == null) {
            head = s;
        } else {
            Student last = getNode(size);
            last.next = s;
        }
        size++;
    }

    public boolean remove(int number) {
        if (number < 1 || number > size) {
            return false;
        }
        if (number == 1) {
            head = head.next;
        } else {
            Student prev = getNode(number - 1);
            prev.next = prev.next.next;
        }
        size--;
        return true;
    }

    public void printElement(int number) {
        if (number < 1 || number > size) {
            System.out.println("Нет элемента с таким номером");
            return;
        }
        getNode(number).print();
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Student cur = head;
        int i = 1;
        while (cur != null) {
            System.out.print(i + ". ");
            cur.print();
            cur = cur.next;
            i++;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void saveToFile(String fileName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            Student cur = head;
            while (cur != null) {
                out.println(cur.getName() + ";" + cur.getAge() + ";" + cur.getGroup());
                cur = cur.next;
            }
            System.out.println("Сохранено в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
        }
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            clear();
            String line;
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] p = line.split(";");
                add(new Student(p[0], Integer.parseInt(p[1]), p[2]));
            }
            System.out.println("Загружено элементов: " + size);
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
