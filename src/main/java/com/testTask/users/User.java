package com.testTask.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "user_table", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class User {
    @Id
    @Column(name = "userid")
    @SequenceGenerator(name = "users_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private int userID;

    @Column(name = "username")
    private String userName;

    @Column(name = "userpassword")
    private String userPassword;
}
