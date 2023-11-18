package praktikum.utils;

public class PriceGenerator {

    private PriceGenerator() {
        // Utils class
    }

    public static float generatePrice() {
        return (float) Math.random() * 1000;
    }
}
