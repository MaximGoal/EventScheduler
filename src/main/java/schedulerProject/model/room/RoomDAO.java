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

    public Room show(int id) {
        return jdbcTemplate.query("SELECT * FROM rooms WHERE id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Room.class))
                .stream()
                .findAny()
                .orElse((Room) new Object());
    }

    public void update(int id, Room roomUpd) {
        jdbcTemplate.update("UPDATE rooms SET name=?, address=? WHERE id=?",
                roomUpd.getName(), roomUpd.getAddress(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM rooms WHERE id=?", id);
    }
}
