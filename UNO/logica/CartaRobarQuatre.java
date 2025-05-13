package uno.logica;

public class CartaRobarQuatre extends CartaCanviColor {

    public CartaRobarQuatre() {
        super();
    }

    @Override
    public String toString() {
        return "Robar Quatre";
    }

    public void robarQuatre(Jugador jugador, Mazo mazo) {
        for (int i = 0; i < 4; i++) {
            jugador.robaCarta(mazo);
        }
    }
}