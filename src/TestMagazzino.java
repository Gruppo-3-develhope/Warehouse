import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestMagazzino {
    Magazzino magazzino = new Magazzino();
    @Test
    public void seRicercaTipoRitornaListaVuota() throws Exception {
       // magazzino.inizializzaMagazzino();
        int tipo = 1;
        //List<Prodotto> list = magazzino.ricercaTipo(tipo);
        Exception exception = Assert.assertThrows(Exception.class, () -> magazzino.ricercaTipo(tipo));
        Assert.assertEquals("Not Found", exception.getMessage());


    }
}

