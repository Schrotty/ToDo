package de.swtproject.todo;

import de.swtproject.todo.gui.main.MainController;

import java.sql.SQLException;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws SQLException the sql exception
     */
    public static void main(String[] args) {
        MainController.showView();
    }
}
