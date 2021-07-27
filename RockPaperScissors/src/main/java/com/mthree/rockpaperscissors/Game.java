/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 27 Jul 2021
 */
package com.mthree.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class Game {
    private static final Scanner inputReader = new Scanner(System.in);
    
    /**
     * Prompts the user how many rounds of rock paper scissors to play
     * Plays rock paper scissors
     * Gives the user the results
     * @param args  the ignored command line arguments
     */
    public static void main(String[] args) {
        int totalRounds, roundResult, wins, ties, losses;
        
        totalRounds = 0;
        wins = 0;
        ties = 0;
        losses = 0;
        
        // Get the number of rounds
        do {
            System.out.println("How many rounds do you want to play? (Minimum: 1, Maximum: 10)");
            try {
                totalRounds = Integer.parseInt(inputReader.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
        } while ((totalRounds < 1) || (totalRounds > 10));
        
        // Run each round
        for (int round = 0; round < totalRounds; round++) {
            roundResult = runRound();
            
            // Get the round's results
            switch (roundResult) {
                case 0:
                    wins++;
                    break;
                case 1:
                    ties++;
                    break;
                case 2:
                    losses++;
                    break;
            }
        }
        
        // Output final results
        System.out.println("\nWins: " + wins + "\nTies: " + ties + "\nLosses: " + losses);
        return;
    }
    
    /**
     * Runs a round of rock paper scissors
     * 0 - win
     * 1 - tie
     * 2 - loss
     * @return  the player's result from the round
     */
    private static int runRound() {
        int playerChoice, botChoice;
        
        playerChoice = getPlayerChoice();
        botChoice = getBotChoice();
        
        // Gets the results between the two choices
        if ((playerChoice > botChoice) || ((playerChoice == 0) && (botChoice == 2))) {
            System.out.println("You won");
            return 0;
        } else if (playerChoice == botChoice) {
            System.out.println("You tied");
            return 1;
        } else {
            System.out.println("You lost");
            return 2;
        }
    }
    
    /**
     * Gets the bot's choice for a round
     * 0 - rock
     * 1 - paper
     * 2 - scissors
     * @return  the value of the bot's choice for a round
     */
    private static int getBotChoice() {
        int choice;
        
        Random rand = new Random();
        choice = rand.nextInt(3);
        
        System.out.println("\nThe bot selected " + choiceValueToName(choice));
        return choice;
    }
    
    /**
     * Gets the player's choice for a round
     * @return  the value of the player's choice
     */
    private static int getPlayerChoice() {
        String input;
        int choice;
        
        do {
            System.out.println("\nRock, Paper, or Scissors?");
            input = inputReader.nextLine();
            
            choice = choiceNameToValue(input);
        } while (choice < 0);
        
        return choice;
    }
    
    /**
     * Converts the name of a choice to the value of a choice
     * 0 - rock
     * 1 - paper
     * 2 - scissors
     * -1 - invalid name
     * @param name  the name of the choice
     * @return  the value of the choice
     */
    private static int choiceNameToValue(String name) {
        switch (name.toLowerCase()) {
            case "rock":
                return 0;
            case "paper":
                return 1;
            case "scissors":
                return 2;
            default:
                return -1;
        }
    }
    
    /**
     * Converts the value of a choice to the name of a choice
     * @param value the value of the choice
     * @return  the name of the choice
     */
    private static String choiceValueToName(int value) {
        switch (value) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return null;
        }
    }
}
