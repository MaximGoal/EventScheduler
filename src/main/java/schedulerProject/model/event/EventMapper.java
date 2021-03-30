package schedulerProject.model.event;

import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt("id"));
        event.setName(resultSet.getString("name"));
        event.setDate(resultSet.getDate("date"));
        event.setTimeFrom(resultSet.getInt("startTime"));
        event.setTimeTo(resultSet.getInt("endTime"));
        event.setWeekend(resultSet.getBoolean("weekend"));
        event.setEventType(EventType.valueOf(resultSet.getString("type")));
        event.setRoom(resultSet.getInt("room"));
        event.setCost(resultSet.getInt("cost"));

        return event;
    }
}