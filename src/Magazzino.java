import java.io.IOException;
import java.util.ArrayList;


public class Magazzino implements Prodotti {

    private ArrayList<Notebook> notebooks = new ArrayList<Notebook>();
    private ArrayList<Smartphone> smartphones = new ArrayList<Smartphone>();
    private ArrayList<Tablet> tablets = new ArrayList<Tablet>();

    public Magazzino() {
    }



    public void inserimentoNotebook() throws IOException {

        String item;
        String manufacturer;
        String model;
        double displaySize;
        String archiveSpace;
        double buyingPrice;
        double sellingPrice;

        /*System.out.println("Inserisci item");
        item = bf.readLine();
        System.out.println("Inserisci azienda produttrice");
        manufacturer = bf.readLine();
        System.out.println("Inserisci modello");
        model = bf.readLine();
        System.out.println("Inserisci dimensione del display");
        displaySize = Double.parseDouble(bf.readLine());
        System.out.println("Inserisci memoria di archiviazione");
        archiveSpace = bf.readLine();
        System.out.println("Inserisci prezzo di acquisto");
        buyingPrice = Double.parseDouble(bf.readLine());
        System.out.println("Inserisci prezzo di vendita");
        sellingPrice = Double.parseDouble(bf.readLine());*/

        Notebook nb = new Notebook(item, manufacturer, model, displaySize, archiveSpace
                , buyingPrice, sellingPrice);

        notebooks.add(nb); // In questo modo l'oggetto creato lo salvo nell'aray list.
    }


    public void inserimentoSmartphone() throws IOException {

        String item;
        String manufacturer;
        String model;
        double displaySize;
        String archiveSpace;
        double buyingPrice;
        double sellingPrice;

        System.out.println("Inserisci item");
        item = bf.readLine();
        System.out.println("Inserisci azienda produttrice");
        manufacturer = bf.readLine();
        System.out.println("Inserisci modello");
        model = bf.readLine();
        System.out.println("Inserisci dimensione del display");
        displaySize = Double.parseDouble(bf.readLine());
        System.out.println("Inserisci memoria di archiviazione");
        archiveSpace = bf.readLine();
        System.out.println("Inserisci prezzo di acquisto");
        buyingPrice = Double.parseDouble(bf.readLine());
        System.out.println("Inserisci prezzo di vendita");
        sellingPrice = Double.parseDouble(bf.readLine());

        Smartphone sm = new Smartphone(item, manufacturer, model, displaySize, archiveSpace
                , buyingPrice, sellingPrice);

        smartphones.add(sm); // In questo modo l'oggetto creato lo salvo nell'aray list.

    }

    public void inserimentoTablet() throws IOException {

        String item;
        String manufacturer;
        String model;
        double displaySize;
        String archiveSpace;
        double buyingPrice;
        double sellingPrice;

        System.out.println("Inserisci item");
        item = bf.readLine();
        System.out.println("Inserisci azienda produttrice");
        manufacturer = bf.readLine();
        System.out.println("Inserisci modello");
        model = bf.readLine();
        System.out.println("Inserisci dimensione del display");
        displaySize = Double.parseDouble(bf.readLine());
        System.out.println("Inserisci memoria di archiviazione");
        archiveSpace = bf.readLine();
        System.out.println("Inserisci prezzo di acquisto");
        buyingPrice = Double.parseDouble(bf.readLine());
        System.out.println("Inserisci prezzo di vendita");
        sellingPrice = Double.parseDouble(bf.readLine());

        Tablet tb = new Tablet(item, manufacturer, model, displaySize, archiveSpace
                , buyingPrice, sellingPrice);

        tablets.add(tb); // In questo modo l'oggetto creato lo salvo nell'array list.
    }

    public void inserimentoProdotto() throws IOException {
        int tipo;

        System.out.println("Che prodotto vuoi inserire?");
        System.out.println("1 Notebook");
        System.out.println("2 Smartphone");
        System.out.println("3 Tablet");

        tipo = Integer.parseInt(bf.readLine());

        switch (tipo) {

                case 1:
                    inserimentoNotebook();

                    break;

                case 2:
                    inserimentoSmartphone();

                    break;

                case 3:
                    inserimentoTablet();

                    break;

                default: throws new IllegalAccessException("invalid");

            }

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

    @Override
    public void displayInfo() {

    }
}
