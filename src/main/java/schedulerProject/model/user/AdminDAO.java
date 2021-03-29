package schedulerProject.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import schedulerProject.model.room.Room;

public class AdminDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public void createRoom () {
//        String name = "";
//        String adress = "";
//        Room room = new Room(name, adress);
//        jdbcTemplate.update("INSERT INTO rooms VALUE(?,?)", room.getName(), room.getAddress());
//    }
}
