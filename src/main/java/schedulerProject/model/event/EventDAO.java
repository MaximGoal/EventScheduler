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
        return jdbcTemplate.query("SELECT * FROM events", new BeanPropertyRowMapper<>(Event.class));
    }

    public Event show(int id) {
        return jdbcTemplate.query("SELECT * FROM events WHERE id=?",
                                    new Object[]{id},
                                    new BeanPropertyRowMapper<>(Event.class))
                .stream()
                .findAny()
                .orElse((Event) new Object());
    }

    public void save(Event event) {
        jdbcTemplate.update("INSERT INTO events VALUES (?, ?, ?, ?, ?, ?)",
                event.getName(), event.getTimeFrom(), event.getTimeTo(), event.getDate(), event.getEventType(), event.getRoom());
    }

    public void update(int id, Event eventUpd) {
        jdbcTemplate.update("UPDATE events SET name=?, start_time=?, end_time=?, date=?, type=? room=? WHERE id=?",
                eventUpd.getName(), eventUpd.getTimeFrom(), eventUpd.getTimeTo(), eventUpd.getDate(), eventUpd.getEventType(), eventUpd.getRoom(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM events WHERE id=?", id);
    }
}
