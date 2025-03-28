package uno;
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

    public void addCarta(Carta carta) {
        cartes.add(carta);
    }

    public Carta tirarCarta(Carta carta) {
        if (cartes.contains(carta)) {
            cartes.remove(carta);
            return carta;
        }
        return null;
    }


}
