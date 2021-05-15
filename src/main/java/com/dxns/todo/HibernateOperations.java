package com.dxns.todo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateOperations {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(com.dxns.todo.TaskEntity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    public static Integer create(TaskEntity task) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
        session.close();
        System.out.println("Pomyślnie utworzono zadanie: " + task.toString());
        return task.getId();
    }
    public static List<TaskEntity> read() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<TaskEntity> Tasks = session.createQuery("FROM TaskEntity").list();
        session.close();
        return Tasks;
    }
    public static void update(TaskEntity task) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        TaskEntity em = (TaskEntity) session.load(TaskEntity.class, task.getId());
        em.setName(task.getName());
        em.setStatus(task.getStatus());
        session.getTransaction().commit();
        session.close();
        System.out.println("Pomyślnie zaktualizowano zadanie: " + task.toString());
    }
    public static void delete(int l) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        TaskEntity task = findByID(l);
        session.delete(task);
        session.getTransaction().commit();
        session.close();
        System.out.println("Pomyślnie usunięto zadanie: " + task.toString());
    }
    public static void updateById(int l) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        TaskEntity task = (TaskEntity) session.load(TaskEntity.class, l);
        task.setStatus("Ukończono");
        task.setPlace("Archiwum");
        session.getTransaction().commit();
        session.close();
        System.out.println("Pomyślnie zaktualizowano zadanie: " + task.toString());
    }
    public static TaskEntity findByID(int l) {
        Session session = getSessionFactory().openSession();
        TaskEntity e = (TaskEntity) session.load(TaskEntity.class, l);
        session.close();
        return e;
    }
}
