package schedulerProject.model.event;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt("event_id"));
        event.setName(resultSet.getString("name"));
        event.setEventType(EventType.valueOf(resultSet.getString("type").toUpperCase()));
        event.setDate(resultSet.getDate("date"));
        event.setWeekend(resultSet.getBoolean("weekend"));
        event.setTimeFrom(resultSet.getInt("start_time"));
        event.setTimeTo(resultSet.getInt("end_time"));
        event.setCost(resultSet.getInt("cost"));
        event.setRoom(resultSet.getInt("room"));

        return event;
    }
}