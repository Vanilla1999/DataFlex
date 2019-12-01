package com.resources;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class TestSystem {
    static   EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("flex");
    public static void main (String [] args){

        addCustomer(1,"Sue","Smith");
        addCustomer(2,"Sue","Smith");
        addCustomer(3,"Sue","Smith");
        addCustomer(4,"Sue","Smith");
        getCustomers();
        changefname(3,"flex");
        deleteCustomer(4);

        ENTITY_MANAGER_FACTORY.close();

    }
    public static  void addCustomer(int id, String fname,String lname){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Car cust = new Car();
            cust.setId(id);
            cust.setFname(fname);
            cust.setlName(lname);
            em.persist(cust);
            et.commit();
        }
        catch(Exception ex){
            if(et !=null){
                et.rollback();
            }
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public static  void getCustomer(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Car c WHERE c.id=:custId";
        TypedQuery<Car> tq = em.createQuery(query, Car.class);
        tq.setParameter("custId",id);
        Car cust = null;
        try {
            cust = tq.getSingleResult();
            System.out.println(cust.getfName()+ " "+
                    cust.getfName());
        } catch (NoResultException ex){
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public static  void getCustomers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String querys = "SELECT c FROM  Car c WHERE c.id is not null";
        TypedQuery<Car> tq = em.createQuery(querys, Car.class);
        List<Car> custs;
        try {
            custs=tq.getResultList();
            custs.forEach(cust-> System.out.println(cust.getfName()+ " " +
                    cust.getLname()));
        }catch (NoResultException ex){
            ex.printStackTrace();
        }
        finally{
            em.close();
        }
    }
    public static  void changefname(int id, String fname){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Car cust = null;
        try {
            et = em.getTransaction();
            et.begin();
           cust = em.find(Car.class,id);
           cust.setFname(fname);

            em.persist(cust);
            et.commit();
        }
        catch(Exception ex){
            if(et !=null){
                et.rollback();
            }
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public static  void deleteCustomer(int id){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Car cust = null;
        try {
            et = em.getTransaction();
            et.begin();
           cust= em.find(Car.class,id);
           em.remove(cust);
            em.persist(cust);
            et.commit();
        }
        catch(Exception ex){
            if(et !=null){
                et.rollback();
            }
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
