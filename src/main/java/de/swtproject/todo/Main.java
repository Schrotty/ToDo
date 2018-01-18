package de.swtproject.todo;

import de.swtproject.todo.core.IntervalType;
import de.swtproject.todo.core.ToDo;
import de.swtproject.todo.core.database.DatabaseManager;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //refresh database
        DatabaseManager.phoenix();

        //store something in database
        ToDo t = ToDo.create("Test 0");
        t.setInterval(IntervalType.DAILY);
        DatabaseManager.storeToDo(t);

        DatabaseManager.storeToDo(new ToDo("Test 1"));
        DatabaseManager.storeToDo(new ToDo("Test 2"));
        DatabaseManager.storeToDo(new ToDo("Test 3"));

        DatabaseManager.getSingleToDo(2).finish();
        
        //DatabaseManager.getArchive().forEach(System.out::println);
        List<ToDo> list = DatabaseManager.getCollection(true);

        //destroy the databaseManager
        DatabaseManager.destroy();
    }
}
