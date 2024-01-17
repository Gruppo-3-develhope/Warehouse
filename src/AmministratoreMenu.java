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
                int tipo = 0;

                switch (opzione) {

                    case 1:


                        while (true) {
                            try {
                                System.out.println("Inserisci il tipo di articolo da ricercare");
                                System.out.println("1 Notebook");
                                System.out.println("2 Smartphone");
                                System.out.println("3 Tablet\n");
                                tipo = scanner.nextInt();
                                if (tipo < 1 || tipo > 3) {
                                    System.out.println("Devi inserire solo i valori 1, 2 o 3. Riprova.");
                                    scanner.nextLine();
                                } else {
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Devi inserire un numero intero (1, 2 o 3): ");
                                scanner.nextLine();
                            }
                        }
                        try {
                            Main.magazzino.inserimentoProdotto(tipo);
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
                        while (true) {
                            try {
                                System.out.println("Inserisci il tipo di articolo da ricercare");
                                System.out.println("1 Notebook");
                                System.out.println("2 Smartphone");
                                System.out.println("3 Tablet\n");
                                tipo = scanner.nextInt();
                                if (tipo < 1 || tipo > 3) {
                                    System.out.println("Devi inserire solo i valori 1, 2 o 3. Riprova.");
                                    scanner.nextLine();
                                } else {
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Devi inserire un numero intero (1, 2 o 3): ");
                                scanner.nextLine();
                            }
                        }
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaTipo(tipo);
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.out.println("Nessun prodotto di quel tipo trovato!");
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
                        double priceSearch;
                        System.out.println("Inserisci il prezzo di vendita da ricercare");
                        do {
                            try {
                                scanner.nextLine();
                                priceSearch = scanner.nextDouble();
                                break;

                            } catch (InputMismatchException e) {
                                System.out.println("Input non valido. Assicurati di inserire un numero in virgola mobile.");
                            }
                        } while (true);
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaPrezzoVendita(priceSearch);
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.out.println("Nessun prezzo di vendita di " + priceSearch + " trovato!");
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
