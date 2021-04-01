package com.UdemyCourseEmployee.course;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;

@Component
@NoArgsConstructor
public class Main {

    @PostConstruct
    public void start(){
        SessionFactory factory=new Configuration().configure()
                .addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
        Session sesion=factory.getCurrentSession();

        try{
//        Instructor instructor1=new Instructor("Patryk", "Chojnacki");
//           Course course1=new Course("kutasówka1");
//           Course course2=new Course("kutass2s2222");
//           Course course3=new Course("kuavdsacdac");
//           Course course4=new Course("kbiegaccc");
//           Course course5=new Course("fahjjaaaa");
//           instructor1.add(course1);
//            instructor1.add(course2);
//            instructor1.add(course3);
            sesion.beginTransaction();
            Instructor instructor2=sesion.get(Instructor.class, 7);
            System.out.println(instructor2);
            sesion.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
