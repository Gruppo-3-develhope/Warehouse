import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UtenteMenu {
    public static void utenteNormale() {
        Main.magazzino.inizializzaMagazzino();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Seleziona un'operazione:");
                System.out.println("1. Creazione carrello");
                System.out.println("2. Gestisci carrello");
                System.out.println("3. Stampa dispositivi magazzino");
                System.out.println("4. Ricerca tipo di dispositivo");
                System.out.println("5. Ricerca produttore");
                System.out.println("6. Ricerca modello");
                System.out.println("7. Ricerca prezzo di vendita");
                System.out.println("8. Ricerca per range di prezzo");
                System.out.println("0. Esci\n");

                int opzione = scanner.nextInt();

                switch (opzione) {


                    case 1:
                        GestoreCarrello.creaCarrello();
                        System.out.println("Carrello creato");
                        break;

                    case 2:
                        GestoreCarrello.gestisciCarrello(Main.magazzino);
                        break;

                    case 3:
                        Main.magazzino.stampaMagazzino();
                        break;

                    case 4:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaTipo();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaProduttore();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 6:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaModello();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 7:
                        double priceSearch;
                        System.out.println("Inserisci il prezzo di vendita da ricercare");
                        do {
                            try {
                                priceSearch = scanner.nextDouble();
                                break;

                            } catch (InputMismatchException e) {
                                System.out.println("Input non valido. Assicurati di inserire un numero in virgola mobile.");
                                scanner.nextLine();
                            }
                        } while (true);
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaPrezzoVendita(priceSearch);
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.out.println("Nessun prezzo di vendita di " + priceSearch + " trovato!");
                }
                        break;


                    case 8:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaRangeDiPrezzo();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 0:
                        scanner.close();
                        System.out.println("Uscita dal programma.");
                        System.exit(0);
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: inserisci un numero valido.\n");
                scanner.next();
            }
        }
    }

    static void stampaProdotti(List<Prodotto> prodotti) {
        System.out.println("Trovati " + prodotti.size() + " prodotti");
        for (Prodotto prodotto : prodotti) {
            prodotto.displayInfo();
        }
    }
}

