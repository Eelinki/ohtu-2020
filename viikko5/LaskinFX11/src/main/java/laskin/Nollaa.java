package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.sovellus.nollaa();
        this.tuloskentta.setText("" + this.sovellus.tulos());
        this.syotekentta.clear();
    }

    @Override
    public void peru() {

    }
}
