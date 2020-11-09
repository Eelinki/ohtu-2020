package ohtu.verkkokauppa;

public class Viitegeneraattori implements IViitegeneraattori {
    private int seuraava;

    public Viitegeneraattori(){
        seuraava = 1;
    }

    public int uusi(){
        return seuraava++;
    }
}
