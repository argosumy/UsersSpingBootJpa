package project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    String role;

    public Role() {
    }
}
