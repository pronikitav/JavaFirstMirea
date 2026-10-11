class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHumanAge() {
        return age * 7;
    }

    public String toString() {
        return "Собака " + name + ", возраст " + age + " (по-человечески " + getHumanAge() + ")";
    }
}

public class DogKennel {
    private Dog[] dogs = new Dog[10];
    private int count = 0;

    public void addDog(Dog d) {
        if (count < dogs.length) {
            dogs[count] = d;
            count++;
        }
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(dogs[i]);
        }
    }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel();
        kennel.addDog(new Dog("Бобик", 3));
        kennel.addDog(new Dog("Шарик", 5));
        kennel.addDog(new Dog("Рекс", 1));
        kennel.printAll();
    }
}