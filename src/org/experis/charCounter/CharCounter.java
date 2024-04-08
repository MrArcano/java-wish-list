package org.experis.charCounter;

import java.util.*;

public class CharCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una parola: ");
        String parola = scanner.nextLine();

        // Creiamo una HashMap per memorizzare i caratteri e le loro occorrenze
        Map<Character, Integer> conteggioOccorrenze = new HashMap<>();

        // Contiamo le occorrenze dei caratteri nella parola
        for (char c : parola.toCharArray()) {
            conteggioOccorrenze.put(c, conteggioOccorrenze.getOrDefault(c, 0) + 1);
        }

        // Stampiamo i risultati ciclando sul set delle chiavi
        for (char carattere : conteggioOccorrenze.keySet()) {
            System.out.println("* " + carattere + ":" + conteggioOccorrenze.get(carattere));
        }
    }

}
