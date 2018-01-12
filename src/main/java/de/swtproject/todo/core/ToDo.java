package de.swtproject.todo.core;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * The type To do.
 */
@DatabaseTable(tableName = "todo")
public class ToDo {

    /**
     * The Id.
     */
    @DatabaseField(generatedId = true)
    private int id;

    /**
     * The Title.
     */
    @DatabaseField
    private String title;

    /**
     * The Description.
     */
    @DatabaseField()
    private String description;

    /**
     * The Interval.
     */
    @DatabaseField(dataType = DataType.ENUM_STRING) //TODO: Change to ENUM_INTEGER and add table
    private IntervalType interval;

    /**
     * The Production.
     */
    @DatabaseField(defaultValue = "true")
    private Boolean production;

    /**
     * The Start.
     */
    @DatabaseField()
    private Date start;

    /**
     * The Deadline.
     */
    @DatabaseField()
    private Date deadline;

    /**
     * The Notify point.
     */
    @DatabaseField()
    private Date notifyPoint;

    /**
     * Instantiates a new To do.
     */
    ToDo() {
        //needed for ORMLight
    }

    /**
     * Instantiates a new To do.
     *
     * @param title the title
     */
    public ToDo(String title) {
        this.title = title;
    }

    /**
     * Instantiates a new To do.
     *
     * @param title       the title
     * @param description the description
     */
    public ToDo(String title, String description) {
        this(title);
        this.description = description;
    }

    /**
     * Instantiates a new To do.
     *
     * @param title       the title
     * @param description the description
     * @param type        the type
     */
    public ToDo(String title, String description, IntervalType type) {
        this(title, description);
        this.interval = type;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets interval.
     *
     * @return the interval
     */
    public IntervalType getInterval() {
        return interval;
    }

    /**
     * Sets interval.
     *
     * @param interval the interval
     */
    public void setInterval(IntervalType interval) {
        this.interval = interval;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Gets deadline.
     *
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * Sets deadline.
     *
     * @param deadline the deadline
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * Gets notify point.
     *
     * @return the notify point
     */
    public Date getNotifyPoint() {
        return notifyPoint;
    }

    /**
     * Sets notify point.
     *
     * @param notifyPoint the notify point
     */
    public void setNotifyPoint(Date notifyPoint) {
        this.notifyPoint = notifyPoint;
    }

    /**
     * Create a new {@link ToDo} with given title.
     *
     * @param title the given title
     * @return the created todo
     */
    public static ToDo create(String title) {
        return new ToDo(title);
    }

    /**
     * Create a new {@link ToDo} with given title and description.
     *
     * @param title       the given title
     * @param description the given description
     * @return the created todo
     */
    public static ToDo create(String title, String description) {
        return new ToDo(title, description);
    }

    /**
     * Create a new {@link ToDo} with given title, description and interval.
     *
     * @param title       the given title
     * @param description the given description
     * @param interval    the given interval
     * @return the created todo
     */
    public static ToDo create(String title, String description, IntervalType interval) {
        return new ToDo(title, description, interval);
    }


    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("%s - %s (%s)", title, description, interval.toString());
    }
}
