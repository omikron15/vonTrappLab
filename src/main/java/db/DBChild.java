package db;

import models.Child;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class DBChild {

    private static Transaction transaction;
    private static Session session;

    public static void save(Child child) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(child);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Child> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;
        try{
            Criteria criteria = session.createCriteria(Child.class);
            results = criteria.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }

    public static Child find(String name){
        session = HibernateUtil.getSessionFactory().openSession();
        Child result = null;

        try {
            Criteria criteria = session.createCriteria(Child.class);
            criteria.add(Restrictions.eq("name", name));
            result = (Child)criteria.uniqueResult();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public static List<Child> orderByAge(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;

        try{
            Criteria criteria = session.createCriteria(Child.class);
            criteria.addOrder(Order.asc("age"));
            results = criteria.list();
        }catch (HibernateException e){
            e.printStackTrace();

        }finally{
            session.close();
        }
        return results;
    }

    public static List<Child> getSoprano() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;
        try{
          Criteria criteria = session.createCriteria(Child.class);
          criteria.add(Restrictions.eq("range", "Soprano"));
          results = criteria.list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }

    public static void update(Child child) {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.update(child);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static List<Child> lessThanAge(int age){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Child> results = null;
        try{
            Criteria criteria = session.createCriteria(Child.class);
            criteria.add(Restrictions.lt("age", age));
            results = criteria.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }

    public static List<Child> lessThanTen(){
        List<Child> results = null;
        results = lessThanAge(10);
        return results;
    }




}

