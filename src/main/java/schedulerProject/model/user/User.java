package schedulerProject.model.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public abstract class User {
    private int id;

    @NotEmpty(message = "Password should exists")
    private String password;

    @NotEmpty(message = "Name should exists")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30")
    String firstName;

    String lastName, patronymic;

    @Size(min = 6, max = 15, message = "Name should be between 2 and 30")
    @NotEmpty(message = "Telephone should not be empty")
    String telephone;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    String email;

    public User(@NotEmpty(message = "Name should exists") @Size(min = 2, max = 30, message = "Name should be between 2 and 30") String firstName, String lastName, String patronymic, @Size(min = 6, max = 15, message = "Name should be between 2 and 30") @NotEmpty(message = "Telephone should not be empty") String telephone, @NotEmpty(message = "Email should not be empty") @Email(message = "Email should be valid") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.telephone = telephone;
        this.email = email;
    }

    public User(String firstName, String lastName, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public void login(String password) {}

}
