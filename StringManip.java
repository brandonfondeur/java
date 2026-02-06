package com.fondeur;
import java.util.Scanner;
/*
 * A program that allows the user to manipulate an inputted String in 4 ways.
 * 
 * @author Brandon Fondeur
 */
public class StringManip
{
    /*
     * Takes a String and abbreviates it into a capitalized acronym. Ex: A funny dog = AFD
     * @param sentence - a String
     * @return an  abbreviated String
     */
    public static String abbreviate(String sentence)
    {
        if(sentence == null)
        {
            return "";
        }
        StringBuilder outputBuild = new StringBuilder(sentence.strip());
        String output = "";
        while(outputBuild.length() != 0)
        {
            output += outputBuild.charAt(0);
            if(outputBuild.indexOf(" ") != -1)
            {
                outputBuild.delete(0,outputBuild.indexOf(" ")+1);
            }
            else
            {
                break;
            }
        }
        
        return output.toUpperCase();
    }
    /*
     * Takes a String and removes duplicate characters throughout the String so that each character within the String is unique.
     * @param sentence - a String
     * @return a String with unique characters.
     */
    public static String makeUnique(String sentence)
    {
        if(sentence == null)
        {
            return "";
        }
        StringBuilder outputBuild = new StringBuilder(sentence);

        for(int x = 0; x < outputBuild.length(); x++)
        {
            int ind = 0;
            while(ind < outputBuild.length())
            {
                if(outputBuild.charAt(x) == outputBuild.charAt(ind) && ind != x)
                {
                    outputBuild.deleteCharAt(ind);
                    ind = 0;
                }
                ind++;
            }
        }
        return outputBuild.toString();
    }
    /*
     * Determines if a String is palindromic (spelled the same way in reverse)
     * @param sentence - a String
     * @return a boolean which states if the inputted String is palindromic.
     */
    public static boolean isPalindromic(String sentence)
    {
        if(sentence == null)
        {
            return false;
        }
        else if(sentence.equals(""))
        {
            return true;
        }
        boolean output = false;
        StringBuilder outputBuild = new StringBuilder(sentence.strip());
        while(outputBuild.indexOf(" ") != -1)
        {
            outputBuild.deleteCharAt(outputBuild.indexOf(" "));
        }
        String sentenceCheck = outputBuild.toString(); //Compare
        String reverseSentence = (outputBuild.reverse()).toString(); //Compare
        if(reverseSentence.equals(sentenceCheck.toString()))
        {
            output = true;
        }
        return output;
    }
    /*
     * Makes a String where each word in the String starts with a capital letter
     * @param sentence - a String
     * @return a String where each word in the sentence starts with a capital letter.
     */
    public static String titleCase(String sentence)
    {
        if(sentence == null)
        {
            return "";
        }
        else if(sentence.equals(""))
        {
            return "";
        }
        StringBuilder outputBuild = new StringBuilder(sentence);
        StringBuilder outputBuildEmpty = new StringBuilder();
        int x = 0;
        while(outputBuild.length() != outputBuildEmpty.length())
        {
            if(x == 0)
            {
                outputBuildEmpty.append(("" + outputBuild.charAt(x)).toUpperCase());
            }
            else if(outputBuild.charAt(x-1) == ' ')
            {
                outputBuildEmpty.append(("" + outputBuild.charAt(x)).toUpperCase());
            }
            else
            {
                outputBuildEmpty.append(("" + outputBuild.charAt(x)).toLowerCase());
            }
            x++;
        }
        return outputBuildEmpty.toString();
    }
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string to be manipulated.");
        String response = scan.nextLine();
        System.out.println("Abbreviated: " + abbreviate(response));
        System.out.println("makeUnique: " + makeUnique(response));
        System.out.println("isPalindromic: " + isPalindromic(response));
        System.out.println("titleCase: " + titleCase(response));
    }
}