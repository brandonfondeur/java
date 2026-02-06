package com.fondeur;
import java.util.Scanner;
/*
 * An interactive program that allows the user to encode messages using the Caesar Cypher
 * 
 * @author Brandon Fondeur
 */

public class Cypher
{
    /*
     * A method that encodes a String using the rules of a Ceasar Cipher
     * @param String message    The message to be encoded
     * @param char[] charSet    Array of characters to be used as our alphabet
     * @param int key           The number each character will be shifted
     * @return an encoded String 
     */
    public static String encode(String message, char[] charSet, int key)
    {
        String output = "";
        for(int i = 0; i < message.length(); i++)
        {
            int index = -1;
            for(int z = 0; z < charSet.length; z++)
            {
                if(charSet[z] == message.toCharArray()[i])
                {
                    index = z;
                    break;
                }
            }
            if(index == -1)
            {
                output += message.toCharArray()[i];
            }
            else
            {
                int ch = (index+key) % charSet.length;
                if(ch < 0)
                {
                    ch += charSet.length;
                }
                output += charSet[ch];
            }
        }
        return output;
    }
    /*
     * A method that decodes a String using the rules of a Ceasar Cipher
     * @param String encodedMessage     The message to be decoded
     * @param char[] charSet            Array of characters to be used as our alphabet
     * @param int key                   The number each character will be shifted
     * @return a decoded String 
     */
    public static String decode(String encodedMessage, char[] charSet, int key)
    {
        return encode(encodedMessage ,charSet, -key);
    }

    public static void main(String[] args) 
    {
        //-------------------
        char[] charSet = new char[94];

        // populates charSet with the visible ASCII characters from 33 to 126

        // e.g. a-z A-Z 0-9 !@#$%^&*() etc.

        for (int i = 33; i < 127; i++) 
        {

            charSet[i - 33] = (char) i;

        }
        System.out.println("sdsdd");
        decode("b ef M QIJj", charSet, 1);
        Scanner scan = new Scanner(System.in);
        boolean invalid = false;
        boolean quit = false;
        while(quit == false)  //While the user does NOT want to quit the game.
        {
            System.out.println("Welcome to Ceasar Cipher!\nEnter 1 to encode a message,\n 2 to decode a message,\n or 0 to quit.");
            int gameNum = scan.nextInt();
            scan.nextLine();
            switch(gameNum)
            {
                case 0:     //Quitting the game
                System.out.println("Closing game...");
                quit = true;
                break;

                case 1:
                System.out.println("Please enter a message to encode.  *Message cannot be empty");
                String message = scan.nextLine();
                if(message.equals("") || message == null)
                {
                    System.out.println("Invalid message.  Returning to menu...");
                    break;
                }
                else
                {
                    System.out.println("Enter a key to encode the message with.");
                    int key = scan.nextInt();
                    scan.nextLine();
                    if(key < 0)
                    {
                        System.out.println("Invalid integer.  Returning to menu...");
                        break;
                    }
                    else
                    {
                        System.out.println(encode(message, charSet, key));
                        break;
                    }
                }

                case 2:
                System.out.println("Please enter a message to decode.  *Message cannot be empty");
                message = scan.nextLine();
                if(message.equals("") || message == null)
                {
                    System.out.println("Invalid message.  Returning to menu...");
                    break;
                }
                else
                {
                    System.out.println("Enter a key to decode the message with.");
                    int key = scan.nextInt();
                    scan.nextLine();
                    if(key < 0)
                    {
                        System.out.println("Invalid integer.  Returning to menu...");
                        break;
                    }
                    else
                    {
                        System.out.println(decode(message, charSet, key));
                        break;
                    }
                }

                default:
                System.out.println("Invalid number.  Returning to menu...");
            }
        }
    }
}