package com.UdemyCourseEmployee.course;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@NoArgsConstructor
public class Main {

    @PostConstruct
    public void start(){
        SessionFactory factory=new Configuration().configure()
                .addAnnotatedClass(User.class).addAnnotatedClass(UserDetails.class).buildSessionFactory();
        Session sesion=factory.getCurrentSession();

        try{
            User user1=new User("sobieskii", "kutas1");
            sesion.beginTransaction();
            sesion.save(user1);
            sesion.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
