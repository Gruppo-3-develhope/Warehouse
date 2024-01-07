public class Notebook extends Prodotto {

    public Notebook(String produttore, String modello, double dimensioneDisplay, String spazioArchiviazione, double prezzoAquisto, double prezzoVendita) {
        super(TipoProdotto.NOTEBOOK, produttore, modello, dimensioneDisplay, spazioArchiviazione, prezzoAquisto, prezzoVendita);
    }

    @Override
    public String toString() {
        return "Notebook{" + super.toString();
    }
}
