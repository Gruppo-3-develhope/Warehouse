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


    public void inserimentoProdotto(int tipo) throws IOException {

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

    public List<Prodotto> ricercaTipo(int tipo) throws Exception {
        TipoProdotto tipoProdotto = switch (tipo) {
            case 1 -> TipoProdotto.NOTEBOOK;
            case 2 -> TipoProdotto.SMARTPHONE;
            default -> TipoProdotto.TABLET;
        };
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getArticolo().equals(tipoProdotto)).toList();
        if (prodottiTrovati.isEmpty()) {
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaProduttore(String produttore) throws Exception {
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getProduttore().equalsIgnoreCase(produttore)).toList();
        if (prodottiTrovati.isEmpty()) {
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaModello(String modello) throws Exception {
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getModello().equalsIgnoreCase(modello)).toList();
        if (prodottiTrovati.isEmpty()) {
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaPrezzoAcquisto(double purchasePrice) throws Exception {
        ArrayList<Prodotto> prodottiTrovati = (ArrayList<Prodotto>) prodotti.stream().filter((p) -> p.getPrezzoAquisto() == purchasePrice).toList();
        if (prodottiTrovati.isEmpty()) {
            throw new Exception("Not Found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaPrezzoVendita(double sellingPrice) throws Exception {
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) -> p.getPrezzoVendita() == sellingPrice).toList();
        if (prodottiTrovati.isEmpty()) {
            throw new Exception("Not found");
        }
        return prodottiTrovati;
    }

    public List<Prodotto> ricercaRangeDiPrezzo(double prezzoDiVenditaMinimo, double prezzoDiVenditaMassimo) throws Exception {
        List<Prodotto> prodottiTrovati = prodotti.stream().filter((p) ->
                p.getPrezzoVendita() >= prezzoDiVenditaMinimo && p.getPrezzoVendita() <= prezzoDiVenditaMassimo).toList();
        if (prodottiTrovati.isEmpty()) {
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

//    public int richiediTipoProdotto(int tipo) {
//        do {
//            System.out.println("Inserisci il tipo di articolo da ricercare");
//            System.out.println("1 Notebook");
//            System.out.println("2 Smartphone");
//            System.out.println("3 Tablet\n");
//        } while (tipo < 1 || tipo > 3);
//        return tipo;
//    }
}




/*import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Magazzino {

    private ArrayList<Notebook> notebooks = new ArrayList<>();
    private ArrayList<Smartphone> smartphones = new ArrayList<Smartphone>();
    private ArrayList<Tablet> tablets = new ArrayList<Tablet>();

    public Magazzino (){}

    Scanner sc = new Scanner(System.in);

    public void inserimentoNotebook(Notebook nb) throws IOException{

        notebooks.add(nb); // In questo modo l'oggetto creato lo salvo nell'aray list.
    }

    public void inserimentoSmartphone(Smartphone sp) throws IOException{

        smartphones.add(sp); // In questo modo l'oggetto creato lo salvo nell'aray list.
    }

    public void inserimentoTablet(Tablet tb) throws IOException{

        tablets.add(tb); // In questo modo l'oggetto creato lo salvo nell'aray list.
    }


    public void inserimentoProdotto() throws IOException{
        int tipo;

        String articolo = "";
        String produttore = "";
        String modello = "";
        double dimensioneDisplay = 0.0;
        String spazioArchiviazione = "";
        double prezzoAquisto = 0;
        double prezzoVendita = 0;

        System.out.println("Che prodotto vuoi inserire?");
        System.out.println("1 Notebook");
        System.out.println("2 Smartphone");
        System.out.println("3 Tablet");

        tipo = sc.nextInt();

        switch(tipo){
            case 1:{
                Notebook nb = new Notebook(articolo,produttore,modello,dimensioneDisplay,spazioArchiviazione, prezzoAquisto, prezzoVendita);
                inserimentoNotebook(nb);
            } break;
            case 2:{
                Smartphone sp = new Smartphone(articolo,produttore,modello,dimensioneDisplay,spazioArchiviazione, prezzoAquisto, prezzoVendita);
                inserimentoSmartphone(sp);
            } break;
            case 3:{
                Tablet tb = new Tablet(articolo,produttore,modello,dimensioneDisplay,spazioArchiviazione, prezzoAquisto, prezzoVendita);
                inserimentoTablet(tb);
            } break;

        }
    }

    public void scaricoNotebook(Notebook nb){
        notebooks.remove(nb);
    }

    public void scaricoSmartphone(Smartphone sm){
        notebooks.remove(sm);
    }

    public void scaricoTablet(Tablet tb){
        notebooks.remove(tb);
    }


    public void scaricoMerce() throws IOException{

        int tipo;
        String articolo = "";
        String produttore = "";
        String modello = "";
        double dimensioneDisplay = 0.0;
        String spazioArchiviazione = "";
        double prezzoAquisto = 0;
        double prezzoVendita = 0;



        System.out.println("Che prodotto vuoi scaricare?");
        System.out.println("1 Notebook");
        System.out.println("2 Smartphone");
        System.out.println("3 Tablet");

        tipo = sc.nextInt();

        switch(tipo){
            case 1:{
                Notebook nb = new Notebook(articolo,produttore,modello,dimensioneDisplay,spazioArchiviazione, prezzoAquisto, prezzoVendita);
                scaricoNotebook(nb);
            } break;
            case 2:{
                Smartphone sp = new Smartphone(articolo,produttore,modello,dimensioneDisplay,spazioArchiviazione, prezzoAquisto, prezzoVendita);
                scaricoSmartphone(sp);
            } break;
            case 3:{
                Tablet tb = new Tablet(articolo,produttore,modello,dimensioneDisplay,spazioArchiviazione, prezzoAquisto, prezzoVendita);
                scaricoTablet(tb);
            } break;
        }
    }

    public void StampaMagazzino(){

        System.out.println("I prodotti presenti in magazzino sono i seguenti:");

        System.out.println("NOTEBOOKS");
        System.out.println("_____________________________");

        for(int i=0; i<notebooks.size();i++){
            notebooks.get(i).displayInfo();
            System.out.println("********************************");
        }

        System.out.println("SMARTPHONES");
        for(int i=0; i<smartphones.size();i++){
            smartphones.get(i).displayInfo();
            System.out.println("********************************");
        }

        System.out.println("TABLETS");
        for(int i=0; i<tablets.size();i++){
            tablets.get(i).displayInfo();
            System.out.println("********************************");
        }
    }

    public void ricercaModelloNotebook(){
        String modello = " ";
        boolean found = false;
        int i = 0;

        System.out.println("Inserisci il modello da ricercare");
        modello = sc.nextLine();

        //Ciclca finche non trova il modello nell'array list e l'indice è inferiore alla dimensione
        while(!notebooks.get(i).getModello().equals(modello) && i<notebooks.size()){
            i++;
        }

        if(i<notebooks.size()){
            notebooks.get(i).displayInfo();
        } else {
            System.out.println("Spiacente, modello non trovato");
        }
    }

    public void ricercaModelloSmartphone(){
        String modello = " ";
        boolean found = false;
        int i = 0;

        System.out.println("Inserisci il modello da ricercare");
        modello = sc.nextLine();

        //Ciclca finche non trova il modello nell'array list e l'indice è inferiore alla dimensione
        while(!smartphones.get(i).getModello().equals(modello) && i<smartphones.size()){
            i++;
        }

        if(i<smartphones.size()){
            smartphones.get(i).displayInfo();
        } else {
            System.out.println("Spiacente, modello non trovato");
        }
    }

    public void ricercaModelloTablet(){
        String modello = " ";
        boolean found = false;
        int i = 0;

        System.out.println("Inserisci il modello da ricercare");
        modello = sc.nextLine();

        //Ciclca finche non trova il modello nell'array list e l'indice è inferiore alla dimensione
        while(!tablets.get(i).getModello().equals(modello) && i<tablets.size()){
            i++;
        }

        if(i<tablets.size()){
            tablets.get(i).displayInfo();
        } else {
            System.out.println("Spiacente, modello non trovato");
        }
    }

    public void ricercaModello() throws IOException{
        int tipo;

        System.out.println("Di quale prodotto ricerchi il modello?");
        System.out.println("1 Notebook");
        System.out.println("2 Smartphone");
        System.out.println("3 Tablet");

        tipo = sc.nextInt();

        switch(tipo){
            case 1:{
                ricercaModelloNotebook();
            } break;
            case 2:{
                ricercaModelloSmartphone();
            } break;
            case 3:{
                ricercaModelloTablet();
            } break;
        }
    }


    public int contaProdotti() throws IOException{
        return notebooks.size() + smartphones.size() + tablets.size();
    }

    public int contaNotebooks() throws IOException{
        return notebooks.size();
    }

    public int contaTablets() throws IOException{
        return tablets.size();
    }

    public int contaSmartphones() throws IOException{
        return smartphones.size();
    }

    public ArrayList<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(ArrayList<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public ArrayList<Smartphone> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(ArrayList<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    public ArrayList<Tablet> getTablets() {
        return tablets;
    }

    public void setTablets(ArrayList<Tablet> tablets) {
        this.tablets = tablets;
    }
}*/
