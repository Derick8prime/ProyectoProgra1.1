
import java.awt.Button;
import java.awt.TextField;
import javax.swing.text.html.ListView;



public class TicketSystem extends Application {

    private static void launch(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private ObservableList<String> tickets = FXCollections.observableArrayList();
    private ListView<String> ticketListView = new ListView<>(tickets);
    private TextField ticketInput = new TextField();
    private Button addButton = new Button("Crear Ticket");
    private Button removeButton = new Button("Cancelar Ticket");
    private Button registerButton = new Button("Registrar Cambios");
    private Button createUserButton = new Button("Crear Usuario (Admin)");
    private Button deleteUserButton = new Button("Eliminar Usuario (Admin)");

    @Override
    public void start(Stage primaryStage) {
        addButton.setOnAction(e -> createTicket());
        removeButton.setOnAction(e -> cancelTicket());
        registerButton.setOnAction(e -> registerChanges());
        createUserButton.setOnAction(e -> createUser());
        deleteUserButton.setOnAction(e -> deleteUser());

        VBox layout = new VBox(10, ticketInput, addButton, removeButton, ticketListView, registerButton, createUserButton, deleteUserButton);
        Scene scene = new Scene(layout, 400, 400);
        
        primaryStage.setTitle("Sistema de Tickets");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createTicket() {
        String ticket = ticketInput.getText();
        if (!ticket.isEmpty()) {
            tickets.add(ticket);
            ticketInput.clear();
        }
    }

    private void cancelTicket() {
        String selected = ticketListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tickets.remove(selected);
        }
    }

    private void registerChanges() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cambios registrados con éxito.");
        alert.showAndWait();
    }

    private void createUser() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Usuario creado (Solo admin)." );
        alert.showAndWait();
    }

    private void deleteUser() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Usuario eliminado (Solo admin)." );
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
