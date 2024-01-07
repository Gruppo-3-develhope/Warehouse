import java.util.UUID;

public abstract class Prodotto {
    protected UUID id;
    protected TipoProdotto articolo;
    protected String produttore;
    protected String modello;
    protected double dimensioneDisplay;
    protected String spazioArchiviazione;
    protected double prezzoAquisto;
    protected double prezzoVendita;

    public Prodotto(TipoProdotto articolo, String produttore, String modello, double dimensioneDisplay, String spazioArchiviazione, double prezzoAquisto, double prezzoVendita) {
        this.id = generateID();
        this.articolo = articolo;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.spazioArchiviazione = spazioArchiviazione;
        this.prezzoAquisto = prezzoAquisto;
        this.prezzoVendita = prezzoVendita;
    }

    private UUID generateID() {
        return UUID.randomUUID();
    }

    public String getId() {
        return id.toString();
    }

    public TipoProdotto getArticolo() {
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
        System.out.println("ID Prodotto: " + id);
        System.out.println("Tipo: " + articolo.name());
        System.out.println("Produttore: " + produttore);
        System.out.println("Modello: " + modello);
        System.out.println("Dimensione display: " + dimensioneDisplay);
        System.out.println("Spazio di archiviazione: " + spazioArchiviazione);
        System.out.println("Prezzo di aquisto: $" + prezzoAquisto);
        System.out.println("Prezzo di vendita: $" + prezzoVendita);
    }

    @Override
    public String toString() {
        return "id=" + id + ", articolo='" + articolo + '\'' + ", produttore='" + produttore + '\'' + ", modello='" + modello + '\'' + ", dimensioneDisplay=" + dimensioneDisplay + ", spazioArchiviazione='" + spazioArchiviazione + '\'' + ", prezzoAquisto=" + prezzoAquisto + ", prezzoVendita=" + prezzoVendita + '}';
    }
}