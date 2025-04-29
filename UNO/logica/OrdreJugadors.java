package uno.logica;

import java.util.ArrayList;
import java.util.Collections;

public class OrdreJugadors {
    public ArrayList<Jugador> jugadors = new ArrayList<>();
    private int tornActual = 0;

    public void passarTorn() {
        tornActual = (tornActual + 1) % jugadors.size();
    }

    public Jugador getJugadorActiu() {
        return jugadors.get(tornActual);
    }

    public void crearJugador(String nom) {
        jugadors.add(new Jugador(nom));
    }

    public void barrejarOrdre() {
        Collections.shuffle(jugadors);
    }

    public ArrayList<Jugador> getLlistaJugadors() {
        return jugadors;
    }
}
