package de.swtproject.todo.core;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "todo")
public class ToDo {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String title;

    @DatabaseField(canBeNull = true)
    private String description;

    @DatabaseField(canBeNull = true)
    private IntervalType interval;

    @DatabaseField(defaultValue = "true")
    private Boolean production;

    @DatabaseField(canBeNull = true)
    private Date start;

    @DatabaseField(canBeNull = true)
    private Date deadline;

    @DatabaseField(canBeNull = true)
    private Date notifyPoint;

    ToDo() {
        //needed for ORMLight
    }

    public ToDo(String title) {
        this.title = title;
    }

    public ToDo(String titel, String description) {
        this(titel);
        this.description = description;
    }

    public ToDo(String titel, String description, IntervalType type) {
        this(titel, description);
        this.interval = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IntervalType getInterval() {
        return interval;
    }

    public void setInterval(IntervalType interval) {
        this.interval = interval;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getNotifyPoint() {
        return notifyPoint;
    }

    public void setNotifyPoint(Date notifyPoint) {
        this.notifyPoint = notifyPoint;
    }

    public void save(String titel, String description, Date start, Date deadline, Date notifypoint) {
      //save todo
    }
}
