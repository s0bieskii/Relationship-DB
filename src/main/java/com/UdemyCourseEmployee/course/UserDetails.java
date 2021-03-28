package com.UdemyCourseEmployee.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_details")
    private int details_id;
    @Column(name="city")
    private String city;
    @Column(name ="hobby")
    private String hobby;

    public UserDetails(String city, String hobby){
        this.city=city;
        this.hobby=hobby;
    }
}
