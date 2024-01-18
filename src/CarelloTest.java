import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarrelloTest {

    Carrello carrello = new Carrello();
    @Test
    public void testSpesaTotaleEZeroSeCarrelloEVuoto() {
        double carrelloTotale = carrello.carrelloTot();
        Boolean carrelloIsEmpty = carrello.visualizzaCarrello().isEmpty();

        assertTrue (carrelloIsEmpty && carrelloTotale == 0.0);
    }