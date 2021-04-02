package schedulerProject.model.event;

public enum EventType {
    MEETING,
    EDUCATIONAL,
    SPORT,
    YOGA,
    RELIGIOUS,
    HOLIDAY,
    SECRET,
    BUSINESS;

    @Override
    public String toString() {
        switch (this) {
            case EDUCATIONAL: return "EDUCATIONAL";
            case SPORT: return "SPORT";
            case YOGA: return "YOGA";
            case RELIGIOUS: return "RELIGIOUS";
            case HOLIDAY: return "HOLIDAY";
            case SECRET: return "SECRET";
            case BUSINESS: return "BUSINESS";
            case MEETING:
            default: return "MEETING";
        }
    }
}
