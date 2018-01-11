package de.swtproject.todo;

import de.swtproject.todo.core.IntervalType;
import de.swtproject.todo.core.ToDo;
import de.swtproject.todo.core.database.DatabaseManager;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        //System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");

        //store some todos in database
        DatabaseManager.getManager().saveToDo(new ToDo("Test 1", "Description", IntervalType.DAILY));
        DatabaseManager.getManager().saveToDo(new ToDo("Test 2", "Description", IntervalType.DAILY));
        DatabaseManager.getManager().saveToDo(new ToDo("Test 3", "Description", IntervalType.MONTHLY));
        DatabaseManager.getManager().saveToDo(new ToDo("Test 4", "Description", IntervalType.YEARLY));
        DatabaseManager.getManager().saveToDo(new ToDo("Test 5", "Description", IntervalType.YEARLY));

        //get and print all titles in database
        for (ToDo todo :
                DatabaseManager.getManager().loadAllToDo()) {
            System.out.println(todo.getTitle());
        }

        //destroy the databaseManager
        DatabaseManager.getManager().destroy();
    }
}
