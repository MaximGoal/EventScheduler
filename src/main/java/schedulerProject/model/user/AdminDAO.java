package schedulerProject.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdminDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save (Admin admin) {
        jdbcTemplate.update("INSERT INTO admins VALUE(?,?,?,?,?,?)",
                admin.getFirstName(), admin.getLastName(), admin.getPatronymic(),
                admin.getTelephone(), admin.getEmail(), admin.getPassword());
    }

}
