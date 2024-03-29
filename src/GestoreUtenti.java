import java.util.InputMismatchException;
import java.util.Scanner;

public class GestoreUtenti {
    public static void gestoreUtenti() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto nell' ecommerce progettato dal team S.P.A.M!");
        while (true) {

            try {
                System.out.println("Seleziona il tipo di utente:");
                System.out.println("1. Utente normale");
                System.out.println("2. Utente amministratore");
                System.out.println("0. Esci");

                int scelta = scanner.nextInt();

                switch (scelta) {
                    case 1:
                        System.out.println("Hai selezionato Utente Normale.");
                        UtenteMenu.utenteNormale();

                        break;
                    case 2:
                        System.out.println("Hai selezionato Utente Amministratore.");
                        AmministratoreMenu.utenteAmministratore();
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
}

