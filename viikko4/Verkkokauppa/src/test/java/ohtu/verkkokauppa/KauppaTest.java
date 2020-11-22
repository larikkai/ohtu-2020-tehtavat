package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Kauppa k;
    Varasto varasto;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class); 
        when(viite.uusi()).thenReturn(50);
        varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(2);
        when(varasto.saldo(3)).thenReturn(0); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kahvi", 2));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "unicorn", 100));
        k = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void ostosOnnistuuKutsumallaTilimaksuaJaVeloitetaanOikealtaAsiakkaaltaOikeillaTiedoilla() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        verify(varasto, times(1)).saldo(1);
        verify(varasto, times(1)).haeTuote(1);
        verify(pankki).tilisiirto(eq("pekka"), eq(50), eq("12345"), eq("33333-44455"), eq(5));
    }

    @Test
    public void ostosOnnistuuKahdellaEriTuotteella() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("simo", "112233");

        verify(varasto, times(2)).saldo(anyInt());
        verify(varasto, times(2)).haeTuote(anyInt());
        verify(pankki).tilisiirto(eq("simo"), eq(50), eq("112233"), eq("33333-44455"), eq(7));
    }

    @Test
    public void ostosOnnistuuKahdellaSamallaTuotteella() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("simo", "112233");

        verify(varasto, times(2)).saldo(1);
        verify(varasto, times(2)).haeTuote(1);
        verify(pankki).tilisiirto(eq("simo"), eq(50), eq("112233"), eq("33333-44455"), eq(10));
    }

    @Test
    public void ostosVeloitetaanOikeinKunTuotettallaEiOleSaldoa() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);
        k.tilimaksu("simo", "112233");

        verify(varasto, times(2)).saldo(anyInt());
        verify(varasto, times(1)).haeTuote(anyInt());
        verify(pankki).tilisiirto(eq("simo"), eq(50), eq("112233"), eq("33333-44455"), eq(5));
    }

    @Test
    public void uudenAsioinninAloittaminenNollaaEdellisenOstoksenTiedot() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu("simo", "112233");

        verify(varasto, times(2)).saldo(anyInt());
        verify(varasto, times(2)).haeTuote(anyInt());
        verify(pankki).tilisiirto(eq("simo"), eq(50), eq("112233"), eq("33333-44455"), eq(2));
    }

    @Test
    public void hakeeUudenViitenumeronJokaiselleTilimaksulle() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("simo", "112233");
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu("simo", "112233");

        verify(varasto, times(2)).saldo(anyInt());
        verify(varasto, times(2)).haeTuote(anyInt());
        verify(viite, times(2)).uusi();
    }

    @Test
    public void veloitusOikeinKunPoistetaanTuoteKorista() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        k.lisaaKoriin(2);
        k.tilimaksu("simo", "112233");

        verify(varasto, times(2)).saldo(anyInt());
        verify(varasto, times(3)).haeTuote(anyInt());
        verify(pankki).tilisiirto(eq("simo"), eq(50), eq("112233"), eq("33333-44455"), eq(2));
    }
}
