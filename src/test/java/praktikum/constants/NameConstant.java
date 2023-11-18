package praktikum.constants;

public enum NameConstant {

    BUN_NAME("Bun Test Name"),
    INGREDIENT_NAME("Ingredient Test Name");

    private String name;

    NameConstant(String name) {
        this.name = name;
    }

    public String getName() {
        return  name;
    }
}
