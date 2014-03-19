package StringManipulation;

import java.util.*;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: neel
 * Date: 11/25/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringManipulation {


    /*
        atoi function to convert string integer representation to integer
    */

    public static int atoi(String input)
    {
        //base case to check for empty string
        if(input.length() == 0)
            return 0;

        char [] input_array = input.toCharArray();
        boolean isNeg = false;
        int iterator = 0;
        int length = input_array.length;
        int result = 0;

        //check for if it is a negative number
        if(input_array[0] == '-')
        {
            isNeg = true;
            iterator = iterator + 1;
        }

        //iterate through array to get number
        for(int i = iterator; i<length; i++)
        {
            //move each digit forward
            result = result*10;
            result = result + (input_array[i] - '0');
        }

        //make changes if number is negative
        if(isNeg)
            result = result*(-1);

        return result;

    }



    /*
        GIVEN AN ARRAY OF STRINGS RETURNS ALL LISTS OF ANAGRAMS GROUPED TOGETHER
     */
    public static ArrayList<ArrayList<String>> anagrams(String[] strs) {

        ArrayList<ArrayList<String>> anas = new ArrayList<ArrayList<String>>();

        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();


        for(int i = 0; i<strs.length; i++)
        {
            //manipulation of string
            String input = strs[i];
            char [] s = input.toCharArray();
            Arrays.sort(s);
            String sorted = new String(s);


            if(map.containsKey(sorted))
            {
                ArrayList<String> original = map.get(sorted);
                //just add new string since original is already stored
                original.add(input);
                map.put(sorted,original);
            }
            else
            {
                ArrayList<String> mapped = new ArrayList<String>();
                mapped.add(input);
                map.put(sorted,mapped);


            }
        }

        for (String key :map.keySet())
        {
            ArrayList<String> anagrams = map.get(key);
            if(anagrams.size() >= 2)
                anas.add(anagrams);
        }


        return anas;

    }






    /*
        CHECK WHETHER ONE STRING IS A ROTATION OF ANOTHER STRING
     */
    public static boolean checkRotation(char [] input, char [] rotatedString)
    {
        if(input.length != rotatedString.length)
            return false;

        int marker_end = 0;
        int marker_begin = 0;

        for(int i = 0; i<input.length; i++)
        {
            //we found potential beginning
            if(rotatedString[i] == input[0])
            {
                marker_end = i;

                for(int j = i; j<rotatedString.length; j++)
                {
                    if(rotatedString[j] != input[j-i])
                        return false;
                }

                marker_begin = rotatedString.length - marker_end;

                for(int k = 0; k<marker_end; k++)
                {
                    if(rotatedString[k] != input[k+marker_begin])
                        return false;
                }

                return true;


            }
        }

        return false;
    }



    /*
        REVERSES THE ORDER OF WORDS IN A SENTENCE WITHOUT REVERSING THE WORDS
     */
    public static String reverse(String rev)
    {
        char [] input = rev.toCharArray();

        //initially reverse string
        for(int i = 0; i<input.length/2; i++)
        {
            int endpoints = input.length-1-i;
            char temp = input[i];
            input[i] = input[endpoints];
            input[endpoints] = temp;
        }

        System.out.println(new String(input));

        int marker = 0;

        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i<input.length; i++)
        {
            if(input[i] == ' ')
            {
                for(int j = marker; j < i; j++)
                {
                    System.out.println(input[j]);
                    stack.push(input[j]);
                }

                while(marker != i)
                {
                    input[marker] = stack.pop();
                    System.out.println(input[marker]);
                    marker = marker + 1;
                }

                marker++;
            }
        }



        String ret = new String(input);
        System.out.println(ret);
        return ret;

    }


    //reverse a string
    public static String Reverse(String input){
        //turn into array
        char [] input_string = input.toCharArray();
        for(int i = 0; i < input_string.length/2; i++)
        {
            char temp = input_string[i];
            input_string[i] = input_string[input_string.length - 1 - i];
            input_string[input_string.length - 1 - i] = temp;
        }

        String n = Arrays.toString(input_string);
        System.out.print(n);
        return n;

    }

    //check if string is a palindrome
    public static boolean PalindromeChecker(String input)
    {
        char [] in = input.toCharArray();
        for(int i = 0; i < in.length/2; i++)
        {
            if(in[i] == in[in.length-1-i])
                continue;
            else
                return false;
        }

        return true;
    }


    //check if a string has all unique characters
    public static boolean uniqueStringChecker(String input)
    {
        java.util.HashMap<Character,Boolean> map = new HashMap<Character,Boolean>();
        //change string into array of chars
        char [] input_array = input.toCharArray();

        for(int i = 0; i<input_array.length; i++)
        {
            char in = input_array[i];
            //if key already exists then it must already be mapped
            if(map.containsKey(in))
                return false;
            else
                //add it to the hashmap
                map.put(in,true);

        }

        //print out each entry in hashmap to check
        for(Map.Entry entry : map.entrySet()){
           System.out.println("Key: "+ entry.getKey() + " Value: " + entry.getValue());
        }

        //we didn't find any repeat characters
        return true;

    }


    //print out all permuations of a string
    //begin is index to start permuatations
    //WRONG STILL NEEDS WORK
    public static void anagramGenerator(char [] input, int begin)
    {
        //base case
        if(begin == input.length-1)
            return;

        //iterate through array changing each character with begin position
        for(int i = begin; i<input.length; i++)
        {
            char [] permutation = input;
            permutation[begin] = input[i];
            permutation[i] = input[begin];
            System.out.println(permutation);
            anagramGenerator(permutation,begin+1);
        }
    }



    //print out all possible anagrams of a given string
    //WRONG STILL NEEDS WORK
    public static void anagramMaker(String input)
    {
        //what position in char array we will begin iterations
        int begin = 0;
        while(begin != input.length())
        {
            for(int i = begin; i<input.length(); i++)
            {
                char [] input_array = input.toCharArray();
                char temp = input_array[begin];
                input_array[begin] = input_array[i];
                input_array[i] = temp;
                System.out.println(Arrays.toString(input_array));
            }

            begin++;

        }

    }


    //checks if two words are anagrams of each other
    public static boolean anagramChecker(String word1, String word2)
    {
        //if two words aren't same length they can't be anagrams
        if(word1.length() != word2.length())
            return false;

        //change to arrays
        char [] word1_array = word1.toCharArray();
        char [] word2_array = word2.toCharArray();

        //create HashMap to save the characters
        HashMap<Character,Boolean> map = new HashMap<Character,Boolean>();

        //map out characters from first word
        for(int i = 0; i<word1_array.length; i++)
            map.put(word1_array[i],true);

        //check if all the characters from second word are in the hashmap
        for(int j = 0; j<word2_array.length; j++)
        {
            if(!map.containsKey(word2_array[j]))
                return false;
        }

        //means that word2 contains all characters in word1
        return true;

    }

}
