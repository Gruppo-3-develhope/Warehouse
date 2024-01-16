import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AmministratoreMenu {
    public static void utenteAmministratore() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Seleziona un'operazione:");
                System.out.println("1. Aggiungi a magazzino");
                System.out.println("2. Scarico merce da magazzino");
                System.out.println("3. Creazione carrello");
                System.out.println("4. Gestisci carrello");
                System.out.println("5. Stampa dispositivi magazzino");
                System.out.println("6. Ricerca tipo di dispositivo");
                System.out.println("7. Ricerca produttore");
                System.out.println("8. Ricerca modello");
                System.out.println("9. Ricerca prezzo di vendita");
                System.out.println("10. Ricerca prezzo di acquisto");
                System.out.println("11. Ricerca per range di prezzo");
                System.out.println("12. Inizializza magazzino");
                System.out.println("13 - Scarica prodotto da magazzino tramite id");
                System.out.println("0. Esci\n");

                int opzione = scanner.nextInt();

                switch (opzione) {
                    case 1:
                        try {
                            Main.magazzino.inserimentoProdotto();
                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }

                        break;

                    case 2:
                        try {
                            Main.magazzino.scaricoMerce();
                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 3:
                        GestoreCarrello.creaCarrello();
                        System.out.println("Carrello creato");
                        break;

                    case 4:
                        GestoreCarrello.gestisciCarrello(Main.magazzino);
                        break;

                    case 5:
                        Main.magazzino.stampaMagazzino();
                        break;

                    case 6:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaTipo();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 7:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaProduttore();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 8:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaModello();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 9:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaPrezzoVendita();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 10:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaPrezzoAcquisto();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 11:
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaRangeDiPrezzo();
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 12:
                        Main.magazzino.inizializzaMagazzino();
                        break;

                    case 13:
                        Main.magazzino.scaricoMerceTramiteId();
                        break;

                    case 0:
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
