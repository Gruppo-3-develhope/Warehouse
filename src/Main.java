import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Magazzino {

    private final ArrayList<Prodotto> prodotti = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Magazzino() {
    }

    public void inizializzaMagazzino() {
        prodotti.add(new Smartphone("Samsung", "Galaxy S3", 8.0, "128GB", 400.00, 500.00));
        prodotti.add(new Smartphone("Samsung", "Galaxy S4", 7.0, "256GB", 400.00, 500.00));
        prodotti.add(new Smartphone("Apple", "iPhone 15 Pro", 8.0, "128GB", 800.00, 1500.00));
        prodotti.add(new Notebook("ASUS", "VivoBook", 16.0, "512GB", 400.00, 500.00));
        prodotti.add(new Tablet("Samsung", "Galaxy Tab S3", 8.0, "128GB", 400.00, 500.00));
    }

    public void inserimentoProdotto(Prodotto prodotto) throws IOException {
        prodotti.add(prodotto);
    }

    public void inserimentoProdotto() throws IOException {
        int tipo = richiediTipoProdotto();

        Prodotto prodotto;

        System.out.println("\nInserisci il produttore");
        String produttore = sc.nextLine();
        System.out.println("\nInserisci il modello");
        String modello = sc.nextLine();
        System.out.println("\nInserisci dimensione display");
        double dimensioneDisplay = Double.parseDouble(sc.nextLine());
        System.out.println("\nInserisci lo spazio di archiviazione");
        String spazioArchiviazione = sc.nextLine();
        System.out.println("\nInserisci il prezzo di acquisto");
        double prezzoAquisto = Double.parseDouble(sc.nextLine());
        System.out.println("\nInserisci il prezzo di vendita");
        double prezzoVendita = Double.parseDouble(sc.nextLine());

        switch (tipo) {
            case 1: {
                prodotto = new Notebook(produttore, modello, dimensioneDisplay, spazioArchiviazione, prezzoAquisto, prezzoVendita);
                inserimentoProdotto(prodotto);
            }
            break;
            case 2: {
                prodotto = new Smartphone(produttore, modello, dimensioneDisplay, spazioArchiviazione, prezzoAquisto, prezzoVendita);
                inserimentoProdotto(prodotto);
            }
            break;
            case 3: {
                prodotto = new Tablet(produttore, modello, dimensioneDisplay, spazioArchiviazione, prezzoAquisto, prezzoVendita);
                inserimentoProdotto(prodotto);
            }
            break;
        }
    }

    public void scaricoProdotto(Prodotto prodotto) {
        prodotti.remove(prodotto);
    }


    public void scaricoMerce() throws IOException {
        prodotti.clear();
        System.out.println("Magazzino svuotato");
    }

    public void scaricoMerceTramiteId() {
        System.out.println("Inserisci l'id del prodotto da scaricare");
        String id = sc.nextLine();
        boolean trovato = false;
        for (int i = 0; i < prodotti.size() && !trovato; i++) {
            Prodotto prodotto = prodotti.get(i);
            if (prodotto.getId().equals(id)) {
                scaricoProdotto(prodotto);
                break;
            }
        }
        if (!trovato) {
            System.out.println("Nessun prodotto trovato!");
        }
    }

    public void stampaMagazzino() {
        System.out.println("I prodotti presenti in magazzino sono i seguenti:");
        for (Prodotto prodotto : prodotti) {
            prodotto.displayInfo();
            System.out.println("********************************");
        }
    }

    public List<Prodotto> ricercaTipo() throws Exception {
        int tipo = richiediTipoProdotto();

        TipoProdotto tipoProdotto = switch (tipo) {
            case 1 -> TipoProdotto.NOTEBOOK;
            case 2 -> TipoProdotto.SMARTPHONE;
            default -> TipoProdotto.TABLET;
        };

        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getArticolo().equals(tipoProdotto)).toList();
        if (prodottiTrovati.isEmpty()) {
            System.out.println("Nessun " + tipoProdotto.name() + " trovato!");
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaProduttore() throws Exception {
        System.out.println("Inserisci il produttore da ricercare");
        String produttore = sc.nextLine();
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getProduttore().equals(produttore)).toList();
        if (prodottiTrovati.isEmpty()) {
            System.out.println("Nessun produttore " + produttore + " trovato!");
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaModello() throws Exception {
        System.out.println("Inserisci il modello da ricercare");
        String modello = sc.nextLine();
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getModello().equals(modello)).toList();
        if (prodottiTrovati.isEmpty()) {
            System.out.println("Nessun modello " + modello + " trovato!");
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaPrezzoAcquisto() throws Exception {
        System.out.println("Inserisci il prezzo di acquisto da ricercare");
        double prezzoDiAcquisto = Double.parseDouble(sc.nextLine());
        ArrayList<Prodotto> prodottiTrovati = (ArrayList<Prodotto>) prodotti.stream().filter((p) -> p.getPrezzoAquisto() == prezzoDiAcquisto).toList();
        if (prodottiTrovati.isEmpty()) {
            System.out.println("Nessun prezzo di acquisto di " + prezzoDiAcquisto + " trovato!");
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaPrezzoVendita() throws Exception {
        System.out.println("Inserisci il prezzo di vendita da ricercare");
        double prezzoDiVendita = Double.parseDouble(sc.nextLine());
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getPrezzoVendita() == prezzoDiVendita).toList();
        if (prodottiTrovati.isEmpty()) {
            System.out.println("Nessun prezzo di vendita di " + prezzoDiVendita + " trovato!");
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaRangeDiPrezzo() throws Exception {
        System.out.println("Inserisci il prezzo minimo da ricercare");
        double prezzoDiVenditaMinimo = Double.parseDouble(sc.nextLine());
        System.out.println("Inserisci il prezzo massimo da ricercare");
        double prezzoDiVenditaMassimo = Double.parseDouble(sc.nextLine());
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getPrezzoVendita() > prezzoDiVenditaMinimo && p.getPrezzoVendita() < prezzoDiVenditaMassimo).toList();
        if (prodottiTrovati.isEmpty()) {
            System.out.println("Nessun prezzo di vendita nel range " + prezzoDiVenditaMinimo + " - " + prezzoDiVenditaMassimo + " trovato!");
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public int contaProdotti() throws IOException {
        return prodotti.size();
    }

    public int contaNotebooks() throws IOException {
        return getNotebooks().size();
    }

    public int contaTablets() throws IOException {
        return getTablets().size();
    }

    public int contaSmartphones() throws IOException {
        return getSmartphones().size();
    }

    public List<Prodotto> getNotebooks() {
        return prodotti.stream().filter((p) -> p.getArticolo() == TipoProdotto.NOTEBOOK).toList();
    }

    public void setNotebooks(ArrayList<Notebook> notebooks) {
        prodotti.removeAll(prodotti.stream().filter((p) -> p.getArticolo() == TipoProdotto.NOTEBOOK).toList());
        prodotti.addAll(notebooks);
    }

    public List<Prodotto> getSmartphones() {
        return prodotti.stream().filter((p) -> p.getArticolo() == TipoProdotto.SMARTPHONE).toList();
    }

    public void setSmartphones(ArrayList<Smartphone> smartphones) {
        prodotti.removeAll(prodotti.stream().filter((p) -> p.getArticolo() == TipoProdotto.SMARTPHONE).toList());
        prodotti.addAll(smartphones);
    }

    public List<Prodotto> getTablets() {
        return prodotti.stream().filter((p) -> p.getArticolo() == TipoProdotto.TABLET).toList();
    }

    public void setTablets(ArrayList<Tablet> tablets) {
        prodotti.removeAll(prodotti.stream().filter((p) -> p.getArticolo() == TipoProdotto.TABLET).toList());
        prodotti.addAll(tablets);
    }

    private int richiediTipoProdotto() {
        int tipo = 0;
        do {
            System.out.println("Inserisci il tipo di articolo da ricercare");
            System.out.println("1 Notebook");
            System.out.println("2 Smartphone");
            System.out.println("3 Tablet\n");
            tipo = Integer.parseInt(sc.nextLine());
        } while (tipo < 1 || tipo > 3);
        return tipo;
    }
}