public class DoubleDemo {
    public static void main(String[] args) {
        Double d1 = Double.valueOf(3.14);
        Double d2 = Double.valueOf("2.5");
        double p = Double.parseDouble("7.75");

        byte b = d1.byteValue();
        short s = d1.shortValue();
        int i = d1.intValue();
        long l = d1.longValue();
        float f = d1.floatValue();
        double d = d1.doubleValue();

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(p);
        System.out.println(b + " " + s + " " + i + " " + l + " " + f + " " + d);

        String str = Double.toString(3.14);
        System.out.println(str);
    }
}



