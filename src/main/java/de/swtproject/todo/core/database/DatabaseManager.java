package de.swtproject.todo.core.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import de.swtproject.todo.core.ToDo;
import de.swtproject.todo.util.Settings;

import java.io.File;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Manager controller for accessing the database.
 * Used to store and receive objects from the databasse.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 0.1
 */
public class DatabaseManager {

    /**
     * The connection source used by the manager.
     */
    private ConnectionSource connectionSource;

    /**
     * The database access object used by the manager.
     */
    public Dao<ToDo,String> todoAccess;

    /**
     * DatabaseManager singleton.
     */
    private static DatabaseManager self = new DatabaseManager();

    /**
     * Get DatabaseManager instance.
     *
     * @return the instance
     */
    public static DatabaseManager getInstance() {
        return self;
    }

    /**
     * Constructor for a new DatabaseManager
     */
    private DatabaseManager() {
        try {
            createDataDirIfMissing(); //see ya in /dev/null for that name...

            connectionSource = new JdbcConnectionSource(Settings.getConnectionString().intern());
            todoAccess = DaoManager.createDao(connectionSource, ToDo.class);

            //create needed tables
            TableUtils.createTableIfNotExists(connectionSource, ToDo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Create the data directory if it's missing
     */
    private void createDataDirIfMissing() throws IllegalStateException {
        File directory = new File(Settings.getDataDir());
        if (!directory.exists()) {
            if(!directory.mkdir()) throw new IllegalStateException("data directory not created!");
        }
    }

    /**
     * Clear all tables in database.
     *
     * @throws SQLException if exception is thrown
     */
    public static void phoenix() throws SQLException {
        //drop all tables
        TableUtils.dropTable(self.connectionSource, ToDo.class, true);

        //re-create all tables with fresh indices
        TableUtils.createTableIfNotExists(self.connectionSource, ToDo.class);
    }

    /**
     * Close the used connection source.
     */
    public static void destroy() {
        self.connectionSource.closeQuietly();
    }

    /**
     * Save a single object.
     *
     * @param todo the object to save
     * @throws SQLException on SQL exception
     */
    public static ToDo storeToDo(ToDo todo) throws SQLException {
        return self.todoAccess.createIfNotExists(todo);
    }

    /**
     * Load a single object from the database.
     *
     * @param id the string to query with
     * @return the loaded object
     * @throws SQLException on SQL exception
     */
    public static ToDo getSingleToDo(int id) throws SQLException {
        return self.todoAccess.queryForId(Integer.toString(id));
    }

    /**
     * Get a collection of {@link ToDo}s.
     *
     * @param loadProduction load production todo's
     * @return the todo collection
     * @throws SQLException on SQL exception
     */
    public static List<ToDo> getCollection(boolean loadProduction) throws SQLException {
        QueryBuilder<ToDo, String> queryBuilder = self.todoAccess.queryBuilder();
        Where<ToDo, String> where = queryBuilder.where();
        SelectArg selectArg = new SelectArg();

        where.eq("production", selectArg);
        PreparedQuery<ToDo> preparedQuery = queryBuilder.prepare();

        selectArg.setValue(loadProduction);
        List result = self.todoAccess.query(preparedQuery);

        return result == null ? new LinkedList<>() : result;
    }
}