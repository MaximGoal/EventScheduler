package schedulerProject.model.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Admin extends User {
    public Admin(@NotEmpty(message = "Name should exists") @Size(min = 2, max = 30, message = "Name should be between 2 and 30") String firstName, String lastName, String patronymic, @Size(min = 6, max = 15, message = "Name should be between 2 and 30") @NotEmpty(message = "Telephone should not be empty") String telephone, @NotEmpty(message = "Email should not be empty") @Email(message = "Email should be valid") String email) {
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
