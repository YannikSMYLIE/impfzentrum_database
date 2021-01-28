import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Output extends JFrame {
    private final DatabaseConnector connector;
    private JButton button1;
    private JButton action2Button;
    private JButton action3Button;
    private JButton action4Button;
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
     */
    private void initializeActionListener() {
        button1.addActionListener(new ActionListener() {
            /**
             * Ermittelt alle Daten aller Impfzentren und gibt diese in der Tabelle aus.
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String statement = "SELECT zentrum_bezeichnung, 5-3 FROM kunde";
                executeStatement(statement);
            }
        });
        action2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String statement = "SELECT innertable.bezeichnung, (innertable.stoff_amount - innertable.kunden_amount) as rest\n" +
                "FROM (\n" +
                "     SELECT impfzentrum.bezeichnung, count(*) as kunden_amount, sum(beliefern.menge) as stoff_amount\n" +
                "     FROM kunde\n" +
                "              JOIN impfzentrum ON kunde.zentrum_bezeichnung = impfzentrum.bezeichnung\n" +
                "              JOIN beliefern on kunde.zentrum_bezeichnung = beliefern.zentrum_bezeichnung\n" +
                "     GROUP BY impfzentrum.bezeichnung\n" +
                " ) as innertable\n" +
                "ORDER BY rest DESC\n" +
                "LIMIT 1";
                executeStatement(statement);
            }
        });
        action3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        action4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /**
     * Führt eine Anfrage aus und überprüft, ob diese ohne Fehler durchgeführt werden konnte.
     * @param statement Das auszuführende Statement.
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
