import java.util.InputMismatchException;
import java.util.Scanner;

public class GestoreCarrello {
    static Carrello carrello;

    public static void creaCarrello() {
        carrello = new Carrello();
    }

    public static void gestisciCarrello(Magazzino magazzino) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        do {
            try {
                System.out.println("Seleziona l'operazione da fare sul carrello: ");
                System.out.println("1. Aggiungi al carrello");
                System.out.println("2. Rimuovi dal carrello");
                System.out.println("3. Visualizza carrello");
                System.out.println("4. Costo carrello");
                System.out.println("5. Concludi vendita");
                System.out.println("0. Esci dalla gestione carrello\n");
                int operazione = scanner.nextInt();
                switch (operazione) {
                    case 1:
                        System.out.println("Inserisci ID prodotto: ");
                        String idDaAggiungere = scanner.nextLine();
                        carrello.aggiungiAlCarrello(magazzino, idDaAggiungere);
                        break;

                    case 2:
                        System.out.println("Inserisci ID prodotto");
                        String idDaRimuovere = scanner.nextLine();
                        carrello.rimuoviDalCarrello(idDaRimuovere);
                        break;

                    case 3:
                        carrello.visualizzaCarrello();
                        break;

                    case 4:
                        System.out.println(carrello.carrelloTot());
                        break;

                    case 5:
                        carrello.concludiVendita(magazzino);
                        break;

                    case 0:
                        System.out.println("Uscita dal carrello.");
                        continua = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: inserisci un numero valido.\n");
                scanner.next();
            }
        } while (continua);
    }
}
