package de.swtproject.todo.core.database;

import de.swtproject.todo.core.ToDo;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class DatabaseManagerTest {

    @org.junit.After
    public void tearDown() throws SQLException {
        DatabaseManager.phoenix();
    }

    @org.junit.Test
    public void saveToDo() throws Exception {
        ToDo example = ToDo.create("Schrotty");
        DatabaseManager.saveToDo(example);

        assertEquals(example.getTitle(), DatabaseManager.getSingleToDo(1).getTitle());
    }

    @org.junit.Test
    public void saveToDoCollection() throws Exception {
        Collection<ToDo> collection = new LinkedList<>();
        collection.add(ToDo.create("Schrotty"));
        collection.add(ToDo.create("Hugo"));
        collection.add(ToDo.create("Max"));

        DatabaseManager.saveToDoCollection(collection);
        assertEquals(collection.size(), DatabaseManager.getToDoCollection().size());
    }

    @org.junit.Test
    public void getSingleToDo() throws Exception {
        saveToDo();
    }

    @org.junit.Test
    public void getToDoCollection() throws Exception {
        saveToDoCollection();
    }
}