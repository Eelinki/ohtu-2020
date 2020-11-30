package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.sovellus.plus(Integer.parseInt(syotekentta.getText()));
        this.tuloskentta.setText("" + this.sovellus.tulos());
        this.syotekentta.clear();
    }

    @Override
    public void peru() {

    }
}
