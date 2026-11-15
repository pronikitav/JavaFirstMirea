package Lists2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentList {
    private Student head;
    private Student tail;
    private int size;

    public StudentList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    private Student getNode(int number) {
        Student cur;
        if (number <= size / 2) {
            cur = head;
            for (int i = 1; i < number; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size; i > number; i--) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    public void add(Student s) {
        if (head == null) {
            head = s;
            tail = s;
        } else {
            tail.next = s;
            s.prev = tail;
            tail = s;
        }
        size++;
    }

    public boolean remove(int number) {
        if (number < 1 || number > size) {
            return false;
        }
        Student cur = getNode(number);
        if (cur.prev == null) {
            head = cur.next;
        } else {
            cur.prev.next = cur.next;
        }
        if (cur.next == null) {
            tail = cur.prev;
        } else {
            cur.next.prev = cur.prev;
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

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Student cur = tail;
        int i = size;
        while (cur != null) {
            System.out.print(i + ". ");
            cur.print();
            cur = cur.prev;
            i--;
        }
    }

    public void clear() {
        head = null;
        tail = null;
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