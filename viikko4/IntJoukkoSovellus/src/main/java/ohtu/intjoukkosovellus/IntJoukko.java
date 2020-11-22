
package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntJoukko {

    public final static int OLETUSKAPASITETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUSKOKO = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla.
    static IntJoukko apuIntJoukko;
    static private int[] aTaulu;
    static private int[] bTaulu;

    public IntJoukko() {
        ljono = new int[OLETUSKAPASITETTI];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUSKOKO;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUSKOKO;
    }
      
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == ljono.length) {
                ljono = Arrays.copyOf(ljono, ljono.length+kasvatuskoko);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                ljono[i] = 0;
                final int index = i;
                ljono = IntStream.range(0, ljono.length) 
                    .filter(j -> j != index) 
                    .map(j -> ljono[j]) 
                    .toArray(); 
                    alkioidenLkm--;
                    return true;
            }
        }
        return false;
    }
    
    public int mahtavuus() {
        return alkioidenLkm;
    }
    
    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += ljono[i];
            if(i <= alkioidenLkm-2) {
                tuotos += ", ";
            }
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        return Arrays.copyOfRange(ljono, 0, alkioidenLkm);
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        alustaApuTaulut(a, b);
        for (int i = 0; i < aTaulu.length; i++) {
            apuIntJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            apuIntJoukko.lisaa(bTaulu[i]);
        }
        return apuIntJoukko;
    }
    
    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        alustaApuTaulut(a, b);
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    apuIntJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return apuIntJoukko;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        alustaApuTaulut(a, b);
        for (int i = 0; i < aTaulu.length; i++) {
            apuIntJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            apuIntJoukko.poista(bTaulu[i]);
        }
        return apuIntJoukko;
    }

    public static void alustaApuTaulut(IntJoukko a, IntJoukko b) {
        apuIntJoukko = new IntJoukko();
        aTaulu = a.toIntArray();
        bTaulu = b.toIntArray();
    }  
}
