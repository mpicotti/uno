package uno.logica;

public class CartaCanviColor extends Carta {

    public CartaCanviColor() {
        super(Color.Negre, -1);
    }

    @Override
    public String toString() {
        return "Canvi de Color";
    }

    public void setColor(Color colorNou) {
        if (colorNou != Color.Negre) {
            this.color = colorNou;
        }
    }
}