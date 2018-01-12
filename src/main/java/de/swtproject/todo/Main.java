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
        DatabaseManager.storeToDo(new ToDo("Test 1", "Description", IntervalType.DAILY));
        DatabaseManager.storeToDo(new ToDo("Test 2", "Description", IntervalType.DAILY));
        DatabaseManager.storeToDo(new ToDo("Test 3", "Description", IntervalType.MONTHLY));
        DatabaseManager.storeToDo(new ToDo("Test 4", "Description", IntervalType.YEARLY));
        DatabaseManager.storeToDo(new ToDo("Test 5", "Description", IntervalType.YEARLY));

        //get and print all titles in database
        DatabaseManager.getToDoCollection().forEach(System.out::println);

        //destroy the databaseManager
        DatabaseManager.destroy();
    }
}
