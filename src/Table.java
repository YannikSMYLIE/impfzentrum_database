import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

public class Table extends JTable {
    private String[] header;
    private List<String[]> rows;

    /**
     * Legt die Spalten fest. Dabei werden alle bisherigen Daten gelöscht.
     * @param pHeader Der Header der Tabelle.
     */
    public void setHeader(String[] pHeader) {
        this.header = pHeader;
        this.rows = new LinkedList<String[]>();
    }

    /**
     * Fügt der Tabelle einen Datensatz hinzu.
     * @param pRow Die Daten welche hinzugefügt werden sollen.
     * @throws Exception Fehlermeldung, wenn die Anzahl von Spalten der Row nicht mit den Anzahl der Spalten des Headers übereinstimmen.
     */
    public void addRow(String[] pRow) throws Exception {
        if(this.header.length != pRow.length) {
            throw new Exception("Die Anzahl der Spalten von Header und Row stimmen nicht überein!");
        }
        this.rows.add(pRow);
    }

    /**
     * Leert die Tabelle
     */
    public void reset() {
        this.header = null;
        this.rows = null;
    }

    /**
     * Rendert die Liste.
     * @throws Exception Gibt eine Fehlermeldung wenn noch keine Daten hinzugefügt wurden.
     */
    public void render() throws Exception {
        if(this.header == null) {
            throw new Exception("Es wurden noch keine Daten eingepflegt!");
        }

        DefaultTableModel model = (DefaultTableModel) this.getModel();
        String[][] test = this.rows.toArray(new String[this.rows.size()][]);
        model.setDataVector(test, this.header);
    }
}
