import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsManager {
    private final Login loginWindow;

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

    /**
     * Stellt eine Verbindung mit einer Datenbank her.
     * @param username Der Benutzername des Datenbank-Benutzers.
     * @param password Das Passwort des Datenbank-Benutzers.
     * @param server Der Server auf der Datenbank-Server liegt.
     * @param port Der Port über den auf den Datenbank-Server zugegriffen werden soll.
     * @param database Der Name der Datenbank welche verwendet werden soll.
     */
    private void connectToDatabase(String username, String password, String server, int port, String database) {
        // ToDO: Implementieren
        DatabaseConnector connector = new DatabaseConnector(server, port, database, username, password);

        if (connector.getErrorMessage() != null) {
            System.out.println("Es konnte keine Verbindung zur Datenbank hergestellt werden!");
            System.out.println(connector.getErrorMessage());
        } else {
            success(connector);
        }
    }

    /**
     * Wird aufgerufen wenn die Verbindung mit der Datenbank erfolgreich hergestellt wurde.
     * @param connector Der DatabaseConnector welcher mit der Datenbank verbunden ist.
     */
    private void success(DatabaseConnector connector) {
        // Login Window verbergen
        loginWindow.setVisible(false);

        // Abfrage Windows starten
        Output outputWindow = new Output(connector);
        outputWindow.setVisible(true);
    }
}