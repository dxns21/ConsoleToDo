package com.dxns.todo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuOperations {
    static Scanner scanner = new Scanner(System.in);

    public static void ShowMenu()
    {
        System.out.println();
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1: Dodaj zadanie");
        System.out.println("2: Oznacz zadanie jako wykonane");
        System.out.println("3: Wyświetl ukończone zadania");
        System.out.println("4. Usuń zadanie");
        System.out.println("9: Zamknij program");
        System.out.println();
    }

    public static void AddTask()
    {
        System.out.println("Podaj nazwę zadania:");
        try {
            String taskName = scanner.nextLine();
            if (taskName.length() > 150) {
                System.out.println("Zbyt długa nazwa zadania, naciśnij dowolny przycisk aby wrócić do menu.");
                scanner.nextLine();
            }
            String taskPlace = "Główna lista";
            TaskEntity newTask = new TaskEntity(0, taskName, "Aktywne", taskPlace);
            HibernateOperations.create(newTask);
            System.out.println("Dodano zadanie do listy.");
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak, spróbuj ponownie.");
        }
    }

    public static void FinishTask() {
        try {
            System.out.println("Podaj numer zadania:");
            int taskDoneIndex = scanner.nextInt();
            HibernateOperations.updateById(taskDoneIndex);
            System.out.println("Zakończono zadanie o numerze: " + taskDoneIndex + ".");
            } catch (Exception e) {
            System.out.println("Niepoprawny numer zadania, naciśnij dowolny przycisk aby wrócić do menu.");
        }
    }
    public static void ShowArchive(List<TaskEntity> taskList) throws IOException {
        try {
            for (TaskEntity task : taskList) {
                if (task.Status.equals("Ukończono")) {
                    System.out.println(task.toString());
                }
            }
            System.out.println("");
            System.out.println("Naciśnij dowolny przycisk aby powrócić do głównego menu");
            System.in.read();
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak, spróbuj ponownie.");
        }
    }

    public static void DeleteTask() {
        try {
            System.out.println("Podaj numer zadania:");
            int taskRemoveIndex = scanner.nextInt();
            HibernateOperations.delete(taskRemoveIndex);
            System.out.println("Usunięto z bazy zadanie o numerze: " + taskRemoveIndex + ".");
            } catch (Exception e) {
            System.out.println("Niepoprawny numer zadania, naciśnij dowolny przycisk aby wrócić do menu.");
        }
    }

    public static void LeaveProgram() {
        System.exit(0);
    }
}
