package Pr10;

import java.util.Arrays;
import java.util.Comparator;

class SurnameComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.getSurname().compareTo(b.getSurname());
    }
}

public class SortingStudentsByGPA implements Comparator<Student> {
    private Student[] iDNumber;

    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());
    }

    public void setArray() {
        iDNumber = new Student[]{
                new Student(105, "Иван", "Петров", "Информатика", 2, "ИКБО-01-22", 4.5),
                new Student(101, "Анна", "Сидорова", "Информатика", 2, "ИКБО-01-23", 4.9),
                new Student(110, "Олег", "Смирнов", "Экономика", 3, "ЭКБО-02-23", 3.8),
                new Student(103, "Мария", "Иванова", "Экономика", 1, "ЭКБО-05-25", 4.2),
                new Student(107, "Павел", "Кузнецов", "Информатика", 4, "ИКБО-09-23", 3.5)
        };
    }

    public void outArray() {
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println(iDNumber[i]);
        }
        System.out.println();
    }

    public void quicksort() {
        quick(iDNumber, 0, iDNumber.length - 1, this);
    }

    public void mergeSort() {
        iDNumber = sortMerge(iDNumber, this);
    }

    public void sortBySurname() {
        quick(iDNumber, 0, iDNumber.length - 1, new SurnameComparator());
    }

    private static void quick(Student[] arr, int low, int high, Comparator<Student> c) {
        if (low >= high) {
            return;
        }
        Student pivot = arr[(low + high) / 2];
        int i = low;
        int j = high;
        while (i <= j) {
            while (c.compare(arr[i], pivot) < 0) {
                i++;
            }
            while (c.compare(arr[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quick(arr, low, j, c);
        quick(arr, i, high, c);
    }

    private static Student[] sortMerge(Student[] a, Comparator<Student> c) {
        if (a.length < 2) {
            return a;
        }
        int mid = a.length / 2;
        Student[] left = sortMerge(Arrays.copyOfRange(a, 0, mid), c);
        Student[] right = sortMerge(Arrays.copyOfRange(a, mid, a.length), c);
        return merge(left, right, c);
    }

    private static Student[] merge(Student[] x, Student[] y, Comparator<Student> c) {
        Student[] result = new Student[x.length + y.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < x.length && j < y.length) {
            if (c.compare(x[i], y[j]) <= 0) {
                result[k] = x[i];
                i++;
            } else {
                result[k] = y[j];
                j++;
            }
            k++;
        }
        while (i < x.length) {
            result[k] = x[i];
            i++;
            k++;
        }
        while (j < y.length) {
            result[k] = y[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        SortingStudentsByGPA s = new SortingStudentsByGPA();
        s.setArray();
        System.out.println("Исходный массив:");
        s.outArray();
        s.quicksort();
        System.out.println("Быстрая сортировка по баллу (убывание):");
        s.outArray();
        s.sortBySurname();
        System.out.println("Сортировка по фамилии:");
        s.outArray();
        s.mergeSort();
        System.out.println("Сортировка слиянием по баллу (убывание):");
        s.outArray();
    }
}