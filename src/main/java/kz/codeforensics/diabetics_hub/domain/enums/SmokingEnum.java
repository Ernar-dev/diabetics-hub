package kz.codeforensics.diabetics_hub.domain.enums;

public enum SmokingEnum {

    TRUE("Да"),
    FALSE("Нет"),
    QUIT("Бросил(а)");

    private final String description;

    SmokingEnum(String description){this.description = description;}

    public String getDescription() {
        return description;
    }

}
