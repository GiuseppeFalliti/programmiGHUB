import java.time.LocalDate;
public class Contatto {

    private String nome; // nome
    private String cognome; // cognome
    private String numero_telefono; // numero di telefono
    private LocalDate dataNascita;


     public Contatto(String nome, String cognome, String numero_telefono, LocalDate dataNascita) { // costruttore with object
        this.nome = nome;
        this.cognome = cognome;
        this.numero_telefono = numero_telefono;
        this.dataNascita = dataNascita;

    }

    public Contatto(String nome, String cognome, String numero_telefono) { // solo nome cognome e telefono.
        this.nome = nome;
        this.cognome = cognome;
        this.numero_telefono = numero_telefono;

    }

    public Contatto(String nome, String cognome) { // solo nome cognome
        this.nome = nome;
        this.cognome = cognome;

    }

    public LocalDate getData() {
        return dataNascita;
    }

    public void setData(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero_telefono(String numero_telefono) {

        this.numero_telefono = numero_telefono;
    }

    public Contatto getNome_cognome(String nome, String cognome) {
        Contatto contatto = new Contatto(nome, cognome);

        return contatto;
    }

    
    @Override
    public String toString() {
        String stampa = "cognome: " + cognome + "\n";
        stampa += "nome: " + nome + "\n";
        stampa += "numero telefono: " + numero_telefono + "\n";
        if (dataNascita != null) {
            stampa += "data add contact: " + dataNascita.toString() + "\n";
        } else {
            stampa += "data add contact: N/A\n";
        }
        return stampa;
    }

  

}