import java.time.LocalDate;

public class Project {
    private int id;
    private int userId;
    private String name;
    private String description;
    private LocalDate dateCreated;

    public Project(int id, int userId, String name, String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.dateCreated = LocalDate.now();
    }

    public Project() {
        this.dateCreated = LocalDate.now();
    }


}