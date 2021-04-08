package schedulerProject.model.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import schedulerProject.model.event.Event;

import java.util.List;

@Component
public class RoomDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save (Room room) {
        jdbcTemplate.update("INSERT INTO rooms VALUE(?,?)", room.getName(), room.getAddress());
    }

    public List<Room> index() {
        return jdbcTemplate.query("SELECT * FROM rooms", new BeanPropertyRowMapper<>(Room.class));
    }

    // produces NULL
    public Room show(int id) {
        return jdbcTemplate.query("SELECT * FROM rooms WHERE room_id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Room.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public void update(int id, Room roomUpd) {
        jdbcTemplate.update("UPDATE rooms SET name=?, address=? WHERE room_id=?",
                roomUpd.getName(), roomUpd.getAddress(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM rooms WHERE room_id=?", id);
    }
}
