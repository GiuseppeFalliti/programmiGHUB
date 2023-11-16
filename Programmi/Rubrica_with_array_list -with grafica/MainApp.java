import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {

    private JPanel buttonPanel;
    private Rubrica r1;

    public MainApp() {
        r1 = new Rubrica();
        setTitle("Rubrica");
        setSize(400, 400);
        setLocationRelativeTo(null);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));
        /*
         * richiamo del metodo createButton che crea i bottoni e associandoli ai metodi
         * con l'actionListener
         */
        createButton("Add Contact", e -> addContact());
        createButton("Delete Contact", e -> deleteContact());
        createButton("Search Contact by Date", e -> searchContactByDate());
        createButton("Search Contact by Name and Surname", e -> searchContactByName());
        createButton("Edit Contact", e -> editContact());
        createButton("Add to Favorites", e -> addToFavorites());
        createButton("Edit Favorites Contact", e -> editFavoritesContact());
        createButton("Print All Favorites Contacts", e -> printFavoritesContacts());
        createButton("Print All Contacts", e -> printAllContacts());
        createButton("Exit", e -> System.exit(0));

        add(buttonPanel);
        setVisible(true);
    }

    /**
     * creo un void che contiene la creazione del bottone con tutte le sue
     * caratteristiche per
     * non essere ripetitivi.
     * 
     * @param label    //il nome del bottone
     * @param listener // oggetto listener che richiama il metodo della classe
     *                 rubrica con il void actionPerformed
     */
    private void createButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setBackground(new Color(80, 80, 80));
        button.setForeground(new Color(255, 255, 255));// 160 160 160
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.addActionListener(listener);
        buttonPanel.add(button);
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    private void addContact() {
        String nomeContatto = JOptionPane.showInputDialog("Inserisci il nome del contatto");
        String cognomeContatto = JOptionPane.showInputDialog("Inserisci il cognome del contatto");
        String numeroContatto = JOptionPane.showInputDialog("Inserisci il numero del contatto");
        String day = JOptionPane.showInputDialog("Inserisci il day di aggiunta del contatto");
        String month = JOptionPane.showInputDialog("Inserisci il month di aggiunta del contatto");
        String year = JOptionPane.showInputDialog("Inserisci il year di aggiunta del contatto");
        int stringday = Integer.parseInt(day);
        int stringMonth = Integer.parseInt(month);
        int stringYears = Integer.parseInt(year);
        r1.addContact(nomeContatto, cognomeContatto, numeroContatto, stringMonth, stringYears, stringday);
        
    }

    private void deleteContact() {
        JOptionPane.showMessageDialog(this, "inserisci il nome e il cognome del contatto da eliminare");
        String subNameRubrics = JOptionPane.showInputDialog("nome");
        String subCognomeRubrics = JOptionPane.showInputDialog("cognome");
        r1.subbNumber(subNameRubrics, subCognomeRubrics);
        showMessage("Il contatto è stato eliminato con successo!", "conferma!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchContactByDate() {
        String dataContact = JOptionPane.showInputDialog("inserisci la data: ");
        r1.searchNomeAndCognome(dataContact);
    }

    private void searchContactByName() {
        String nomeContattoesistente = JOptionPane.showInputDialog("inserire il nome del contatto");
        String cognomeContattoesistente = JOptionPane.showInputDialog("inserisci il cognome del contatto");
        JOptionPane.showMessageDialog(this, r1.Numero(nomeContattoesistente, cognomeContattoesistente));
    }

    private void editContact() {
        String nome = JOptionPane.showInputDialog("inserisci il nome del contatto da modificare:");
        String cognome = JOptionPane.showInputDialog("inserisci il cognome del contatto da modificare:");
        String numers = JOptionPane.showInputDialog("inserisci il nuovo numero del contatto");
        System.out.println();
        Contatto contatto = r1.editContact(nome, cognome, numers);
        if (contatto != null) {
            JOptionPane.showMessageDialog(this, contatto.toString(), "Dettagli del contatto",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "contatto non trovato");
        }
    }

    private void addToFavorites() {
        String nome = JOptionPane.showInputDialog("inserisci il nome del contatto");
        String cognome = JOptionPane.showInputDialog("inserisci il cognome del contatto");
        r1.AddfavitesContacts(nome, cognome);
        showMessage("Il contatto è stato aggiunto con successo!", "conferma!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void editFavoritesContact() {
        String nome = JOptionPane.showInputDialog("inserisci il nome del contatto preferito da modificare:");
        String cognome = JOptionPane.showInputDialog("inserisci il cognome del contatto preferito da modificare:");
        String numers = JOptionPane.showInputDialog("inserisci il nuovo numero del contatto preferito");
        System.out.println();
        Contatto contatto = r1.editContactFavorites(nome, cognome, numers);
        if (contatto != null) {
            JOptionPane.showMessageDialog(this, contatto.toString(), "Dettagli del contatto",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "contatto non trovato");
        }
    }

    private void printFavoritesContacts() {
        r1.printAllFavitesContacts();
    }

    private void printAllContacts() {
        r1.printAllContact();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // avvia il tutto in safe mode
            new MainApp();
        });
    }
}