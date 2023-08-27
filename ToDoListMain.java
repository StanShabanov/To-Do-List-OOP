import java.util.*;
import java.io.*;
//This class represents a main program for a TODO list manager. The program takes user input through 
//the console and uses methods from the TodoList class to perform different actions on the TODO list.
//The program starts by creating a new instance of the TodoList class and prompting the user for input.
public class TodoListMain {
    //This main method takes in and uses other methods for each function that the user
    //enters. It allows the user to quit, add, save, load, mark items that are on the todo list
    //The user can choose to add a new item to the list (A), mark an item as done (M), load previously 
    //saved TODOs from a file (L), save the current list to a file (S), or quit the program (Q).
    public static void main(String[] args) throws FileNotFoundException, IOException {
        TodoList list = new TodoList();
        System.out.println("Welcome to your TODO List Manager!"); 
        System.out.println("What would you like to do?");
        System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? ");
        Scanner console = new Scanner(System.in);
        ArrayList<String> todos = new ArrayList<>();
        String input = console.nextLine();
        while (!input.equalsIgnoreCase("Q")){
            if(list.onward(input)){
                if(input.equalsIgnoreCase("A")){
                list.addItem(console, todos);  
                }
                else if (input.equalsIgnoreCase("S")){
                list.saveItems(console, todos);
                }
                else if (input.equalsIgnoreCase("L")){
                list.loadItems(console, todos);
                }
                else if (input.equalsIgnoreCase("M")){
                list.markItemAsDone(console, todos);
                }
            }
            list.printTodos(todos);
            System.out.println("What would you like to do?");
            System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? ");
            input = console.nextLine();
        }
    }
}
