package com.puntosingular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanosConverter {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Convertidor de números arábigos a números romanos");
        System.out.println();


        int number = 0;
        do {
            System.out.print("Introduce el número a convertir, o cero (0) para salir: ");

            try {
                number = Integer.parseInt(reader.readLine());

                if (number <= 1000 && number >= 1) {
                    String romanNumeral = convertNumberToRomanNumeral(number);
                    System.out.print("La representación romana del número es: " + romanNumeral);
                } else if (number != 0) {
                    System.out.println("El número está fuera de rango");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException nfe) {
                System.out.println();
                System.out.println("El dato introducido no es válido.");
                number = -1;
            }

            System.out.println();
            System.out.println();
        } while (number != 0);

        System.out.println();
        System.out.println("¡Hasta luego!");
    }

    private static String convertNumberToRomanNumeral(int number) {
        int unidadesMillar = number / 1000;
        int centenas = (number / 100) % 10;
        int decenas = (number / 10) % 10;
        int unidades = number % 10;

        String unidadesMillarRomano = getRomanNumeral(unidadesMillar, "M", "", "");
        String centenasRomano = getRomanNumeral(centenas, "C", "M", "D");
        String decenasRomano = getRomanNumeral(decenas, "X", "C", "L");
        String unidadesRomano = getRomanNumeral(unidades, "I", "X", "V");

        return unidadesMillarRomano + centenasRomano + decenasRomano + unidadesRomano;
    }

    private static String getRomanNumeral(int number, String unit, String next, String middle) {
        String romanNumeral = "";

        if (number != 4 && number != 9) {
            int numberUnits = number;

            if (number >= 5) {
                numberUnits = number - 5;
                romanNumeral = middle;
            }

            for (int i = 0; i < numberUnits; i++) {
                romanNumeral += unit;
            }
        } else if (number == 4) {
            return unit + middle;
        } else if (number == 9) {
            return unit + next;
        }

        return romanNumeral;
    }
}
