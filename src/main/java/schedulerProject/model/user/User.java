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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
