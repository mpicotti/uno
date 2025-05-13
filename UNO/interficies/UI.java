package uno.interficies;

import uno.logica.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String BLACK = "\u001B[30m";

    private static String pintarCarta(Carta carta) {
        String color = "";
        switch (carta.getColor()) {
            case Groc: color = YELLOW; break;
            case Vermell: color = RED; break;
            case Blau: color = BLUE; break;
            case Verd: color = GREEN; break;
            case Negre: color = BLACK; break;
            default: break;
        }

        String textCentre = "  UNO  ";
        if (carta instanceof CartaRobarQuatre) {
            textCentre = "  +4   ";
        } else if (carta instanceof CartaRobarDos) {
            textCentre = "  +2   ";
        } else if (carta instanceof CartaCanviColor) {
            textCentre = " COLOR ";
        } else if (carta instanceof CartaProhibit) {
            textCentre = "  \uD83D\uDEAB   ";
        }


        String numeroStr = (carta.getNumero() == -1) ? " " : String.valueOf(carta.getNumero());

        String cartaPintada = String.format("""
            %s┌─────────┐%s
            %s│ %s       │%s
            %s│         │%s
            %s│ %s │%s
            %s│         │%s
            %s│       %s │%s
            %s└─────────┘%s""",
                color, RESET,
                color, numeroStr, RESET,
                color, RESET,
                color, textCentre, RESET,
                color, RESET,
                color, numeroStr, RESET,
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
        System.out.print("   ");
        for (int j = 0; j < quantitat; j++) {
            System.out.printf("(%2s)         ", j);
        }
        System.out.println();
    }

    public static int demanarCarta(int maxCartes) {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        while (opcio < 0 || opcio >= maxCartes) {
            System.out.print("Introdueix el número de la carta que vols jugar (0 - " + (maxCartes - 1) + "): ");
            if (scanner.hasNextInt()) {
                opcio = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Entrada no vàlida. Torna-ho a provar.");
            }
        }
        return opcio;
    }

    public static Carta.Color demanarColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona un color:");
        System.out.println("1. Groc");
        System.out.println("2. Vermell");
        System.out.println("3. Blau");
        System.out.println("4. Verd");

        int opcio = -1;
        while (opcio < 1 || opcio > 4) {
            System.out.print("Introdueix una opció (1-4): ");
            if (scanner.hasNextInt()) {
                opcio = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Entrada no vàlida. Torna-ho a provar.");
            }
        }

        switch (opcio) {
            case 1: return Carta.Color.Groc;
            case 2: return Carta.Color.Vermell;
            case 3: return Carta.Color.Blau;
            case 4: return Carta.Color.Verd;
            default: return Carta.Color.Groc;
        }
    }
}