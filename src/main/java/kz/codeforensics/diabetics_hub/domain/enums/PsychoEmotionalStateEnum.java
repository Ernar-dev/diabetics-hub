package kz.codeforensics.diabetics_hub.domain.enums;

public enum PsychoEmotionalStateEnum {

    EXCELLENT("Отличное"),
    GOOD("Хорошее"),
    SATISFACTORY("Удовлетворительное"),
    POOR("Плохое");

    private final String description;

    PsychoEmotionalStateEnum(String description){this.description = description;}

    public String getDescription() {
        return description;
    }

}
