package schedulerProject.model.event;

import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class Event {
    private final static int SECONDS_IN_DAY = 24 * 60 * 60;
    private int id;
    private String name;
    private int timeFrom;
    private int timeTo;
    private Date date;
    private boolean weekend;
    private EventType eventType;

    public Event(String name, int timeFrom, int timeTo, Date date) {
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.date = date;
        weekend = isWeekend(date);
        eventType = EventType.MEETING;
    }

    public Event(String name, int timeFrom, int timeTo, Date date, EventType eventType) {
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.date = date;
        weekend = isWeekend(date);
        this.eventType = eventType;
    }

    private boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(int timeFrom) {
        this.timeFrom = timeFrom;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(int timeTo) {
        this.timeTo = timeTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", date=" + date +
                '}';
    }
}
