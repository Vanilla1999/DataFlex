package entity;

import entity.hibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
public class Main {
    public static void main (String arg[]){

        System.out.println("Maven + Hibernate + MySQL");
        Session session = hibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setFirstName("Alexander");
        user.setLastName("Barchuk");

        session.save(user);
        session.getTransaction().commit();

    }
}



