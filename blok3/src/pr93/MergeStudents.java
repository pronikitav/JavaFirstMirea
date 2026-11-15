package pr93;

public class MergeStudents {
    public static Student[] mergeSort(Student[] a) {
        if (a.length < 2) {
            return a;
        }
        int mid = a.length / 2;
        Student[] left = new Student[mid];
        Student[] right = new Student[a.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    public static Student[] merge(Student[] x, Student[] y) {
        Student[] result = new Student[x.length + y.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < x.length && j < y.length) {
            if (x[i].compareTo(y[j]) <= 0) {
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

    public static void print(Student[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Student[] list1 = {
                new Student(105, "Иван", "Петров", "Информатика", 2, "КВБО-01-23", 4.5),
                new Student(110, "Олег", "Смирнов", "ООП", 3, "ЭКБО-02-23", 3.8),
                new Student(101, "Анна", "Сидорова", "Информатика", 2, "ИКБО-01-26", 4.9)
        };
        Student[] list2 = {
                new Student(103, "Мария", "Иванова", "ООП", 1, "ЭКБО-05-23", 4.2),
                new Student(120, "Елена", "Орлова", "Экономика", 2, "ЭКБО-03-25", 4.7),
                new Student(107, "Павел", "Кузнецов", "ООП", 4, "ИКБО-09-24", 3.5)
        };

        System.out.println("Первый список:");
        print(list1);
        System.out.println("Второй список:");
        print(list2);

        list1 = mergeSort(list1);
        list2 = mergeSort(list2);
        System.out.println("Первый список после сортировки:");
        print(list1);
        System.out.println("Второй список после сортировки:");
        print(list2);

        Student[] all = merge(list1, list2);
        System.out.println("Объединённый отсортированный список:");
        print(all);
    }
}