package de.swtproject.todo;

import de.swtproject.todo.core.IntervalType;
import de.swtproject.todo.core.ToDo;
import de.swtproject.todo.core.database.DatabaseManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //refresh database
        DatabaseManager.phoenix();

        //store something in database
        DatabaseManager.saveToDo(new ToDo("Test 1", "Description", IntervalType.DAILY));
        DatabaseManager.saveToDo(new ToDo("Test 2", "Description", IntervalType.DAILY));
        DatabaseManager.saveToDo(new ToDo("Test 3", "Description", IntervalType.MONTHLY));
        DatabaseManager.saveToDo(new ToDo("Test 4", "Description", IntervalType.YEARLY));
        DatabaseManager.saveToDo(new ToDo("Test 5", "Description", IntervalType.YEARLY));

        //get and print all titles in database
        for (ToDo todo :
                DatabaseManager.getToDoCollection()) {
            System.out.println(todo.getTitle());
        }

        //destroy the databaseManager
        DatabaseManager.destroy();
    }
}
