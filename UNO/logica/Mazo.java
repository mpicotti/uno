package uno.logica;

import java.util.Stack;
import java.util.Collections;

public class Mazo {
    private static Stack<Carta> cartes;
    private static Stack<Carta> cartesInicials;

    public Mazo() {
        cartes = new Stack<>();
        cartesInicials = new Stack<>();
        int i, j;
        for (i = 0; i < Carta.Color.values().length; i++) {
            cartes.push(new Carta( Carta.Color.values()[i], 0));
            for (j = 1; j <= 9; j++) {
                cartes.push(new Carta(Carta.Color.values()[i] ,j));
                cartes.push(new Carta(Carta.Color.values()[i], j));
            }
        }
    }

    public Stack<Carta> getCartes() {

        return cartes;
    }

    public Carta afagarCarta() {
        return cartes.pop();
    }

    public void reiniciar(Pilo pilo) {
        if (pilo.getCartes().size() > 1) {
            Stack<Carta> cartasPilo = new Stack<>();
            cartasPilo.addAll(pilo.getCartes());
            Carta ultimaCarta = cartasPilo.pop();
            while (!cartasPilo.isEmpty()) {
                cartes.push(cartasPilo.pop());
            }

            pilo.getCartes().clear();
            pilo.getCartes().push(ultimaCarta);
            barrejar();
        }
    }
    public void barrejar() {
        Collections.shuffle(cartes);
    }
}