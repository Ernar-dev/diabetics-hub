package kz.codeforensics.diabetics_hub.domain.enums;

public enum HowOftenDoEatEnum {

    THREE_TIMES_A_DEY("3_раз_в_день"),
    TWO_TIMES_A_DEY("2_раз_в_день"),
    ONE_TIMES_A_DEY("1_раз_в_день"),
    OTHER("Другое");

    private final String description;

    HowOftenDoEatEnum(String description){this.description = description;}

    public String getDescription() {
        return description;
    }

}
