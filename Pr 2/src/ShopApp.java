import java.util.Scanner;

class Computer {
    private String brand;
    private String model;
    private double price;

    public Computer(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return brand + " " + model + ", " + price + " руб.";
    }
}

class Shop {
    private Computer[] items = new Computer[50];
    private int count = 0;

    public void add(Computer c) {
        if (count < items.length) {
            items[count] = c;
            count++;
        } else {
            System.out.println("Магазин заполнен");
        }
    }

    public boolean remove(String model) {
        for (int i = 0; i < count; i++) {
            if (items[i].getModel().equalsIgnoreCase(model)) {
                for (int j = i; j < count - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public Computer find(String brand, double maxPrice) {
        for (int i = 0; i < count; i++) {
            if (items[i].getBrand().equalsIgnoreCase(brand) && items[i].getPrice() <= maxPrice) {
                return items[i];
            }
        }
        return null;
    }

    public void showAll() {
        if (count == 0) {
            System.out.println("Магазин пуст");
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
    }
}

public class ShopApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop();
        while (true) {
            System.out.println();
            System.out.println("1 - добавить компьютер");
            System.out.println("2 - удалить компьютер");
            System.out.println("3 - найти компьютер");
            System.out.println("4 - показать все");
            System.out.println("0 - выход");
            String choice = sc.nextLine();
            if (choice.equals("0")) {
                break;
            }
            if (choice.equals("1")) {
                System.out.print("Бренд: ");
                String brand = sc.nextLine();
                System.out.print("Модель: ");
                String model = sc.nextLine();
                System.out.print("Цена: ");
                double price = Double.parseDouble(sc.nextLine());
                shop.add(new Computer(brand, model, price));
            } else if (choice.equals("2")) {
                System.out.print("Модель для удаления: ");
                String model = sc.nextLine();
                if (shop.remove(model)) {
                    System.out.println("Удалено");
                } else {
                    System.out.println("Не найдено");
                }
            } else if (choice.equals("3")) {
                System.out.print("Нужный бренд: ");
                String brand = sc.nextLine();
                System.out.print("Максимальная цена: ");
                double max = Double.parseDouble(sc.nextLine());
                Computer c = shop.find(brand, max);
                if (c == null) {
                    System.out.println("Ничего не подошло");
                } else {
                    System.out.println("Подходит: " + c);
                }
            } else if (choice.equals("4")) {
                shop.showAll();
            }
        }
    }
}