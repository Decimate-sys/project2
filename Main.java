//Yunis Khamis, 2/25/20, CSCI 1660
package com.company;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*Create a program that allows a user to add, remove, edit, and list to-do items
similar to the program created for Project 1.
Individual to-do items should be represented by a class and should allow
a title, description, and priority to be tracked with each to-do item.
Priority should be specified using a numeric value between 0 and 5 where 5
indicates high priority and 0 indicates low priority.
Users should be prompted to specify the title, description, and priority when
adding tasks.  The user should have the ability to list all tasks or list
only tasks of a specified priority.
The program should implement exception handling to deal with bad input from
the user and any other exceptions that might arise.
*/
public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Task> items = new ArrayList<>();
            Scanner input = new Scanner(System.in);
            Task task;
            menu();
            int choice = input.nextInt();
            while (!(choice == 0)) {
                switch (choice) {
                    case 1:
                        task = createTask();
                        items.add(task);
                        break;
                    case 2:
                        String title = removeTitle();
                        items.removeIf(bob -> bob.getTaskTitle().equals(title));

                        break;
                    case 3:
                        title = changeTitle();
                        items.removeIf(Element ->  Element.getTaskTitle().equals(title));
                         task = createTask();
                        items.add(task);
                        break;
                    case 4:
                        priorityDisplay(items);
                        break;
                    default:
                        System.out.println("Don't recognize input. ");
                }
                menu();
                choice = input.nextInt();
            }
            System.out.println("The program has ended.");
        }
        catch(InputMismatchException e){
            System.out.println("That was an incorrect entry. Try entering an integer data type. Please try again!");
        }
    }
    static void menu() {
        System.out.println("\nMain Menu\n");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. Update a task");
        System.out.println("4. List all tasks");
        System.out.println("0. Exit");
        System.out.println();
        System.out.println("Please enter a number?");
    }
    static String addTitle(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the task you want to add");
        return input.nextLine();
    }
    static String removeTitle(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the task you want to remove");
        return input.nextLine();
    }
    static String changeTitle(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the task you want to change");
        return input.nextLine();
    }
    static String addDescription(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the description of the task you want to add");
        return input.nextLine();
    }


    static int addPriority(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the priority of the task you want to add from 0-5. 0 being least important and 5 being most important.");
        return input.nextInt();
    }

    static Task createTask(){
        String title = addTitle();
        String description = addDescription();
        int priority = addPriority();
        return new Task(title, description, priority);
    }

    static String priorityInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the priority of the tasks you want to look up. Enter 'all' to list all priorities");
        return input.nextLine();
    }
    static void priorityDisplay(ArrayList<Task> items){
        String priorityLookup = priorityInput();
        if (priorityLookup.equals("all")){
            for (Task task : items) {
                task.taskDisplay();
            }
        } else{
            int priorityLookUp = Integer.parseInt(priorityLookup);
            for (Task task: items){
                if ( task.getTaskPriority() == priorityLookUp) {
                    task.taskDisplay();
                }
            }
        }
    }
}

