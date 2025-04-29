package uno.logica;

public class Regles {
    public static boolean sonCartesCompatibles(Carta cartaJugador, Carta cartaSuperior) {
        return cartaJugador.getColor() == cartaSuperior.getColor() || cartaJugador.getNumero() == cartaSuperior.getNumero();
    }
}