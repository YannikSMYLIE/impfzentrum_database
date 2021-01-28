import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Output extends JFrame {
    private final DatabaseConnector connector;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTable table;
    private JPanel outputPanel;

    public Output(DatabaseConnector pConnector) {
        // Panel anzeigen
        add(outputPanel);
        setTitle("Output");
        setSize(400,300);

        // Connector speichern
        this.connector = pConnector;

        // Events speichern
        this.initializeActionListener();
    }

    /**
     * Initialisiert die Aktionen, die bei einem Klick auf einen Button ausgeführt werden sollen.
     *
     * ToDo
     * Implementiere die *actionPerformed()*-Aufträge der jeweiligen Listeners wie unten beschrieben.
     */
    private void initializeActionListener() {
        button1.addActionListener(new ActionListener() {
            /**
             * Ermittelt alle Daten aller Impfzentren und gibt diese in der Tabelle aus.
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                /**
                 * ToDo
                 * Ermittelt alle Daten aller Impfzentren und gibt diese in der Tabelle aus.
                 * Speicher das Statement in einen String und rufe den Auftrag executeStatement() auf.
                 */
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * ToDo
                 * Ermittel wieviele Kunden pro Impfzentrum geimpft werden sollen. Gib die Anzahl der Kunden und den Namen des Impfzentrums aus.
                 */
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * ToDo
                 * Ergänze deine Anfrage aus *Button2* derart, dass zusätzlich die Summe aller an das jeweilige Impfzentrum gelieferten Impfdosen ausgegeben wird.
                 */
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * ToDo
                 * Ergänze deine Anfrage aus *Button3* derart, dass die Anzahl der noch verfügbaren Impfstoffe pro Impfzentrum sowie der Name des jeweiligen Impfzentrums ausgegeben wird. Nutze deine Anfrage aus *Button3* als Untertabelle.
                 */
            }
        });
    }

    /**
     * Führt eine Anfrage aus und überprüft, ob diese ohne Fehler durchgeführt werden konnte.
     * @param statement Das auszuführende Statement.
     *
     * ToDo
     * Führe das als String übergebene Statement aus und lese das *QueryResult* ein.
     *    * Wenn die Anfrage erfolgreich ausgeführt wurde, rufe den Auftrag *putDataInTable* auf.
     *    * Wenn ein Fehler aufgetreten ist, gebe eine Fehlermeldung in der Konsole aus aber beende NICHT das Programm.
     */
    private void executeStatement(String statement) {
        // ToDo: Selber implementieren
        connector.executeStatement(statement);
        if(connector.getErrorMessage() == null) {
            QueryResult queryResult = connector.getCurrentQueryResult();
            putDataInTable(queryResult);
        } else {
            System.out.println("Es ist ein Fehler aufgetreten!");
            System.out.println(connector.getErrorMessage());
        }
    }

    /**
     * Gibt die Daten in einer Tabelle aus.
     * @param pResult Das QueryResult, dessen Daten ausgegeben werden sollen.
     */
    private void putDataInTable(QueryResult pResult) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(pResult.getData(), pResult.getColumnNames());
    }
}
