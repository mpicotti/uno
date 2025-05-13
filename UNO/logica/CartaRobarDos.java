package uno.logica;

public class CartaRobarDos extends Carta {

    public CartaRobarDos(Color color) {
        super(color, -1);
    }

    @Override
    public String toString() {
        return "+2";
    }

    public void robarDos(Jugador jugador, Mazo mazo) {
        for (int i = 0; i < 2; i++) {
            jugador.robaCarta(mazo);
        }
    }
}
