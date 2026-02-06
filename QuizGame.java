package com.fondeur;
import java.util.Random;
import java.util.Scanner;
/*
 * A quiz game that tests the user's knowledge of converting between base 10 (decimal) numbers and base 2 (binary) numbers.
 * 
 * 
 * @author
 */
public class QuizGame 
{
    /*
     * Takes a string of a binary number to be converted into a 
     * whole number (integer)
     * @param s Binary number as a String
     * @return an Integer equivalent to the binary number.
     */
    public static int binToInt(String s)
    {
        int output = 0;
        int pow = 0;
        int sLength = s.length() - 1;
        for(int x = sLength; x >= 0; x--)
        {
            if(s.charAt(x) == '1')
            {
                output += Math.pow(2, pow);
            }
            pow++;
        }

        return output;
    }
    /*
     * Takes an integer of  to be converted into a 
     * binary number.
     * @param decimal The whole number inputed to be converted.
     * @return A String of a binary number equivalent to the inputed whole number.
     */
    public static String intToBin(int decimal)
    {
        String output = "";
        int pow = 7;
        int powDEC = 128;

        for(int x = 7; x >= 0; x--)
        {
            if(decimal >= Math.pow(2,x))
            {
                output = output + "1";
                decimal -= Math.pow(2,x);
            }
            else if(output.contains("1"))
            {
                output = output + "0";
            }
        }

        return output;
    }
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        /* 
        System.out.println("Please enter a binary number, 8 digits, 1's and 0's only.");
        String s = scan.nextLine();
        int response = binToInt(s);
        System.out.println("Your binary number system is equal to " + response);
        System.out.println("Please input a whole number to be converted into binary");
        int z = scan.nextInt();
        scan.nextLine();
        System.out.println(intToBin(z));
        */
        int points = 0;
        int q1Plays = 0;
        int q2Plays = 0;
        while(q1Plays < 3 || q2Plays < 2)
        {
            Random random = new Random();

            int answer = random.nextInt(0,256);
            String answerBin = intToBin(answer);
            
            if(q1Plays < 3)
            {
                System.out.println("Please convert this binary number into a whole number: " + answerBin);
                int resp = scan.nextInt();  
                scan.nextLine();
                if(resp == answer)
                {
                    System.out.println("Correct! +16 Points");
                    points += 16;
                    System.out.println("Current points: " + points);
                }
                else
                {
                    System.out.println("Incorrect, the correct answer was " + answer);
                    System.out.println("Current points: " + points);
                }
                q1Plays++;
            }
            else
            {
                System.out.println("Please convert this number into binary form: " + answer);
                String resp = scan.nextLine();
                if(resp.equals(answerBin))
                {
                    System.out.println("Correct! +26 Points");
                    points += 26;
                    System.out.println("Current points: " + points);
                }
                else
                {
                    System.out.println("Incorrect, the correct answer was " + answerBin);
                    System.out.println("Current points: " + points);
                }
                q2Plays++;
            }
        }
        double percent = ((double)points/100)*100;
        if(percent == 100.0)
        {
            
            System.out.println("Congratulations, you won!  You ended up with: " + percent + " % of 100 points.");
        }
        else
        {
            System.out.println("Sucks, you lost.  You ended up with: " + percent + " % of 100 points.");
        }
    }
}