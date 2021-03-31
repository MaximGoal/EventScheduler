package schedulerProject.model.event;

import org.springframework.context.annotation.Bean;
import schedulerProject.model.room.Room;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class Event {
    private final static int SECONDS_IN_DAY = 24 * 60 * 60;
    private int id;
    private String name;
    private Date date;
    private int timeFrom;
    private int timeTo;
    private boolean weekend;
    private EventType eventType;
    private int room;
    private int cost;

    public Event() {
    }

    public Event(String name, int timeFrom, int timeTo, Date date) {
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.date = date;
        weekend = isWeekend(date);
        eventType = EventType.MEETING;
    }

    public Event(String name, int timeFrom, int timeTo, Date date, EventType eventType, Room room) {
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

    public boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
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

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", date=" + date +
                ", weekend=" + weekend +
                ", eventType=" + eventType +
                ", room=" + room +
                '}';
    }
}
