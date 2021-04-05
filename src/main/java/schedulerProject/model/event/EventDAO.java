package schedulerProject.model.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Event> index() {
        return jdbcTemplate.query("SELECT * FROM events",
//                new BeanPropertyRowMapper<>(Event.class)
                new EventMapper()
        );
    }

    // produces NULL
    public Event show(int id) {
        return jdbcTemplate.query("SELECT * FROM events WHERE event_id=?",
                                    new Object[]{id},
                                    new EventMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(Event event) {
        jdbcTemplate.update("INSERT INTO events VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)",
                event.getName(), event.getType().toString(), event.getDate(), event.getWeekend(),
                event.getStart_time(), event.getEnd_time(), event.getCost(), event.getRoom());
    }

    public void update(int id, Event eventUpd) {
        jdbcTemplate.update("UPDATE events SET name=?, start_time=?, end_time=?, date=?, type=? room=? WHERE event_id=?",
                eventUpd.getName(), eventUpd.getStart_time(), eventUpd.getEnd_time(),
                eventUpd.getDate(), eventUpd.getType(), eventUpd.getRoom(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM events WHERE event_id=?", id);
    }
}
