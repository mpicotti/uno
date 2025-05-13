package uno.logica;

public class Carta {
    public int numero;
    public Color color;

    public enum Color {
        Groc, Vermell, Blau, Verd, Negre
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

    public boolean sonCartesCompatibles(Carta cartaSuperior) {
        if (this.color == Color.Negre) {
            return true;
        }
        return this.color == cartaSuperior.getColor() || this.numero == cartaSuperior.getNumero();
    }
}