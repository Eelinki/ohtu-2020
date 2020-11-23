
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, OLETUSKASVATUS = 5;
    private int kasvatuskoko, alkioidenLkm;
    private int[] alkiot;

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti on negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko on negatiivinen");
        }
        alkiot = new int[kapasiteetti];
        Arrays.fill(alkiot, 0);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            alkiot[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluu(luku)) {
            alkiot[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % alkiot.length == 0) {
                int[] taulukkoOld;
                taulukkoOld = alkiot;
                kopioiTaulukko(alkiot, taulukkoOld);
                alkiot = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, alkiot);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) return true;
        }
        return false;
    }

    public void poista(int luku) {
        int indeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                indeksi = i;
                alkiot[indeksi] = 0;
                break;
            }
        }
        if (indeksi != -1) {
            for (int j = indeksi; j < alkioidenLkm - 1; j++) {
                int apu = alkiot[j];
                alkiot[j] = alkiot[j + 1];
                alkiot[j + 1] = apu;
            }
            alkioidenLkm--;
        }

    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");

        for (int i = 0; i < alkioidenLkm; i++) {
            builder.append(alkiot[i]);

            if(i < alkioidenLkm - 1) {
                builder.append(", ");
            }
        }

        builder.append("}");

        return builder.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(alkiot, 0, taulu, 0, taulu.length);
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int item : aTaulu) {
            yhdiste.lisaa(item);
        }
        for (int value : bTaulu) {
            yhdiste.lisaa(value);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int item : aTaulu) {
            for (int value : bTaulu) {
                if (item == value) {
                    leikkaus.lisaa(value);
                }
            }
        }

        return leikkaus;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int item : aTaulu) {
            erotus.lisaa(item);
        }
        for (int value : bTaulu) {
            erotus.poista(value);
        }
 
        return erotus;
    }
}
