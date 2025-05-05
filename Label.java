import java.time.LocalDate;

public class Label {
    private int id;
    private String name;
    private String color;
    private String description;
    private LocalDate dateCreated;

    public Label() {
        this.dateCreated = LocalDate.now();
    }

    public Label(int id, String name, String color, String description) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.description = description;
        this.dateCreated = LocalDate.now();
    }

    public Label(String name, String color, String description) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.dateCreated = LocalDate.now();
    }

    public Label(String name) {
        this.name = name;
        this.dateCreated = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
}