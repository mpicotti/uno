package uno;
import uno.interficies.UI;
import uno.logica.Jugador;
import uno.logica.Mazo;
import uno.logica.Pilo;

public class Partida {
    public static void jugar(String[] args) {

        Mazo mazo = new Mazo();
        mazo.barrejar();

        Pilo pilo = new Pilo();
        Jugador j1 = new Jugador("Jugador 1");

        System.out.println("Cartas del Mazo:");
        for (int i = 0; i < mazo.getCartes().size(); i++) {
            UI.mostrarCarta(mazo.getCartes().get(i));
        }

        System.out.println("Cartas del Jugador 1:");
        for (int i = 0; i < 7; i++) {
            j1.addCarta(mazo.afagarCarta());
        }

        UI.mostrarCartes(j1.getCartes());

        System.out.println("Cartas del Mazo un altre vegada:");
        for (int i = 0; i < mazo.getCartes().size(); i++) {
            UI.mostrarCarta(mazo.getCartes().get(i));
        }
    }
}
