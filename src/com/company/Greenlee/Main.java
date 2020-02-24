package com.company.Greenlee;

import java.util.*;

public class Main {
    // Trenton Greenlee. 1/30/2020. Project 1. CSCI 1660 - Android Programming Fundamentals (Java).
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

    // Array Lists for task names and their corresponding descriptions.
    public static Tasks task;
    private static List<Tasks> merge = new ArrayList<>();

    // Scanner used to determine what methods use it at least once by only one variable in a method.
    private static Scanner input = new Scanner(System.in);

    // Methods.
    // Did not have to use a return statement for methods 2-5 since both ArrayLists are not in the main method.
    // Provides user with options based on an integer. Used a return statement since value needs to pass into the main method.
    public static int menu() {
        boolean a = true;
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

    // Adding a task and description.
    public static void add() {
        // Need two different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        Scanner priorit = new Scanner(System.in);

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
        Tasks check;
        try {
            removeTask = Integer.parseInt(input.nextLine());
            check = merge.remove(removeTask);
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
        // Need four different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        Scanner question = new Scanner(System.in);
        Scanner priorit = new Scanner(System.in);

        // Reminds user if they want to look at the list before removing a task.
        System.out.println("Do you want to reread the list before proceeding?(Use 'yes' or 'no'): ");
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
        int change = 0;
        Tasks check;
        try {
            change = Integer.parseInt(input.nextLine());
            check = merge.set(change, task);
            System.out.println("Updating task...");
            System.out.println("Successfully updated task.\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index does not exist, new task has been discarded.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data type, new task has been discarded.");
        }
    }

    public static void listAllByPriority() {
        Scanner input = new Scanner(System.in);
        // For loop used to print out tasks with their corresponding description based on matching indexes.
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

        for (int i = 0; i < merge.size(); i++) {
            Tasks match = merge.get(i);
            if (priority == match.getPriority()) {
                System.out.println("Tasks with the priority: " + priority + " are: Task: " + match.getTitle() + ", Description: " +
                        match.getDescription() + ", Priority: " + match.getPriority());
            }
        }
    }

    // List all tasks and their corresponding description based on their indexes.
    public static void listAll() {
        // For loop used to print out tasks with their corresponding description based on matching indexes.
        System.out.println("To-Do List: ");
        int index = 0;
        for (Tasks task : merge) {
            System.out.println("Index: " + (index++) + ", " + task);
        }
    }
}