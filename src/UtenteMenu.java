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
                int tipo = 0;

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

                    case 5:
                        System.out.println("Inserisci il produttore da ricercare");
                        scanner.nextLine();
                        String produttore = scanner.nextLine();
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaProduttore(produttore);
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.out.println("Nessun produttore " + produttore + " trovato!");
                        }
                        break;

                    case 6:
                        System.out.println("Inserisci il modello da ricercare");
                        scanner.nextLine();
                        String modello = scanner.nextLine();
                        try {
                            List<Prodotto> prodotti = Main.magazzino.ricercaModello(modello);
                            stampaProdotti(prodotti);
                        } catch (Exception e) {
                            System.out.println("Nessun modello " + modello + " trovato!");
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
                        double prezzoDiVenditaMinimo = 0.0;
                        double prezzoDiVenditaMassimo = 0.0;
                        do {
                            try {
                                System.out.println("Inserisci il prezzo minimo da ricercare");
                                prezzoDiVenditaMinimo = scanner.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Input non valido. Assicurati di inserire un numero in virgola mobile.");
                                scanner.nextLine();
                            }
                        } while (true);
                        do {
                            try {
                                System.out.println("Inserisci il prezzo massimo da ricercare");
                                prezzoDiVenditaMassimo = scanner.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Input non valido. Assicurati di inserire un numero in virgola mobile.");
                                scanner.nextLine();
                            }
                        } while (true);
                            try {
                                List<Prodotto> prodotti = Main.magazzino.ricercaRangeDiPrezzo(prezzoDiVenditaMinimo, prezzoDiVenditaMassimo);
                                stampaProdotti(prodotti);
                            } catch (Exception e) {
                                System.out.println("Nessun prezzo di vendita nel range è stato trovato!");
                            }
                            break;

                            case 0:
                                scanner.close();
                                System.out.println("Uscita dal programma.");
                                System.exit(0);
                                break;

                        }

                } catch(InputMismatchException e){
                    System.out.println("Errore: inserisci un numero valido.\n");
                    scanner.next();
                }

            }
        }


        static void stampaProdotti (List < Prodotto > prodotti) {
            System.out.println("Trovati " + prodotti.size() + " prodotti");
            for (Prodotto prodotto : prodotti) {
                prodotto.displayInfo();
            }
        }
    }

