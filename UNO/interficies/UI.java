package uno.interficies;

import uno.logica.Carta;

import java.util.ArrayList;

public class UI {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m"; 
    public static final String GREEN = "\u001B[32m"; 
    public static final String YELLOW = "\u001B[33m"; 
    public static final String BLUE = "\u001B[34m"; 

    private static String pintarCarta(Carta carta) {
        String color = "";
        switch (carta.getColor()) {
            case Carta.Color.Groc:
                color = YELLOW;
                break;
            case Carta.Color.Vermell:
                color = RED;
                break;
            case Carta.Color.Blau:
                color = BLUE;
                break;
            case Carta.Color.Verd:
                color = GREEN;
                break;
            default:
                break;
        }

        String cartaPintada = String.format("""
            %s┌─────────┐%s
            %s│ %d       │%s
            %s│         │%s
            %s│   UNO   │%s
            %s│         │%s
            %s│       %d │%s
            %s└─────────┘%s""",
            color, RESET,
            color, carta.getNumero(), RESET,
            color, RESET,
            color, RESET,
            color, RESET,
            color, carta.getNumero(), RESET,
            color, RESET);


        return cartaPintada;
    }

    public static void mostrarCarta(Carta carta) {
        System.out.println(pintarCarta(carta));
    }

    public static void mostrarCartes(ArrayList<Carta> cartes) {
        int quantitat = cartes.size();
        String[][] cartesPintades = new String[quantitat][];
    
        for (int i = 0; i < quantitat; i++) {
            cartesPintades[i] = pintarCarta(cartes.get(i)).split("\n");
        }
    
        int altura = cartesPintades[0].length;
    
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < quantitat; j++) {
                System.out.print(cartesPintades[j][i] + "  ");
            }
            System.out.println();
        }
    }
    
}
