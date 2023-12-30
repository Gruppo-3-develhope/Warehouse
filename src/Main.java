import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Seleziona un'operazione:");
                System.out.println("1. Aggiungi a magazzino");
                System.out.println("2. Scarico merce da magazzino");
                System.out.println("3. Creazione carrello");
                System.out.println("4. Aggiungi elemento al carrello");
                System.out.println("5. Stampa dispositivi magazzino");
                System.out.println("6. Ricerca tipo di dispositivo");
                System.out.println("7. Ricerca produttore");
                System.out.println("8. Ricerca modello");
                System.out.println("9. Ricerca prezzo di vendita");
                System.out.println("10. Ricerca prezzo di acquisto");
                System.out.println("11. Ricerca per range di prezzo");
                System.out.println("0. Esci");

                int opzione = scanner.nextInt();

                switch (opzione) {
                    case 1:
//                        aggiungiMagazzino();

                        break;

                    case 2:
//                        scaricomerce();

                        break;

                    case 3:
//                        creaCarello();

                        break;

                    case 4:
//                        aggiungiElementoCarello();
                        break;

                    case 5:
//                        stampaMagazzino();
                        break;

                    case 6:
//                        ricercaTipo();
                        break;

                    case 7:
//                        ricercaProduttore();
                        break;

                    case 8:
//                        ricercaModello();
                        break;

                    case 9:
//                        ricercaPrezzoVendita();
                        break;

                    case 10:
//                        ricercaPrezzoAcquisto();
                        break;

                    case 11:
//                        ricercaRangePrezzo();
                        break;

                    case 0:
                        System.out.println("Uscita dal programma.");
                        System.exit(0);
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: inserisci un numero valido.");
                scanner.next();
            }
        }
    }
}