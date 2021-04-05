package schedulerProject.model.event;

public enum EventType {
    MEETING("Meeting"),
    EDUCATIONAL("Educational"),
    SPORT("Sport"),
    YOGA("Yoga"),
    RELIGIOUS("Religious"),
    HOLIDAY("Holiday"),
    SECRET("Secret"),
    BUSINESS("Business");

    private final String displayValue;

    private EventType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

//    @Override
//    public String toString() {
//        switch (this) {
//            case EDUCATIONAL: return "Educational";
//            case SPORT: return "Sport";
//            case YOGA: return "Yoga";
//            case RELIGIOUS: return "Religious";
//            case HOLIDAY: return "Holiday";
//            case SECRET: return "Secret";
//            case BUSINESS: return "Business";
//            case MEETING:
//            default: return "Meeting";
//        }
//    }
}
