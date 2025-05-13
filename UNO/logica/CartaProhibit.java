package uno.logica;

public class CartaProhibit extends Carta {

    public CartaProhibit(Color color) {
        super(color, -1);
    }

    @Override
    public String toString() {
        return "Prohibit";
    }

    public void prohibir(OrdreJugadors ordreJugadors) {
        ordreJugadors.passarTorn();
    }
}
