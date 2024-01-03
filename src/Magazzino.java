import java.io.IOException;
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
}
