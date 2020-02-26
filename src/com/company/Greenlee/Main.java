package com.company.Greenlee;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    // Trenton Greenlee. 2/23/2020. Project 2. CSCI 1660 - Android Programming Fundamentals (Java).
    public static void main(String[] args) {
        // Calling menu() to ask the user to select an option.
        int prompt = menu();

        // While loop to determine if option integer is not equal to 0 or any option given below.
        while (prompt != 0) {
            switch (prompt) {
                case 1:
                    add();
                    prompt = menu();
                    break;
                case 2:
                    remove();
                    prompt = menu();
                    break;
                case 3:
                    update();
                    prompt = menu();
                    break;
                case 4:
                    listAll();
                    prompt = menu();
                    break;
                case 5:
                    listAllByPriority();
                    prompt = menu();
                    break;
                default:
                    System.out.println("That is not an option, please ask again.");
                    prompt = menu();
                    break;
            }
        }
        // Will alert the user that the program is stopping if the user entered "0".
        System.out.println("Exiting program...");
    }

    // ArrayList and a global object of Tasks in the Main program to use in all the methods without using parameters.
    public static Tasks task;
    private static List<Tasks> merge = new ArrayList<>();

    // Scanner used to determine what methods use it at least once by only one variable in a method.
    private static Scanner input = new Scanner(System.in);

    // Methods.
    // Provides user with options based on an integer. Used a return statement since value needs to pass into the main method.
    public static int menu() {
        boolean a;
        System.out.println("Please choose an option:\n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(5) List all tasks by a specified priority.\n" +
                "(0) Exit.");
        int option = 0;
        do {
            try {
                option = Integer.parseInt(input.nextLine());
                a = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data type, please try again: ");
                a = true;
            }
        }
        while (a);
        return option;
    }

    // Adding a task, description, and priority.
    public static void add() {
        // Need three different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        Scanner priorit = new Scanner(System.in);

        // Need multiple boolean variables for the different try-catch statements since more than one consists of a
        // while loop.
        boolean a = true;
        boolean b = true;

        System.out.println("Enter the name of the task: ");
        String addTask = input.nextLine();
        while (a) {
            try {
                Double.parseDouble(addTask);
                System.out.println("Please enter a task name: ");
                addTask = input.nextLine();
                a = true;
            } catch (NumberFormatException e) {
                a = false;
            }
        }

        System.out.println("Enter a description for that task: ");
        String description = info.nextLine();
        while (b) {
            try {
                Double.parseDouble(description);
                System.out.println("Please enter a description: ");
                description = info.nextLine();
                b = true;
            } catch (NumberFormatException e) {
                b = false;
            }
        }

        System.out.println("Enter a priority for that task(0-5): ");
        int prior = 0;
        do {
            try {
                prior = Integer.parseInt(priorit.nextLine());
                if (prior < 0 || prior > 5) {
                    System.out.println("Please enter a priority between 0 and 5: ");
                    a = true;
                } else {
                    a = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data type, please try again: ");
                a = true;
            }
        }
        while (a);

        task = new Tasks(addTask, description, prior);

        System.out.println("Adding task...");
        merge.add(task);

        System.out.println("Successfully added task.\n");
    }

    // Remove a task, automatically removing its corresponding description based on matching indexes.
    public static void remove() {
        // Need two different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner question = new Scanner(System.in);

        // Reminds user if they want to look at the list before removing a task.
        System.out.println("Do you want to reread the list before proceeding?(Use 'yes' or 'no'): ");
        boolean a = true;

        while (a) {
            try {
                String quest = question.nextLine();
                if (quest.equals("yes")) {
                    listAll();
                } else if (quest.equals("no")) {
                    System.out.println("Proceed to the next step...");
                } else {
                    System.out.println("Your answer will not be processed.");
                }
                Double.parseDouble(quest);
                System.out.println("Invalid data type, please try again: ");
                a = true;
            } catch (NumberFormatException e) {
                a = false;
            }
        }
        System.out.println("Proceeding to the next step...\n");

        System.out.println("Select a task to remove by index: ");

        int removeTask = 0;
        try {
            removeTask = Integer.parseInt(input.nextLine());
            merge.remove(removeTask);
            System.out.println("Removing task...");
            System.out.println("Successfully removed task.\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index does not exist, nothing was removed.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data type, nothing was removed.");
        }
    }

    // Update the name of a task and its corresponding description based on matching indexes.
    public static void update() {
        // Need five different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        Scanner question = new Scanner(System.in);
        Scanner priorit = new Scanner(System.in);

        // Reminds user if they want to look at the list before removing a task.
        System.out.println("Do you want to reread the list before proceeding?(Use 'yes' or 'no'): ");

        // Need multiple boolean variables for the different try-catch statements since more than one consists of a
        // while loop.
        boolean a = true;
        boolean b = true;
        boolean c = true;
        while (a) {
            try {
                String quest = question.nextLine();
                if (quest.equals("yes")) {
                    listAll();
                } else if (quest.equals("no")) {
                    System.out.println("Proceed to the next step...");
                } else {
                    System.out.println("Your answer will not be processed.");
                }
                Double.parseDouble(quest);
                System.out.println("Invalid data type, please try again: ");
                a = true;
            } catch (NumberFormatException e) {
                a = false;
            }
        }
        System.out.println("Proceeding to the next step...\n");

        System.out.println("Name the new task: ");
        String newTask = string.nextLine();
        while (b) {
            try {
                Double.parseDouble(newTask);
                System.out.println("Please enter a task name: ");
                newTask = input.nextLine();
                b = true;
            } catch (NumberFormatException e) {
                b = false;
            }
        }

        System.out.println("Provide a new description: ");
        String newInfo = info.nextLine();
        while (c) {
            try {
                Double.parseDouble(newInfo);
                System.out.println("Please enter a description: ");
                newInfo = input.nextLine();
                c = true;
            } catch (NumberFormatException e) {
                c = false;
            }
        }

        System.out.println("Provide a new priority: ");
        int prior = 0;
        do {
            try {
                prior = Integer.parseInt(priorit.nextLine());
                if (prior < 0 || prior > 5) {
                    System.out.println("Please enter a priority between 0 and 5: ");
                    a = true;
                } else {
                    a = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data type, please try again: ");
                a = true;
            }
        }
        while (a);

        task = new Tasks(newTask, newInfo, prior);

        System.out.println("Choose a task to update by index: ");
        int change;
        try {
            change = Integer.parseInt(input.nextLine());
            merge.set(change, task);
            System.out.println("Updating task...");
            System.out.println("Successfully updated task.\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index does not exist, new task has been discarded. \n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data type, new task has been discarded. \n");
        }
    }

    public static void listAllByPriority() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a priority: ");
        boolean a = true;

        int priority = 0;
        do {
            try {
                priority = Integer.parseInt(input.nextLine());
                if (priority < 0 || priority > 5) {
                    System.out.println("Please enter a priority between 0 and 5: ");
                    a = true;
                } else {
                    a = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data type, please try again: ");
                a = true;
            }
        }
        while (a);


        if (merge.isEmpty()) {
            System.out.println("To-Do list is empty. Please add tasks to to run this method.\n");
        }

        // For loop to get the elements of the merge ArrayList and determine if each of their priority attributes match.
        // If they match the prompted priority, those tasks will print.
        for (int i = 0; i < merge.size(); i++) {
            Tasks match = merge.get(i);
            if (priority == match.getPriority()) {
                System.out.println("Tasks with the priority: " + priority + " are: Task: " + match.getTitle() + ", Description: " +
                        match.getDescription() + ", Priority: " + match.getPriority() + "\n");
            } else {
                System.out.println("There is no task assigned with the priority number: " + priority + "\n");
            }
        }
    }

    // List all tasks and their corresponding description, priority and index based on matching indexes.
    public static void listAll() {
        System.out.println("To-Do List: ");
        int index = 0;

        if (merge.isEmpty()) {
            System.out.println("To-Do List is empty. Please add tasks to run this method.\n");
        }
        // For-Each loop used to print out tasks with their corresponding description, priority and index based on
        // matching indexes.
        for (Tasks task : merge) {
            System.out.println("Index: " + (index++) + ", " + task + "\n");
        }
    }
}
