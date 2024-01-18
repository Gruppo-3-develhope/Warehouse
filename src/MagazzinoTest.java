import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MagazzinoTest {
    Magazzino magazzino = new Magazzino();

    @Test
    public void ricercaPrezzoSpecifico() throws Exception {
        magazzino.inizializzaMagazzino();
        Double prezzoDiProva = 500.00;
        List<Prodotto> result = magazzino.ricercaPrezzoVendita(prezzoDiProva);
        //Cercare che la lista non sia null, o sia vuota o piena.
        Boolean resultNotNull = result != null;
        Boolean resultVuoto = result.isEmpty();
        Boolean resultPieno = result.contains(prezzoDiProva);
        List<Prodotto> resultPrice = new ArrayList<>();
        for(Prodotto prodotto : result){
            if(prodotto.getPrezzoVendita() == prezzoDiProva){
                resultPrice.add(prodotto);
            }
        }
        Assert.assertEquals(result, resultPrice);
    }

}