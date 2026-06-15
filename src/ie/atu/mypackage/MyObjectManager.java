package ie.atu.mypackage;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * MyObjectManager stores and manages a collection of {@link MyObject}s.
 *
 * It uses an {@link ArrayList} as the in-memory store and provides methods to
 * add, remove, search, count, and save/load the objects to and from a file.
 */
public class MyObjectManager {

    /** The in-memory list that holds every object. */
    private ArrayList<MyObject> items = new ArrayList<>();

    /**
     * Adds an object to the list.
     *
     * @param item the object to add
     */
    public void add(MyObject item) {
        items.add(item);
    }

    /**
     * Removes the first object whose id matches the given id.
     *
     * @param id the id to remove
     * @return {@code true} if an object was removed, {@code false} otherwise
     */
    public boolean remove(String id) {
        // removeIf takes a lambda that tests each object's id.
        return items.removeIf(item -> item.getId().equals(id));
    }

    /**
     * Finds an object by its unique id using the Stream API and a lambda.
     *
     * @param id the id to search for
     * @return the matching object, or {@code null} if none was found
     */
    public MyObject findById(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the first object whose name matches (ignoring case) using the
     * Stream API and a lambda.
     *
     * @param name the name to search for
     * @return the matching object, or {@code null} if none was found
     */
    public MyObject findByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * @return the total number of objects currently stored
     */
    public int getTotal() {
        return items.size();
    }

    /**
     * @return the full list of objects (for example, to display in the GUI)
     */
    public ArrayList<MyObject> getAll() {
        return items;
    }

    /**
     * Saves (serialises) the whole list to a file.
     *
     * @param fileName the file to write to (e.g. "resources/myObjects.ser")
     */
    public void saveToFile(String fileName) {
        // try-with-resources closes the stream automatically, even on error.
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(items);
        } catch (IOException e) {
            // Exception handling: report the problem instead of crashing.
            System.out.println("Could not save to " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Loads (deserialises) the list from a file, replacing the current list.
     *
     * @param fileName the file to read from (e.g. "resources/myObjects.ser")
     */
    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            items = (ArrayList<MyObject>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load from " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Writes every object to a plain-text CSV file using the Stream API and a
     * lambda. This demonstrates streaming the list to a file.
     *
     * @param fileName the CSV file to write to (e.g. "resources/myObjects.csv")
     */
    public void exportToCsv(String fileName) {
        try (PrintWriter writer =
                     new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            // forEach with a lambda writes one line per object.
            items.stream().forEach(item -> writer.println(item.toString()));
        } catch (IOException e) {
            System.out.println("Could not export to " + fileName + ": " + e.getMessage());
        }
    }
}
