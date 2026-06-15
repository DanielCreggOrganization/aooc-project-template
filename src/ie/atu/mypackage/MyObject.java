package ie.atu.mypackage;

import java.io.Serializable;

/**
 * MyObject represents a single item managed by the application.
 *
 * Rename this class to match the type you are managing (e.g. Book, Car, Phone)
 * and change the fields to suit. The {@code id} field must stay as a UNIQUE
 * identifier for each object (e.g. an ISBN, a registration plate, an IMEI).
 *
 * It implements {@link Serializable} so that a whole list of these objects can
 * be written to, and read back from, a file (object serialisation).
 */
public class MyObject implements Serializable {

    /** Version number used by Java when serialising this class. */
    private static final long serialVersionUID = 1L;

    /** The unique identifier for this object (no two objects share an id). */
    private String id;

    /** A human-readable name for this object. */
    private String name;

    /**
     * Creates a new MyObject.
     *
     * @param id   the unique identifier
     * @param name the object's name
     */
    public MyObject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /** @return the unique identifier */
    public String getId() {
        return id;
    }

    /** @param id the unique identifier to set */
    public void setId(String id) {
        this.id = id;
    }

    /** @return the name */
    public String getName() {
        return name;
    }

    /** @param name the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return a single-line description of this object. This format is also
     *         used when each object is written to the CSV file.
     */
    @Override
    public String toString() {
        return id + "," + name;
    }
}
