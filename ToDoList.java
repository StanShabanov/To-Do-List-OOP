import java.util.*;
import java.io.*;
    //This is the object class for ToDo List which the main instantiates to use its methods from the ToDo List object.
    //The class has a private instance variable "todos" which is a List of Strings representing the 
    //to-do list items. The class constructor initializes this list as an empty ArrayList.
public class TodoList {
    private List<String> todos;

    public TodoList() {
        todos = new ArrayList<>();
    }

    //This method takes in their todo list items and add it to thier lists. It also allows them to put where
    //each item they want to place in the list.
    //parameters: 
    //- Scanner console to take in inputs to add to list
    //- ArrayList of strings named todo that is used to figure out how many and what are the items are in the list
    //no returns
    public static void addItem(Scanner console, List<String> todos) {
        System.out.print("What would you like to add? ");
        String input = console.nextLine();
        if (input.equals(""))
            System.out.println("Unknown input:" + input);
         else if(todos.size() == 0){
            todos.add(input);
        }
        else {
            System.out.print("Where in the list should it be (1-" + (todos.size() + 1) + ")? (Enter for end): ");
            String scan = console.nextLine();
            if(scan == ""){
                todos.add(input);
            }
            else {
                int integer = Integer.parseInt(scan);
                todos.add(integer - 1, input);
            }
        }
    }

    //This method allows the user to mark items that they have added to thier list to be
    //completed and if the user has nothing in list it prompts a different prompt
    //parameters:
    // - Scanner console initalized in the main method to get user input
    // - List of strings used in other methods to tell what is in the list to be used
    // no returns 
    public static void markItemAsDone(Scanner console, List<String> todos) {
        if(todos.size() >= 1){
            System.out.print("Which item did you complete (1-" + todos.size() + ")? ");
            String input = console.nextLine();
            int delete = Integer.parseInt(input);
            todos.remove(delete - 1);
        }
        else {
            System.out.println("All done! Nothing left to mark as done!");
        }
    }

    //This method allows the user to load items inside the list and uses the name of 
    // a file that they used to execute the program
    // parameters:
    // - Scanner that has been initalized in main method to be used to find user answers
    // - List of strings used in other methods to tell what is in the list to be used
    // no returns
    public static void loadItems(Scanner console, List<String> todos)
                                throws FileNotFoundException {
        System.out.print("File name? ");
        String files = console.nextLine();
        while(todos.size() > 0 ){
            todos.remove(0);
        }
        Scanner items = new Scanner(new File(files));
        while(items.hasNextLine()){
            String todoList = items.nextLine();
            todos.add(todoList);
        }
    }

    //This method allows the user to save items to the list given a file name
    // - Scanner console initalized in the main method to get user input
    // - List of strings used in other methods to tell what is in the list to be used
    // no returns 
    public static void saveItems(Scanner console, List<String> todos)
                                throws FileNotFoundException {
        System.out.print("File name? ");
        String files = console.nextLine();
        PrintStream answer = new PrintStream(new File(files));
        for(int i = 0; i < todos.size(); i++){
            answer.println(todos.get(i));
        }
    }

    //This method allows the user to see what is in the todo list that they have made. 
    //If they had nothing it will give them a different prompt
    //parameters: 
    // - Arraylist of Strings named todo that is used to determine what items are in the todo list
    //no returns
    public static void printTodos(List<String> todos) {
        System.out.println("Today's TODOs:");
        if(todos.size()==0){
            System.out.println("  You have nothing to do yet today! Relax!");
        }
        else {
            for(int i = 1; i <= todos.size(); i++){
                System.out.println("  " + i + ": " + todos.get(i - 1));
            }
        }
    }

    //This method checks to see if the answer the user put was valid to execute and put into the todo list 
    // parameter: 
    // - String of letters the user answered 
    // returns:
    // - returns if the input of user is valid or not to use
    public static boolean onward(String input){
        boolean validinput = false;
        String [] valid = {"A", "S", "L", "M"};
        if(Arrays.asList(valid).contains(input.toUpperCase())){
            validinput = true;
        } 
        else {
            System.out.println("Unknown input: " + input);
        }
        return validinput;
    }
}
