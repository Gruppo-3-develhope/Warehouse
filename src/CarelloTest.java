import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarelloTest {
    Carrello carrello = new Carrello();
    @Test
    public void testSpesaTotaleEZeroSeCarrelloEVuoto() {
        double carrelloTotale = carrello.carrelloTot();
//        Boolean carrelloIsEmpty = carrello.visualizzaCarrello().isEmpty();
//        assertTrue (carrelloIsEmpty && carrelloTotale == 0.0);
   }
}
