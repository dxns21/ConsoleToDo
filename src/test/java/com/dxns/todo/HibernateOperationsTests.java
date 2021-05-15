package com.dxns.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HibernateOperationsTests {

    public TaskEntity testTask() {
        TaskEntity task1 = new TaskEntity();
        task1.setName("Nakarmić chomika");
        task1.setStatus("Aktywne");
        task1.setPlace("Główna lista");
        return task1;
    }

    @Test
    public void readCreateAndDeleteATask() {
        TaskEntity task1 = testTask();
        int i = HibernateOperations.create(task1);
        TaskEntity task2 = HibernateOperations.findByID(i);
        Assertions.assertEquals("Nakarmić chomika", task2.getName());
        Assertions.assertEquals("Aktywne", task2.getStatus());
        Assertions.assertEquals("Główna lista", task2.getPlace());
        HibernateOperations.delete(i);
        TaskEntity task3 = HibernateOperations.findByID(i);
        Assertions.assertThrows(org.hibernate.LazyInitializationException.class, () -> task3.getName());
    }
}


