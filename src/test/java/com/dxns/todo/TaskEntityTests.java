package com.dxns.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskEntityTests {

    public TaskEntity testTask() {
        TaskEntity task1 = new TaskEntity();
        task1.setName("Nakarmić chomika");
        task1.setStatus("Aktywne");
        task1.setPlace("Główna lista");
        return task1;
    }

    @Test
    public void taskCreationTest() {
        TaskEntity task1 = testTask();
        Assertions.assertEquals("Nakarmić chomika", task1.getName());
        Assertions.assertEquals("Aktywne", task1.getStatus());
        Assertions.assertEquals("Główna lista", task1.getPlace());
    }

    @Test
    public void taskDeletionTest() {
        TaskEntity task1 = testTask();
        task1 = null;
        TaskEntity finalTask = task1;
        Assertions.assertThrows(java.lang.NullPointerException.class, () -> finalTask.getName());
        Assertions.assertThrows(java.lang.NullPointerException.class, () -> finalTask.getStatus());
        Assertions.assertThrows(java.lang.NullPointerException.class, () -> finalTask.getPlace());
    }

    @Test
    public void taskUpdateTest() {
        TaskEntity task1 = testTask();
        task1.setName("Zmienione zadanie");
        task1.setStatus("Ukończone");
        task1.setPlace("Archiwum");
        Assertions.assertEquals("Zmienione zadanie", task1.getName());
        Assertions.assertEquals("Ukończone", task1.getStatus());
        Assertions.assertEquals("Archiwum", task1.getPlace());
    }

}
