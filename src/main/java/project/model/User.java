package project.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import project.model.user_validator.PhoneValid;
import project.service.UsersServiceView;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name="test_customers")

public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name",nullable = false)
    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 15, message = "FirstName should be between 2 and 15 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "LastName should not be empty")
    private String lastName;

    @Column()
    @Email(message = "Email not valid")
    private String email;

    @Column()
    @PhoneValid(value = "^38[0-9]{10}$")
    private String phone;

}
