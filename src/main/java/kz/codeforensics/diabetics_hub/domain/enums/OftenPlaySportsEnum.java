package kz.codeforensics.diabetics_hub.domain.enums;

public enum OftenPlaySportsEnum {

    EVERY_DEY("Каждый_день"),
    SEVERAL_TIMES_A_WEEK("Несколько_раз_в_неделю"),
    RARELY("Редко"),
    NEVER("Никогда");

    private final String description;

    OftenPlaySportsEnum(String description){this.description = description;}

    public String getDescription() {
        return description;
    }

}
