package uno;

class Carta {
    public int numero;
    public enum colors
    {
        Groc, Vermell, Blau, Verd
    }

    public Carta (int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }
}