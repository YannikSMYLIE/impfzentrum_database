import javax.swing.*;

public class Login extends JFrame {
    private JPanel loginPanel;
    private JTextField username;
    private JPasswordField password;
    private JButton connect;
    private JTextField ip;
    private JTextField port;
    private JTextField database;

    public Login() {
        // Fenster initialisieren
        add(loginPanel);
        setTitle("Login");
        setSize(400,300);
        setVisible(true);
    }

    /**
     * Gibt den Submit-Button zurück.
     * @return
     */
    public JButton getSubmitButton() {
        return connect;
    }

    /**
     * Gibt die eingegebenen Daten zurück.
     * @return
     */
    public String[] getData() {
        String[] returnvalue = {username.getText(), new String(password.getPassword()), ip.getText(), port.getText(), database.getText()};
        return returnvalue;
    }
}
