/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaurieMOOPackage;

import java.util.Random;
import java.lang.Integer;


/**
 * File: RandomValue.java
 * Author: Arin Santry
 * Date Started: 1/31/19
 * Date Due: 2/5/19
 * Description: Methods to be used for LaurieMOO
 *              including random number generation, setting the answer,
 *              counting big and little moos, and checking for correctness
 */
public class RandomValue
{
    // constructors
    public RandomValue()
    {
        answer = new int[] {0, 0, 0, 0};
    }
 
    int[] answer; // int array for answer used globally
    static int ARRAY_SIZE = 4; // size of answer array
    
    // methods:
    /*
    * setAnswer
    * an integer is passed, checked if it is between 0000 and 9999 inclusive
    * if within range, return true and set the value as the answer
    * if not, the answer does not change and false is returned
    */
    public boolean setAnswer(int value)
    {
        int[] valueArray = intToArray(value);
        // check if there are 4 values in the array
        if (valueArray.length == ARRAY_SIZE)
        {
            // check if each value of the array are legal
            if (valueArray[0] > 0 && valueArray[0] < 9 && valueArray[1] > 0 
                && valueArray[1] < 9 && valueArray[2] > 0 && valueArray[2] < 9 
                && valueArray[3] > 0 && valueArray[3] < 9)
            {
                return true;
            }
        }
        return false;
    }
    
    /*
    * setAnswer
    * no value is passed
    * a new answer is randomly generated
    */
    public void setAnswer()
    {
        // generate a random number for the answer array       
        Random rand = new Random();
        
        for (int i = 0; i < 4; i++)
        {
            answer[i] = rand.nextInt(10);
        }
    }
    
    /*
    * getAnswer
    * returns a string containing the four-digit number
    */
    public String getAnswer()
    {
        String answerString;
        // convert the array into a single int
        int sum = arrayToInt(answer);
        Integer sumAnswer = new Integer(sum); // redundancy to make the ide happy
        answerString = sumAnswer.toString();
        return answerString;
    }
    
    /*
    * getBigMooCount
    * pass integer guess
    * return int indicating number of digits correct in value and location
    */
    public int getBigMooCount(int guess)
    {
        int[] guessArray = intToArray(guess);
        int count = 0;
        if (guessArray[0] == answer[0])
            count++;
        if (guessArray[1] == answer[1])
            count++;
        if (guessArray[2] == answer[2])
            count++;
        if (guessArray[3] == answer[3])
            count++;
        return count;
    }
    
    /*
    * getLittleMooCount
    * pass integer guess
    * return int indicating number of digits correct in value but not location
    */
    public int getLittleMooCount(int guess)
    {
        int[] guessArray = intToArray(guess);
        boolean[] isAnswerCounted = {false, false, false, false};        
        // isAnswerCounted[] - prevent double counting numbers
        int count = 0;
        if ((guessArray[0] == answer[1] || guessArray[0] == answer[2] || 
             guessArray[0] == answer[3]) && guessArray[0] != answer[0])
        {
            if (guessArray[0] == answer[1] && guessArray[1] != answer[1] 
                && !isAnswerCounted[1])
            {
                count++;
                isAnswerCounted[1] = true;
            }
            else if (guessArray[0] == answer[2] && guessArray[2] != answer[2] 
                     && !isAnswerCounted[2])
            {
                count++;
                isAnswerCounted[2] = true;
            }
            else if (guessArray[0] == answer[3] && guessArray[3] != answer[3] 
                     && !isAnswerCounted[3])
            {
                count++;
                isAnswerCounted[3] = true;
            }
        }
        if ((guessArray[1] == answer[0] || guessArray[1] == answer[2] ||
             guessArray[1] == answer[3]) && guessArray[1] != answer[1])
        {
            if (guessArray[1] == answer[0] && guessArray[0] != answer[0] 
                && !isAnswerCounted[0])
            {
                count++;
                isAnswerCounted[0] = true;
            }
            else if (guessArray[1] == answer[2] && guessArray[2] != answer[2] 
                     && !isAnswerCounted[2])
            {
                count++;
                isAnswerCounted[2] = true;
            }
            else if (guessArray[1] == answer[3] && guessArray[3] != answer[3] 
                     && !isAnswerCounted[3])
            {
                count++;
                isAnswerCounted[3] = true;
            }
        }
        if ((guessArray[2] == answer[0] || guessArray[2] == answer[1] || 
             guessArray[2] == answer[3]) && guessArray[2] != answer[2])
        {
            if (guessArray[2] == answer[0] && guessArray[0] != answer[0] 
                && !isAnswerCounted[0])
            {
                count++;
                isAnswerCounted[0] = true;
            }
            else if (guessArray[2] == answer[1] && guessArray[1] != answer[1] 
                     && !isAnswerCounted[1])
            {
                count++;
                isAnswerCounted[1] = true;
            }
            else if (guessArray[2] == answer[3] && guessArray[3] != answer[3] 
                     && !isAnswerCounted[3])
            {
                count++;
                isAnswerCounted[3] = true;
            }
        }
        if ((guessArray[3] == answer[0] || guessArray[3] == answer[1] || 
             guessArray[3] == answer[2]) && guessArray[3] != answer[3])
        {
            if (guessArray[3] == answer[0] && guessArray[0] != answer[0] 
                && !isAnswerCounted[0])
            {
                count++;
                isAnswerCounted[0] = true;
            }
            else if (guessArray[3] == answer[1] && guessArray[1] != answer[1] 
                     && !isAnswerCounted[1])
            {
                count++;
                isAnswerCounted[1] = true;
            }
            else if (guessArray[3] == answer[2] && guessArray[2] != answer[2] 
                     && !isAnswerCounted[2])
            {
                count++;
                isAnswerCounted[2] = true;
            }
        }
        return count;
    }
    
    /*
    * isCorrectGuess
    * pass integer guess
    * return boolean indicating whether the guess matches the answer
    */
    public boolean isCorrectGuess(int guess)
    {
        int[] guessArray = intToArray(guess);
        if (guessArray[0] == answer[0] && guessArray[1] == answer[1] && 
            guessArray[2] == answer[2] && guessArray[3] == answer[3])
            return true;
        else
            return false;
    }
    
    /*
    * intToArray
    * change an int to an int array
    * pass int, return int[]
    */
    public int[] intToArray(int num)
    {
        int[] intArray = new int[] {0, 0, 0, 0};
        intArray[3] = num % 10;
        num = num / 10;
        intArray[2] = num % 10;
        num = num / 10;
        intArray[1] = num % 10;
        num = num / 10;
        intArray[0] = num;
        return intArray;
    }
    
    /*
    * arrayToInt
    * convert and int array into an int
    * pass int[], return int
    */
    public int arrayToInt(int[] array)
    {
        int sum;
        sum = array[3];
        sum += array[2] * 10;
        sum += array[1] * 100;
        sum += array[0] * 1000; 
        return sum;
    }
}

