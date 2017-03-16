/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.input;

import funwithsearchingandsorting.bll.exceptions.MyValidationException;
import java.util.Arrays;

/**
 *
 * @author pgn
 */
public class InputConverter
{

    public static int[] getArrayLengthsFromInput(String input) throws MyValidationException
    {
        String[] splitted = input.split(",");
        int[] lengths = new int[splitted.length];
        for (int i = 0; i < lengths.length; i++)
        {
            try
            {
                lengths[i] = Integer.parseInt(splitted[i].trim());
            } catch (NumberFormatException ne)
            {
                throw new MyValidationException("The input : \"" + splitted[i] + "\" could not be parsed as a valid length (Integer).", ne);
            }
        }
        Arrays.sort(lengths);
        return lengths;
    }

}
