package uno;
import uno.interficies.UI;

public class Main {
    public static void main(String[] args) {


        Mazo mazo = new Mazo();
        mazo.barrejar();

        Pilo pilo = new Pilo();
        Jugador j1 = new Jugador("Jugador 1");

        System.out.println("Cartas del Mazo:");
        for (Carta carta : mazo.getCartes()) {
            UI.mostrarCarta(carta);
        }

        System.out.println("Cartas del Jugador 1:");
        for (int i = 0; i < 7; i++) {
            j1.addCarta(mazo.afagarCarta());
        }

        UI.mostrarCartes(j1.getCartes());

        System.out.println("Cartas del Mazo un altre vegada:");
        for (Carta carta : mazo.getCartes()) {
            UI.mostrarCarta(carta);
        }

    }
}
