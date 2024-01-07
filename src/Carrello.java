import java.util.ArrayList;


public class Carrello {

    private final ArrayList<Prodotto> prodotti = new ArrayList<>();

    public void visualizzaCarrello() {
        if (prodotti.isEmpty()) {
            System.out.println("Il carrello è vuoto");
        } else {
            System.out.println("Carrello: ");
            for (Prodotto prodotto : prodotti) {
                System.out.println("Tipo: " + prodotto.getArticolo() + ", Produttore: " + prodotto.getProduttore() + ", Modello: " + prodotto.getModello());
            }
            System.out.println("\n");
        }
    }

    public double carrelloTot() {
        double spesaTot = 0.0;
        for (Prodotto prodotto : prodotti) {
            spesaTot += prodotto.getPrezzoVendita();
        }
        return spesaTot;
    }

    public void concludiVendita(Magazzino magazzino) {
        System.out.println("Vendita conclusa");
        for (Prodotto prodotto : prodotti) {
            magazzino.scaricoProdotto(prodotto);
        }
        prodotti.clear();
    }

    public ArrayList<Prodotto> aggiungiAlCarrello(Magazzino magazzino, String id) {
        boolean aggiunto = false;
        for (Prodotto prodotto : magazzino.getNotebooks()) {
            if (prodotto.getId().equals(id)) {
                aggiunto = true;
                prodotti.add(prodotto);
                System.out.println("Notebook aggiunto al carrello");
            }
        }
        for (Prodotto prodotto : magazzino.getSmartphones()) {
            if (prodotto.getId().equals(id)) {
                aggiunto = true;
                prodotti.add(prodotto);
                System.out.println("Smartphone aggiunto al carrello");
            }
        }
        for (Prodotto prodotto : magazzino.getTablets()) {
            if (prodotto.getId().equals(id)) {
                aggiunto = true;
                prodotti.add(prodotto);
                System.out.println("Tablet aggiunto al carrello");
            }
        }
        if (!aggiunto) {
            System.out.println("Prodotto non trovato tramite ID");
        }
        return prodotti;
    }
    public ArrayList<Prodotto> rimuoviDalCarrello(String id) {
        boolean trovato = false;
        Prodotto prod = null;
        for (Prodotto prodotto : prodotti) {
            if (prodotto.getId().equals(id)) {
                prod = prodotto;
                trovato = true;
                System.out.println("Prodotto rimosso dal carrello");
            }
        }
        if (trovato) {
            prodotti.remove(prod);
            System.out.println("Prodotto non presente nel carrello");
        }
        return prodotti;
    }
}
