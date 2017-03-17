package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoValidinVaraston() {
        Varasto varasto2 = new Varasto(-20);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoValidinVarastonSaldolla() {
        Varasto varasto2 = new Varasto(5, 1);
        assertEquals(4, varasto2.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoValidinVarastonNegatiivisellaTilavuudellaJaSaldolla() {
        Varasto varasto2 = new Varasto(-200, 1);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoValidinVarastonNegatiivisellaTilavuudellaJaNegatiivisellaSaldolla() {
        Varasto varasto2 = new Varasto(1, -1);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenLisaysEiMuutaSaldoa() {
        varasto.lisaaVarastoon(-2);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void yliSaldonLisaysTayttaaVaraston() {
        varasto.lisaaVarastoon(9001);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOttoEiMuutaSaldoa() {
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(-2);
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void annetaanKaikkiMitaVoidaan() {
        varasto.lisaaVarastoon(7);
        varasto.otaVarastosta(8);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void merkkijonoEsitys() {
        varasto.lisaaVarastoon(5);
        assertEquals("saldo = 5.0, vielä tilaa 5.0",varasto.toString());
    }
}
