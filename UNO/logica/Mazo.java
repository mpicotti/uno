package uno.logica;

import java.util.Stack;
import java.util.Collections;

public class Mazo {
    private static Stack<Carta> cartes;
    private static Stack<Carta> cartesInicials;

    public Mazo() {
        cartes = new Stack<>();
        cartesInicials = new Stack<>();
        for (Carta.Color color : Carta.Color.values()) {
            if (color != Carta.Color.Negre) {
                cartes.push(new Carta(color, 0));
                for (int j = 1; j <= 9; j++) {
                    cartes.push(new Carta(color, j));
                    cartes.push(new Carta(color, j));
                }
                cartes.push(new CartaRobarDos(color));
                cartes.push(new CartaRobarDos(color));
                cartes.push(new CartaProhibit(color));
                cartes.push(new CartaProhibit(color));
            }
        }
        for (int i = 0; i < 4; i++) {
            cartes.push(new CartaCanviColor());
        }

        for (int i = 0; i < 4; i++) {
            cartes.push(new CartaRobarQuatre());
        }
    }

    public Stack<Carta> getCartes() {
        return cartes;
    }

    public Carta agafarCarta() {
        return cartes.isEmpty() ? null : cartes.pop();
    }

    public void reiniciar(Pilo pilo) {
        if (pilo.getCartes().size() > 1) {
            Stack<Carta> cartesPilo = new Stack<>();
            cartesPilo.addAll(pilo.getCartes());
            Carta ultimaCarta = cartesPilo.pop();
            while (!cartesPilo.isEmpty()) {
                cartes.push(cartesPilo.pop());
            }
            pilo.getCartes().clear();
            pilo.getCartes().push(ultimaCarta);
            barrejar();
        }
    }

    public void barrejar() {
        Collections.shuffle(cartes);
    }

    public boolean esBuit() {
        return cartes.isEmpty();
    }
}