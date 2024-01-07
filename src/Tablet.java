public class Tablet extends Prodotto {

    public Tablet(String produttore, String modello, double dimensioneDisplay, String spazioArchiviazione, double prezzoAquisto, double prezzoVendita) {
        super(TipoProdotto.TABLET, produttore, modello, dimensioneDisplay, spazioArchiviazione, prezzoAquisto, prezzoVendita);
    }

    @Override
    public String toString() {
        return "Tablet{" + super.toString();
    }
}
