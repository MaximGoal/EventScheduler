package schedulerProject.model.event;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setEvent_id(resultSet.getInt("event_id"));
        event.setName(resultSet.getString("name"));
        event.setType(EventType.valueOf(resultSet.getString("type").toUpperCase()));
        event.setDate(resultSet.getDate("date"));
        event.setWeekend(resultSet.getBoolean("weekend"));
        event.setStart_time(resultSet.getInt("start_time"));
        event.setEnd_time(resultSet.getInt("end_time"));
        event.setCost(resultSet.getInt("cost"));
        event.setRoom(resultSet.getInt("room"));

        return event;
    }
}