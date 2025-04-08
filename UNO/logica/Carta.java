package uno.logica;

public class Carta {
    public int numero;
    public Color color;

    public enum Color {
        Groc, Vermell, Blau, Verd
    }

    public Carta(Color color, int numero) {
        this.color = color;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Color getColor() {
        return color;
    }
}