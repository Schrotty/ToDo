package de.swtproject.todo.core.database;

import de.swtproject.todo.core.ToDo;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * JUnit tests for the {@link DatabaseManager}.
 * Tests still WIP.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 0.1
 */
public class DatabaseManagerTest {

    /**
     * Refresh database after every test.
     *
     * @throws SQLException the sql exception
     */
    @org.junit.After
    public void tearDown() throws SQLException {
        DatabaseManager.phoenix();
    }

    /**
     * Save to do.
     *
     * @throws Exception the exception
     */
    @org.junit.Test
    public void saveToDo() throws Exception {
        ToDo example = ToDo.create("Schrotty");
        DatabaseManager.storeToDo(example);

        assertEquals(example.getTitle(), DatabaseManager.getSingleToDo(1).getTitle());
    }

    /**
     * Save to do collection.
     *
     * @throws Exception the exception
     */
    @org.junit.Test
    public void saveToDoCollection() throws Exception {
        Collection<ToDo> collection = new LinkedList<>();
        collection.add(ToDo.create("Schrotty"));
        collection.add(ToDo.create("Hugo"));
        collection.add(ToDo.create("Max"));

        DatabaseManager.storeToDoCollection(collection);
        assertEquals(collection.size(), DatabaseManager.getToDoCollection().size());
    }

    /**
     * Gets single to do.
     *
     * @throws Exception the exception
     */
    @org.junit.Test
    public void getSingleToDo() throws Exception {
        saveToDo();
    }

    /**
     * Gets to do collection.
     *
     * @throws Exception the exception
     */
    @org.junit.Test
    public void getToDoCollection() throws Exception {
        saveToDoCollection();
    }
}