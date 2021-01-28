import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsManager {
    private final Login loginWindow;

    public WindowsManager() {
        // Loginfenster erzeugen und anzeigen
        loginWindow = new Login();
        loginWindow.setVisible(true);

        /**
         * ActionListener für Absenden von Login-Daten
         * Wird ausgelöst, wenn der Button im Formular geklickt wird.
         */
        loginWindow.getSubmitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Daten einlesen
                String[] data = loginWindow.getData();
                String username = data[0];
                String password = data[1];
                String ip = data[2];
                String port = data[3];
                String database = data[4];

                // Verbindung herstellen
                connectToDatabase(username, password, ip, Integer.parseInt(port), database);
            }
        });
    }

    /**
     * Stellt eine Verbindung mit einer Datenbank her.
     * @param username Der Benutzername des Datenbank-Benutzers.
     * @param password Das Passwort des Datenbank-Benutzers.
     * @param ip Der Server auf der Datenbank-Server liegt.
     * @param port Der Port über den auf den Datenbank-Server zugegriffen werden soll.
     * @param database Der Name der Datenbank welche verwendet werden soll.
     */
    private void connectToDatabase(String username, String password, String ip, int port, String database) {
        /**
         * ToDO: Implementieren
         * Ergänze den Auftrag so, dass mit Hilfe der Klasse *DatabaseConnector* eine Verbindung mit der Datenbank hergestellt wird.
         *    Prüfe ob die Verbindung erfolgreich hergestellt wurde:
         *    * Wurde die Verbindung erfolgreich hergestellt, rufe den Auftrag *success(...)* auf.
         *    * Wenn ein Fehler auftritt gebe eine Fehlermeldung aus und terminiere das Programm.
         */
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