package uno;

class Jugador {
    public String nom;
    public Carta[] cartes;

    public Jugador(String nom, Carta[] cartes) {
        this.nom = nom;
        this.cartes = cartes;
    }

    public String getnom(){
        return nom;
    }

    public Carta[] getCartes(){
        return cartes;
    }
}