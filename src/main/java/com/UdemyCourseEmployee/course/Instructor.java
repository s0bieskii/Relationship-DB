package com.UdemyCourseEmployee.course;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "instructor")
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructor_id;
    @OneToMany(mappedBy="instructor",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;
    private String first_name;
    private String last_name;

    public Instructor(String name, String lastname){
        first_name=name;
        last_name=lastname;
    }

    public void add(Course course){
        if(courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course);
        course.setInstructor(this);
    }

    @Override
    public String toString(){
        return first_name+" "+last_name+": "+courses;
    }
}
