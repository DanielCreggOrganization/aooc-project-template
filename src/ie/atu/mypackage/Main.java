package ie.atu.mypackage;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main is the entry point of the application and builds the JavaFX GUI.
 *
 * The window provides a button for each of the seven required operations:
 * Load DB, Add Item, Delete Item, Find Item, Show Total, Save to DB and Quit.
 */
public class Main extends Application {

    /** The manager that holds and manipulates the list of objects. */
    private final MyObjectManager manager = new MyObjectManager();

    /** Default file used to save and load the serialised list. */
    private static final String DATA_FILE = "resources/myObjects.ser";

    /** A read-only text area used to show messages and the list of objects. */
    private final TextArea output = new TextArea();

    /**
     * Builds and shows the main window.
     *
     * @param stage the primary stage supplied by JavaFX
     */
    @Override
    public void start(Stage stage) {
        // One button for each of the seven required operations.
        Button loadButton = new Button("Load DB");
        Button addButton = new Button("Add Item");
        Button deleteButton = new Button("Delete Item");
        Button findButton = new Button("Find Item");
        Button totalButton = new Button("Show Total");
        Button saveButton = new Button("Save to DB");
        Button quitButton = new Button("Quit");

        // Wire each button to the method that performs its action (lambdas).
        loadButton.setOnAction(e -> loadItems());
        addButton.setOnAction(e -> addItem());
        deleteButton.setOnAction(e -> deleteItem());
        findButton.setOnAction(e -> findItem());
        totalButton.setOnAction(e -> showTotal());
        saveButton.setOnAction(e -> saveItems());
        quitButton.setOnAction(e -> stage.close());

        // Lay the buttons out in a horizontal row with 10px spacing.
        HBox buttons = new HBox(10, loadButton, addButton, deleteButton,
                findButton, totalButton, saveButton, quitButton);

        // The user should not type directly into the output area.
        output.setEditable(false);

        // Stack a title, the buttons and the output area vertically.
        VBox root = new VBox(10, new Label("Items Application Manager"), buttons, output);
        root.setPadding(new Insets(10));

        stage.setTitle("Items Application Manager");
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }

    /** Adds a new item, using simple pop-up dialogs to gather the input. */
    private void addItem() {
        String id = ask("Add Item", "Enter the unique id:");
        if (id == null) {
            return;
        }
        String name = ask("Add Item", "Enter the name:");
        if (name == null) {
            return;
        }
        manager.add(new MyObject(id, name));
        output.setText("Added: " + id + " (" + name + ")");
    }

    /** Deletes an item by its id and reports the result. */
    private void deleteItem() {
        String id = ask("Delete Item", "Enter the id to delete:");
        if (id == null) {
            return;
        }
        boolean removed = manager.remove(id);
        output.setText(removed ? "Deleted item with id " + id
                : "No item found with id " + id);
    }

    /** Finds an item by its id and shows it. */
    private void findItem() {
        String id = ask("Find Item", "Enter the id to find:");
        if (id == null) {
            return;
        }
        MyObject found = manager.findById(id);
        output.setText(found != null ? "Found: " + found
                : "No item found with id " + id);
    }

    /** Shows the total number of items currently stored. */
    private void showTotal() {
        output.setText("Total items: " + manager.getTotal());
    }

    /** Saves the list to the data file and reports how many were saved. */
    private void saveItems() {
        manager.saveToFile(DATA_FILE);
        output.setText("Saved " + manager.getTotal() + " item(s) to " + DATA_FILE);
    }

    /** Loads the list from the data file and refreshes the display. */
    private void loadItems() {
        manager.loadFromFile(DATA_FILE);
        refresh();
    }

    /** Rebuilds the output area so it lists every current item. */
    private void refresh() {
        StringBuilder sb = new StringBuilder("Current items (" + manager.getTotal() + "):\n");
        manager.getAll().forEach(item -> sb.append(item).append("\n"));
        output.setText(sb.toString());
    }

    /**
     * Shows a single-line text input dialog and returns what the user typed.
     *
     * @param title  the dialog title
     * @param prompt the prompt shown to the user
     * @return the text entered, or {@code null} if the user cancelled
     */
    private String ask(String title, String prompt) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
