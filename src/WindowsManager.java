import abitur.DatabaseConnector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Der WindowsManager verwaltet die beiden Fenster dieses Projektrahmens.
 * Es gibt einmal das Login-Fenster. Hier können die Daten des Servers angegeben werden damit eine Verbindung hergestellt werden kann.
 * Das Output-Fenster erscheint sobald eine Verbindung mit der Datenbank hergestellt wurde. Hier können dann Anfragen ausgeführt werden. Die Ergebnisse werden in einer Tabelle dargestellt.
 */
public class WindowsManager {
    private final Login loginWindow;
    private Output outputWindow;

    public WindowsManager() {
        // Loginfenster erzeugen und anzeigen
        loginWindow = new Login();

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
                connectToDatabase(ip, Integer.parseInt(port), database, username, password);
            }
        });
    }

    /**
     * Stellt eine Verbindung mit einer Datenbank her.
     * @param pIp Der Server auf der Datenbank-Server liegt.
     * @param pPort Der Port über den auf den Datenbank-Server zugegriffen werden soll.
     * @param pDatabase Der Name der Datenbank welche verwendet werden soll.
     * @param pUsername Der Benutzername des Datenbank-Benutzers.
     * @param pPassword Das Passwort des Datenbank-Benutzers.
     */
    private void connectToDatabase(String pIp, int pPort, String pDatabase, String pUsername, String pPassword) {
        /**
         * ToDO: Implementieren
         * Ergänze den Auftrag so, dass mit Hilfe der Klasse *abitur.DatabaseConnector* eine Verbindung mit der Datenbank hergestellt wird.
         *    Prüfe ob die Verbindung erfolgreich hergestellt wurde:
         *    * Wurde die Verbindung erfolgreich hergestellt, rufe den Auftrag *conntected(...)* auf.
         *    * Wenn ein Fehler auftritt gebe eine Fehlermeldung aus und terminiere das Programm.
         */
        DatabaseConnector connector = new DatabaseConnector(pIp, pPort, pDatabase, pUsername, pPassword);

        if (connector.getErrorMessage() != null) {
            System.out.println("Es konnte keine Verbindung zur Datenbank hergestellt werden!");
            System.out.println(connector.getErrorMessage());
        } else {
            conntected(connector);
        }
    }

    /**
     * Wird aufgerufen wenn die Verbindung mit der Datenbank erfolgreich hergestellt wurde.
     * @param pConnector Der abitur.DatabaseConnector welcher mit der Datenbank verbunden ist.
     */
    private void conntected(DatabaseConnector pConnector) {
        // Loginfenster ausblenden
        this.loginWindow.setVisible(false);

        // Abfragefenster initialisieren
        this.outputWindow = new Output(pConnector);
    }
}