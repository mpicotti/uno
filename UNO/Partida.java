package uno;
import uno.logica.*;
import uno.interficies.UI;
import java.util.Scanner;

public class Partida {
    private Mazo mazo;
    private Pilo pilo;
    private OrdreJugadors ordreJugadors;
    Scanner scanner = new Scanner(System.in);

    public void jugar() {
        preparar();
        boolean finalitzat = false;
        pilo.addCarta(mazo.agafarCarta());

        while (!finalitzat) {
            finalitzat = torn();
        }
        System.out.println("Fi de la partida");
    }

    private void preparar() {
        int NombreJugadors;
        mazo = new Mazo();
        mazo.barrejar();
        pilo = new Pilo();

        System.out.print("Introdueix la quantitat de jugadors:");
        NombreJugadors = scanner.nextInt();

        ordreJugadors = new OrdreJugadors();
        for (int i = 1; i <= NombreJugadors; i++) {
            ordreJugadors.crearJugador("Jugador " + i);
        }
        ordreJugadors.barrejarOrdre();
        repartirCartes();
    }

    private boolean torn() {
        Jugador jugador = ordreJugadors.getJugadorActiu();
        Carta cartaSuperior = pilo.consultarCarta();

        System.out.println("======================");
        System.out.println("Torn de: " + jugador.getNom());
        System.out.println("Carta superior al pilo:");
        UI.mostrarCarta(cartaSuperior);
        System.out.println("Les cartes del jugador:");
        UI.mostrarCartes(jugador.getCartes());

        if (jugador.potTirarCarta(cartaSuperior)) {
            boolean cartaValidaJugada = false;
            while (!cartaValidaJugada) {
                int opcio = UI.demanarCarta(jugador.getCartes().size());
                Carta seleccionada = jugador.getCartes().get(opcio);

                if (seleccionada.sonCartesCompatibles(cartaSuperior)) {
                    jugador.tirarCarta(seleccionada, pilo);
                    System.out.println(jugador.getNom() + " ha tirat:");
                    UI.mostrarCarta(seleccionada);

                        if (seleccionada instanceof CartaCanviColor) {
                            Carta.Color nuevoColor = UI.demanarColor();
                            ((CartaCanviColor)seleccionada).setColor(nuevoColor);
                            System.out.println("Color canviat a: " + nuevoColor);

                        if (seleccionada instanceof CartaProhibit) {
                            System.out.println("Prohibit");
                            ((CartaProhibit)seleccionada).prohibir(ordreJugadors);
                        }

                        if (seleccionada instanceof CartaRobarQuatre) {
                            Jugador siguienteJugador = ordreJugadors.getSeguentJugador();
                            ((CartaRobarQuatre)seleccionada).robarQuatre(siguienteJugador, mazo);
                            System.out.println(siguienteJugador.getNom() + " ha de robat 4 cartes");
                            ordreJugadors.passarTorn();
                        }

                        if (seleccionada instanceof CartaRobarDos) {
                            Jugador siguienteJugador = ordreJugadors.getSeguentJugador();
                            ((CartaRobarDos)seleccionada).robarDos(siguienteJugador, mazo);
                            System.out.println(siguienteJugador.getNom() + " ha de robat 2 cartes");
                            ordreJugadors.passarTorn();
                        }

                    }

                    cartaValidaJugada = true;
                } else {
                    System.out.println("No pots tirar aquesta carta. Torna a tirar");
                }
            }
        } else {
            System.out.println("No pots tirar. Roba una carta.");
            System.out.println("Robant carta...");
            jugador.robaCarta(mazo);
        }

        if (jugador.getCartes().isEmpty()) {
            System.out.println(jugador.getNom() + " ha guanyat");
            return true;
        }

        ordreJugadors.passarTorn();
        return false;
    }

    private void repartirCartes() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < ordreJugadors.jugadors.size(); j++) {
                ordreJugadors.jugadors.get(j).robaCarta(mazo);
            }
        }
    }
}
