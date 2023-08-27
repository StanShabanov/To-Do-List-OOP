// Your JUnit testing code here!
import org.junit.Test;
import org.junit.Assert;
import java.util.*;

public class TodoListTests {

    @Test
    public void testAddItem() {
        List<String> todos = new ArrayList<>();
        Scanner console = new Scanner("test\n");
        TodoList.addItem(console, todos);
        Assert.assertEquals("test", todos.get(0));
    }

    @Test
    public void testMarkItemAsDone() {
        List<String> todos = new ArrayList<>();
        todos.add("test1");
        todos.add("test2");
        Scanner console = new Scanner("1\n");
        TodoList.markItemAsDone(console, todos);
        Assert.assertEquals(1, todos.size());
        Assert.assertEquals("test2", todos.get(0));
    }

    @Test
    public void testLoadItems() throws Exception {
        List<String> todos = new ArrayList<>();
        String fileName = "test.txt";
        PrintStream file = new PrintStream(fileName);
        file.println("test1");
        file.println("test2");
        file.close();
        Scanner console = new Scanner(fileName + "\n");
        TodoList.loadItems(console, todos);
        Assert.assertEquals(2, todos.size());
        Assert.assertEquals("test1", todos.get(0));
        Assert.assertEquals("test2", todos.get(1));
    }

    @Test
    public void testSaveItems() throws Exception {
        List<String> todos = new ArrayList<>();
        todos.add("test1");
        todos.add("test2");
        String fileName = "test.txt";
        Scanner console = new Scanner(fileName + "\n");
        TodoList.saveItems(console, todos);
        Scanner file = new Scanner(new File(fileName));
        Assert.assertEquals("test1", file.nextLine());
        Assert.assertEquals("test2", file.nextLine());
        file.close();
    }

    @Test
    public void testPrintTodos() {
        List<String> todos = new ArrayList<>();
        TodoList.printTodos(todos);
        Assert.assertEquals("Today's TODOs:\n  You have nothing to do yet today! Relax!\n", systemOut().getHistory());
        todos.add("test1");
        TodoList.printTodos(todos);
        Assert.assertEquals("Today's TODOs:\n  1: test1\n", systemOut().getHistory());
    }

    @Test
    public void testOnward() {
        Assert.assertTrue(TodoList.onward("A"));
        Assert.assertFalse(TodoList.onward("X"));
    }
}
