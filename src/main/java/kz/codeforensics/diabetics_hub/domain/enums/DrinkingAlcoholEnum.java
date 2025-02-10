package kz.codeforensics.diabetics_hub.domain.enums;

public enum DrinkingAlcoholEnum {

    NEVER("Никогда"),
    RARELY("Редко"),
    REGULARLY("Регулярно"),
    OFTEN("Часто");

    private final String description;

    DrinkingAlcoholEnum(String description){this.description = description;}

    public String getDescription() {
        return description;
    }

}
