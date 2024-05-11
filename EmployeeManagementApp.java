import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EmployeeManagementApp extends Application {

    // Employee details fields
    private TextField employeeIdField;
    private TextField nameField;
    private TextField ageField;
    private TextField emailField;
    private TextField departmentField;

    // Employee table
    private TableView<Employee> employeeTable;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label employeeIdLabel = new Label("Employee ID:");
        employeeIdField = new TextField();
        Label nameLabel = new Label("Name:");
        nameField = new TextField();
        Label ageLabel = new Label("Age:");
        ageField = new TextField();
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        Label departmentLabel = new Label("Department:");
        departmentField = new TextField();

        Button createTableButton = new Button("Create Employee Table");
        createTableButton.setOnAction(e -> createEmployeeTable());

        Button registerButton = new Button("Register Employee");
        registerButton.setOnAction(e -> registerEmployee());

        Button viewButton = new Button("View Employees");
        viewButton.setOnAction(e -> viewEmployees());

        Button updateButton = new Button("Update Employee");
        updateButton.setOnAction(e -> updateEmployee());

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(employeeIdLabel, 0, 0);
        grid.add(employeeIdField, 1, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(ageLabel, 0, 2);
        grid.add(ageField, 1, 2);
        grid.add(emailLabel, 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(departmentLabel, 0, 4);
        grid.add(departmentField, 1, 4);

        grid.add(createTableButton, 0, 5);
        grid.add(registerButton, 1, 5);
        grid.add(viewButton, 0, 6);
        grid.add(updateButton, 1, 6);

        Scene scene = new Scene(grid, 400, 300);

        primaryStage.setTitle("Employee Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create employee table
    private void createEmployeeTable() {
        employeeTable = new TableView<>();
        TableColumn<Employee, String> idColumn = new TableColumn<>("Employee ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());

        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Employee, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty());

        TableColumn<Employee, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        TableColumn<Employee, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());

        employeeTable.getColumns().addAll(idColumn, nameColumn, ageColumn, emailColumn, departmentColumn);
    }

    // Register employee
    private void registerEmployee() {
        String id = employeeIdField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
        String email = emailField.getText();
        String department = departmentField.getText();

        Employee employee = new Employee(id, name, age, email, department);
        employeeTable.getItems().add(employee);

        // Clear fields after registration
        employeeIdField.clear();
        nameField.clear();
        ageField.clear();
        emailField.clear();
        departmentField.clear();
    }

    // View registered employees
    private void viewEmployees() {
        Stage stage = new Stage();
        stage.setTitle("Registered Employees");
        stage.setScene(new Scene(employeeTable, 600, 400));
        stage.show();
    }

    // Update employee information
    private void updateEmployee() {
        // Implement update functionality here
        System.out.println("Update functionality is not implemented yet.");
    }
}

