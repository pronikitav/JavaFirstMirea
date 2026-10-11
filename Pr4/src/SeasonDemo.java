enum Season {
    WINTER(-10),
    SPRING(8),
    SUMMER(22) {
        public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN(7);

    private final int temperature;

    Season(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return "Холодное время года";
    }
}

public class SeasonDemo {
    static void sayAboutSeason(Season s) {
        switch (s) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }

    public static void main(String[] args) {
        Season favorite = Season.SUMMER;
        System.out.println(favorite);
        System.out.println(favorite.getTemperature());
        System.out.println(favorite.getDescription());
        sayAboutSeason(favorite);

        for (Season s : Season.values()) {
            System.out.println(s + ", " + s.getTemperature() + " градусов, " + s.getDescription());
        }
    }
}