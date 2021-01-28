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
                String statement = "SELECT * FROM kunde";
                connector.executeStatement(statement);
                if(connector.getErrorMessage() == null) {
                    QueryResult queryResult = connector.getCurrentQueryResult();
                    putDataInTable(queryResult);
                } else {
                    System.out.println("Es ist ein Fehler aufgetreten!");
                    System.out.println(connector.getErrorMessage());
                }

            }
        });
        action2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
     * Gibt die Daten in einer Tabelle aus.
     * @param pResult Das QueryResult, dessen Daten ausgegeben werden sollen.
     */
    private void putDataInTable(QueryResult pResult) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(pResult.getData(), pResult.getColumnNames());
    }
}
