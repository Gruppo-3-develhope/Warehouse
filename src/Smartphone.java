public class Smartphone extends Prodotto {

    public Smartphone(String produttore, String modello, double dimensioneDisplay, String spazioArchiviazione, double prezzoAquisto, double prezzoVendita) {
        super(TipoProdotto.SMARTPHONE, produttore, modello, dimensioneDisplay, spazioArchiviazione, prezzoAquisto, prezzoVendita);
    }

    @Override
    public String toString() {
        return "Smartphone{" + super.toString();
    }
}


