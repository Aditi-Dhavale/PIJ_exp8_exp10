import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class Employee {
    private final String id;
    private final String name;
    private final String age;
    private final String email;
    private final String department;

    public Employee(String id, String name, String age, String email, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    // Properties for TableView
    public StringProperty idProperty() {
        return new SimpleStringProperty(id);
    }

    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public StringProperty ageProperty() {
        return new SimpleStringProperty(age);
    }

    public StringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }

    public StringProperty departmentProperty() {
        return new SimpleStringProperty(department);
    }
}
