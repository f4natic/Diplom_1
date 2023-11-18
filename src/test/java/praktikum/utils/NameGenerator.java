package praktikum.utils;

public class NameGenerator {

    private NameGenerator() {
        // Utils class
    }

    public static String generateName(String name) {
        return name + " " + ((int) Math.random() * 100);
    }
}
