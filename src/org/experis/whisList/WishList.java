package org.experis.whisList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creo una lista di Gift e gli inserisco una lista creata con il medoto static readFromFile()
        List<Gift> wishlist = readFromFile();

        boolean continueAdding = true;
        while (continueAdding) {
            System.out.print("Enter the name of the gift to add to the list: ");
            String giftName = scanner.nextLine();
            Gift gift = null;
            try {
                gift = new Gift(giftName);
            } catch (RuntimeException e) {
                System.out.println("Invalid gift name. Please enter a valid name.");
                continue;
            }
            wishlist.add(gift);
            System.out.println("Length of the list: " + wishlist.size());
            System.out.print("Do you want to add another gift? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                continueAdding = false;
            }
        }

        // Sort the list
        Collections.sort(wishlist);

        // Save list
        saveToFile(wishlist);

        // Print the sorted list
        System.out.println("\nSorted list of gifts:");
        for (Gift gift : wishlist) {
            System.out.println(gift);
        }
    }

    private static List<Gift> readFromFile() {
        List<Gift> wishlist = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File("./resources/data.txt"))) {
            while (fileReader.hasNextLine()) {
                wishlist.add(new Gift(fileReader.nextLine()));
            }
            System.out.println("Wishlist loaded from file.");
        } catch (IOException e) {
            System.out.println("Unable to open file");
        }
        return wishlist;
    }

    private static void saveToFile(List<Gift> wishlist) {
        try (FileWriter fileWriter = new FileWriter(new File("./resources/data.txt"))) {
            for (Gift gift : wishlist) {
                fileWriter.write(gift.getName() + "\n"); // Write each gift name followed by a newline character
            }
            System.out.println("Wishlist saved to file.");
        } catch (IOException e) {
            System.out.println("Unable to open file");
        }

    }
}

