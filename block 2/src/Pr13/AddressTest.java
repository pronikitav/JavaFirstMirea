import java.util.StringTokenizer;

class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    private static String get(String[] p, int i) {
        if (i < p.length) {
            return p[i].trim();
        }
        return "";
    }

    private void fill(String[] p) {
        country = get(p, 0);
        region = get(p, 1);
        city = get(p, 2);
        street = get(p, 3);
        house = get(p, 4);
        building = get(p, 5);
        apartment = get(p, 6);
    }

    public void parseWithSplit(String text) {
        String[] parts = text.split(",");
        fill(parts);
    }

    public void parseWithTokenizer(String text) {
        StringTokenizer st = new StringTokenizer(text, ",.;");
        String[] parts = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            parts[i] = st.nextToken();
            i++;
        }
        fill(parts);
    }

    public String toString() {
        return "Страна: " + country + "\nРегион: " + region + "\nГород: " + city + "\nУлица: " + street
                + "\nДом: " + house + "\nКорпус: " + building + "\nКвартира: " + apartment + "\n";
    }
}

public class AddressTest {
    public static void main(String[] args) {
        String[] withComma = {
                "Россия, Москва, Москва, Ленина, 5, 2, 17",
                "Россия,Татарстан,Казань,Баумана,10,1,3",
                "Беларусь , Минская область , Минск , Независимости , 22 , 3 , 41",
                "Россия, Самарская область, Самара, Мира, 7, 1, 12"
        };
        String[] withAny = {
                "Россия; Москва; Москва; Ленина; 5; 2; 17",
                "Россия.Татарстан.Казань.Баумана.10.1.3",
                "Россия, Тульская область; Тула. Советская, 15; 4, 8",
                "Россия; Омская область, Омск; Мира; 3; 1; 9"
        };

        System.out.println("=== split() ===");
        for (int i = 0; i < withComma.length; i++) {
            Address a = new Address();
            a.parseWithSplit(withComma[i]);
            System.out.println(a);
        }

        System.out.println("=== StringTokenizer ===");
        for (int i = 0; i < withAny.length; i++) {
            Address a = new Address();
            a.parseWithTokenizer(withAny[i]);
            System.out.println(a);
        }
    }
}