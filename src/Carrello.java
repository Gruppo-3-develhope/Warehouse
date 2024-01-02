import java.util.ArrayList;
public class Carrello {

    private ArrayList<Dispositivo> prodotti = new ArrayList<>();
    // ArrayList<Dispositivo> magazzino = new ArrayList<>();

    public ArrayList<Dispositivo> aggiungiAlCarrello(ArrayList<Dispositivo> magazzino, String nome, int quantita) {
        for (Dispositivo dispositivo : magazzino) {
            if (dispositivo.getNome().equalsIgnoreCase(nome)) {
                if (dispositivo.getQuantita() >= quantita) {
                    prodotti.add(new Dispositivo(dispositivo.getId(), dispositivo.getNome(), quantita, dispositivo.getPrezzoTot()));
                    // la rimozione dal magazzino verrà effettuata solo a valle dell'effettiva vendita
                    // magazzino.download(dispositivo.getId(), quantita);
                    System.out.println("Oggetto oggiunto al carrello.");
                } else {
                    System.out.println("Quantità non disponibile in magazzino");
                }
                return prodotti;
            }
        }
        System.out.println("Dispositivo non trovato in magazzino");
        return prodotti;
    }


    public ArrayList<Dispositivo> aggiungiID(ArrayList<Dispositivo> magazzino, int id) {
        for (Dispositivo dispositivo : magazzino) {
            if (dispositivo.getId() == id) {
                System.out.println("Inserire la quantità da aggiungere al carrello");
                Scanner scanner = new Scanner(System.in);
                int quantitaDaAggiungere = scanner.nextInt();
                if (dispositivo.getQuantita() >= quantitaDaAggiungere) {
                    prodotti.add(new Dispositivo(dispositivo.getId(), dispositivo.getNome(), quantitaDaAggiungere, dispositivo.getPrezzoTot()));
                    // la rimozione dal magazzino verrà effettuata solo a valle dell'effettiva vendita
                    // magazzino.download(dispositivo.getId(), quantitaDaAggiungere);
                    System.out.println("Oggetto aggiunto al carrello");
                } else {
                    System.out.println("Quantità non disponibile in magazzino");
                }
                return prodotti;
            }
            System.out.println("Dispositivo non trovato tramite ID");
            return prodotti;
        }
    }

    public ArrayList<Dispositivo> rimuoviDalCarrello(int id, int quantita) {
       for(Dispositivo dispositivo : prodotti) {
       if(dispositivo.getId() == id ) {
        if(dispositivo.getQuantita() == quantita) {

        }
         }
       }
    }
            private static void visualizzaCarrello (ArrayList<Dispositivo> carrello) {
                System.out.println("Carrello: ");
                for (Dispositivo dispositivo : carrello) {
                    System.out.println("Nome: " + dispositivo.getNome() + " ,Quantità: " + dispositivo.getQuantita());
                }
            }

            private static double carrelloTot (ArrayList < Dispositivo > carrello) {
                double spesaTot = 0.0;
                for (Dispositivo dispositivo : carrello) {
                    spesaTot += dispositivo.getPrezzoTot();
                }
                return spesaTot;
            }
            //spesa media del carrello per dispositivo
            private static void concludiVendita (ArrayList < Dispositivo > magazzino, ArrayList < Dispositivo > carrello)
            {
                System.out.println("Vendita conclusa");
                for (Dispositivo elementiCarrello : carrello) {
                    scaricaMerce(magazzino, elementiCarrello.getNome(), elementiCarrello.getQuantita());
                }
                carrello.clear();
            }

            private static void scaricaMerce (ArrayList < Dispositivo > magazzino, String nome,int quantita){
                for (Dispositivo dispositivo : magazzino) {
                    if (dispositivo.getNome().equalsIgnoreCase(nome)) {
                        if (dispositivo.getQuantita() >= quantita) {
                            dispositivo.download(quantita);
                            System.out.println("Merce scaricata dal magazzino");
                        } else {
                            System.out.println("Quantità non disponibile nel magazzino");
                        }

                    }
                }
                System.out.println("Dispositivo non trovato in magazzino");
            }
        }
    }
}





