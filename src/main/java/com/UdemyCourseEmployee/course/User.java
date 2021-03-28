package com.UdemyCourseEmployee.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_details")
    private UserDetails user_details;

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

}
