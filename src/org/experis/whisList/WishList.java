package org.experis.whisList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Gift> wishlist = new ArrayList<>();

        boolean continueAdding = true;
            while(continueAdding) {
            System.out.print("Enter the name of the gift to add to the list: ");
            String giftName = scanner.nextLine();
            Gift gift = new Gift(giftName);
            wishlist.add(gift);
            System.out.println("Length of the list: " + wishlist.size());
            System.out.print("Do you want to add another gift? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                continueAdding = false;
            }
        }

        // Sort the list
            Collections.sort(wishlist, (g1, g2) -> g1.getName().compareTo(g2.getName()));

        // Print the sorted list
            System.out.println("\nSorted list of gifts:");
            for(Gift gift : wishlist) {
            System.out.println(gift.getName());
        }
    }
}

