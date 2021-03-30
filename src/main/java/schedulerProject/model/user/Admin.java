package schedulerProject.model.user;

import org.springframework.context.annotation.Bean;

public class Admin extends User {

    public Admin(String firstName, String lastName, String patronymic, String telephone, String email) {
        super(firstName, lastName, patronymic, telephone, email);
    }

    public Admin(String firstName, String lastName, String telephone) {
        super(firstName, lastName, telephone);
    }

    @Override
    public void login(String password) {
        super.login(password);
    }

}
