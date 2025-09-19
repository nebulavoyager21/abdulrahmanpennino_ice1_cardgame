/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * 
 * Modified by: Abdul Rahman Pennino
 * Student Number: 991694395
 * Date Modified: 2025-09-19
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        String[] suits = Card.SUITS;
        Random rand = new Random();
        
        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            
            // Set random value 1-13
            int value = rand.nextInt(13) + 1;
            c.setValue(value); //c.setValue(insert call to random number generator here)
            
            // Set random suit
            int suitIndex = rand.nextInt(4);
            c.setSuit(suits[suitIndex]); //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            
            magicHand[i] = c;
            
            // Print the card
            System.out.println(c.getSuit() + " " + c.getValue());
        }
        
        //insert code to ask the user for Card value and suit, create their card
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = input.nextInt();
        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Spades, 3=Clubs): ");
        int suitIndex = input.nextInt();
        String userSuit = suits[suitIndex];
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // and search magicHand here
        boolean found = false;
        for (int i = 0; i < magicHand.length; i++) {
            Card c = magicHand[i];
            if (c.getValue() == userCard.getValue() && c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        //Then report the result here
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        // add one luckcard hard code 2,clubs
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        
        boolean luckyFound = false;
        for (int i = 0; i < magicHand.length; i++) {
            Card c = magicHand[i];
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }
        
        if (luckyFound) {
            System.out.println("Lucky card is in the magic hand!");
        } else {
            System.out.println("Lucky card is not in the magic hand.");
        }
        
        input.close();      
    
    }
}