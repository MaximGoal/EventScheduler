package schedulerProject.model.event;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class Event {
    private final static int SECONDS_IN_DAY = 24 * 60 * 60;
    private int event_id;
    private String name;
    private EventType type;
    private Date date;
    private int start_time;
    private int end_time;
    private boolean weekend;
    private int room;
    private int cost;

    public Event() {
    }

    public Event(String name, int start_time, int end_time, Date date) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.date = date;
        weekend = isDateWeekend(date);
        type = EventType.MEETING;
    }

    public Event(String name, int start_time, int end_time, Date date, EventType type, int room) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.date = date;
        weekend = isDateWeekend(date);
        this.type = type;
        this.room = room;
        // cost = realizeCostMethod()
    }

    private boolean isDateWeekend(Date date) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
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
                "id=" + event_id +
                ", name='" + name + '\'' +
                ", timeFrom=" + start_time +
                ", timeTo=" + end_time +
                ", date=" + date +
                ", weekend=" + weekend +
                ", eventType=" + type +
                ", room=" + room +
                '}';
    }
}
