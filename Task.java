import java.time.LocalDateTime;

public class Task {
    private int id;
    private String name;
    private LocalDate dateCreated;
    private LocalDateTime deadline;
    private int userId;
    private String description;
    private boolean completed;
    private Integer projectId;

    public Task(int id, String name, LocalDateTime deadline, int userId, String description) {
        this.id = id;
        this.name = name;
        this.dateCreated = LocalDate.now();
        this.deadline = deadline;
        this.userId = userId;
        this.description = description;
        this.completed = false;
        this.projectId = null;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateCreated = LocalDate.now();
        this.completed = false;
        this.projectId = null;
    }

    public Task(String name) {
        this.name = name;
        this.dateCreated = LocalDate.now();
        this.completed = false;
        this.projectId = null;
    }

    public Task() {
        this.dateCreated = LocalDate.now();
        this.completed = false;
        this.projectId = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}