import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsManager {
    private final Login loginWindow;
    private Output outputWindow;
    private DatabaseConnector connector;

    public WindowsManager() {
        loginWindow = new Login();
        loginWindow.setVisible(true);


        loginWindow.getSubmitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Daten einlesen
                String[] data = loginWindow.getData();
                String username = data[0];
                String password = data[1];
                String server = data[2];
                String port = data[3];
                String database = data[4];

                // Verbindung herstellen
                connectToDatabase(username, password, server, Integer.parseInt(port), database);
            }
        });
    }

    private void connectToDatabase(String username, String password, String server, int port, String database) {
        System.out.println("Verbindung mit der Datenbank wird hergestellt mir folgenden Daten:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Server: " + server);
        System.out.println("Port: " + port);
        System.out.println("Datenbank: " + database);
        connector = new DatabaseConnector(server, port, database, username, password);

        if (connector.getErrorMessage() != null) {
            System.out.println("Es konnte keine Verbindung zur Datenbank hergestellt werden!");
            System.out.println(connector.getErrorMessage());
        } else {
            // Login Window verbergen
            loginWindow.setVisible(false);

            // Abfrage Windows starten
            outputWindow = new Output(connector);
            outputWindow.setVisible(true);
        }
    }
}