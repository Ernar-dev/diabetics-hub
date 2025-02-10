package kz.codeforensics.diabetics_hub.domain.enums;

public enum GenderEnum {

    MEN("Мужчина"),
    WOMEN("Женщина");

    private final String description;

    GenderEnum(String description){this.description = description;}

    public String getDescription() {
        return description;
    }
}
