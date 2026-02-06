package com.fondeur;
import java.util.Scanner;
/*
 * An interactive program that simulates a generic election, outputting each candidate, the number of and 
 * percentage of total votes they received, and the winner of the election.
 * 
 * @author Brandon Fondeur
 */
public class Election
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        boolean finish = false;
        boolean invalid = false;
        double totalVotes = 0;

        System.out.println("Enter the number of candidates."); 
        int responseNum = scan.nextInt();
        scan.nextLine();
        if(responseNum <= 0)
        {
            invalid = true;
        }
        while(invalid == true)
        {
            System.out.println("Invalid number, please enter the number of candidates."); 
            responseNum = scan.nextInt();
            scan.nextLine();
            if(responseNum > 0)
            {
                invalid = false;
            }
        }
        int[] votes = new int[responseNum];
        String[] names = new String[responseNum];
        int index = 0;
        while(index < names.length)
        {
            
            System.out.println("Please enter candidate " + index + "'s name.");
            String response = scan.nextLine();
            if(response.equals("") || response == null)
            {
                invalid = true;                
            }
            while(invalid == true)
            {
                System.out.println("Invalid name, please enter candidate " + index+1 + "'s name.");
                response = scan.nextLine();
                if(response.equals("") || response == null)
                {
                    invalid = true;
                }
                else
                {
                    invalid = false;
                }
            }
            names[index] = response;
            System.out.println("Please enter the number of votes gained by " + names[index]);
            int responseVotes = scan.nextInt();
            scan.nextLine();
            totalVotes += responseVotes;
            votes[index] = responseVotes;
            index++;
        }
        int winner = 0;
        String winnerName = names[winner];
        int maxVotes = votes[winner];
        for(index = 0; index < names.length-1; index++)
        {
            if(votes[index+1] > votes[index])
            {
                winner = index+1;
                winnerName = names[winner];
                maxVotes = votes[winner];
            }
        }

        System.out.println("Election Results:");
        for(index = 0; index < names.length; index++)
        {
            double votePrint = ((double)votes[index] / totalVotes) * 100;
            System.out.printf(names[index] + " received " + votes[index] + " votes (%.2f%% of total votes)\n", votePrint);
        }
        System.out.println(winnerName + " is the winner  with " + maxVotes + " votes");

    }
}