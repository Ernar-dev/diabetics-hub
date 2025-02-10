package kz.codeforensics.diabetics_hub.domain.enums;

public enum FoodTypeEnum {

    REGULAR("Обычное"),
    VEGETARIAN("Вегетарианское"),
    OTHER("Другое");

    private final String description;

    FoodTypeEnum(String description){this.description = description;}

    public String getDescription() {
        return description;
    }

}
