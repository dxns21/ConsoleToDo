package com.dxns.todo;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class ToDoApplication {
    public static void main(String[] args) throws IOException {
        try {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.flush();
            List<TaskEntity> taskList = HibernateOperations.read();
            System.out.println("Zadania:");
            for(TaskEntity task: taskList) {

                if (task.Status.equals("Aktywne")) {
                    System.out.println(task.toString());
                }
            }

            MenuOperations.ShowMenu();

                int choice = scanner.nextInt();
                switch(choice)
                {
                    case 1:
                        MenuOperations.AddTask();
                        break;
                    case 2:
                        MenuOperations.FinishTask();
                        break;
                    case 3:
                        MenuOperations.ShowArchive(taskList);
                        break;
                    case 4:
                        MenuOperations.DeleteTask();
                        break;
                    case 9:
                        scanner.close();
                        MenuOperations.LeaveProgram();
                        break;
                    default:
                        break;
                }
        }
        } catch (Exception e) {
            System.out.println("Wybrano niewłasciwą opcję, spróbuj ponownie.");
        }

    }
}
