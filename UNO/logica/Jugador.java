package uno.logica;

import java.util.ArrayList;

public class Jugador {

    private String nom;
    private ArrayList<Carta> cartes;

    public Jugador(String nom) {
        this.nom = nom;
        cartes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Carta> getCartes() {
        return cartes;
    }


    public Carta tirarCarta(Carta carta, Pilo pilo) {
        if (cartes.contains(carta)) {
            cartes.remove(carta);
            pilo.addCarta(carta);
            return carta;
        }
        return null;
    }

    public void robaCarta(Mazo mazo) {
        Carta cartaRobada = mazo.agafarCarta();
        if (cartaRobada != null) {
            cartes.add(cartaRobada);
        }
    }

    public int nombreDeCartes() {
        return cartes.size();
    }

    public boolean potTirarCarta(Carta cartaSuperior) {
        for (int i = 0; i < cartes.size(); i++) {
            Carta cartaJugador = cartes.get(i);
            if (cartaJugador.sonCartesCompatibles(cartaSuperior)) {
                return true;
            }
        }
        return false;
    }
}
