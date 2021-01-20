package project.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="test_customers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column()
    private String email;

    @Column()
    private String phone;

}
