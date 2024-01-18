import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MagazzinoTest {
    Magazzino magazzino = new Magazzino();

    @Test
    public void ricercaPrezzoSpecifico() throws Exception {
        magazzino.inizializzaMagazzino();
        Double prezzoDiProva = 500.00;
        List<Prodotto> result = magazzino.ricercaPrezzoVendita(prezzoDiProva);
//        Boolean resultNotNull = result != null;
//        Boolean resultVuoto = result.isEmpty();
//        Boolean resultPieno = result.contains(prezzoDiProva);
        List<Prodotto> resultPrice = new ArrayList<>();
        for (Prodotto prodotto : result) {
            if (prodotto.getPrezzoVendita() == prezzoDiProva) {
                resultPrice.add(prodotto);
            }
        }
        Assert.assertEquals(result, resultPrice);
    }

}