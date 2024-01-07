import java.util.UUID;

public class Tablet implements Prodotti {
    private UUID id;
    private String articolo;
    private String produttore;
    private String modello;
    private double dimensioneDisplay;
    private String spazioArchiviazione;
    private double prezzoAquisto;
    private double prezzoVendita;

    public Tablet (String articolo, String produttore, String modello, double dimensioneDisplay, String spazioArchiviazione, double prezzoAquisto, double prezzoVendita) {
        this.id = generateID();
        this.articolo = articolo;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.spazioArchiviazione = spazioArchiviazione;
        this.prezzoAquisto = prezzoAquisto;
        this.prezzoVendita = prezzoVendita;
    }
    // Method to generate a unique ID for the notebook
    private UUID generateID() {
        return UUID.randomUUID();
    }
    public String getId() {
        return id.toString();
    }
    public String getArticolo() {
        return articolo;
    }
    public String getProduttore() {
        return produttore;
    }
    public String getModello() {
        return modello;
    }
    public double getDimensioneDisplay() {
        return dimensioneDisplay;
    }

    public String getSpazioArchiviazione() {
        return spazioArchiviazione;
    }

    public double getPrezzoAquisto() {
        return prezzoAquisto;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }
    public void displayInfo() {
        System.out.println("Tablet ID: " + id);
        System.out.println("Tipo: " + articolo);
        System.out.println("Produttore: " + produttore);
        System.out.println("Modello: " + modello);
        System.out.println("Dimensione display: " + dimensioneDisplay);
        System.out.println("Spazio di archiviazione: " + spazioArchiviazione);
        System.out.println("Prezzo di aquisto: $" + prezzoAquisto);
        System.out.println("Prezzo di vendita: $" + prezzoVendita);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "id=" + id +
                ", articolo='" + articolo + '\'' +
                ", produttore='" + produttore + '\'' +
                ", modello='" + modello + '\'' +
                ", dimensioneDisplay=" + dimensioneDisplay +
                ", spazioArchiviazione='" + spazioArchiviazione + '\'' +
                ", prezzoAquisto=" + prezzoAquisto +
                ", prezzoVendita=" + prezzoVendita +
                '}';
    }
}
